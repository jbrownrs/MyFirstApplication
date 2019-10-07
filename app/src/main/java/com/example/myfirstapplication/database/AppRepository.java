package com.example.myfirstapplication.database;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.myfirstapplication.utilities.SampleData;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AppRepository {
    private static AppRepository ourInstance;

    public LiveData<List<ItemEntity>> mItems;
    private AppDatabase mDb;
    private Executor executor = Executors.newSingleThreadExecutor();

    private AppRepository(Context context) {
        mDb = AppDatabase.getInstance(context);
        mItems = getAllItems();
    }

    public static AppRepository getInstance(Context context) {
        if (ourInstance == null) {
            ourInstance = new AppRepository(context);
        }
        return ourInstance;
    }

    public void addData() {
        executor.execute(() -> mDb.itemDao().insertAll(SampleData.getItems()));
    }

    private LiveData<List<ItemEntity>> getAllItems() {
        return mDb.itemDao().getAll();
    }
}
