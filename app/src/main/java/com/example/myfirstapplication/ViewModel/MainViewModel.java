package com.example.myfirstapplication.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.myfirstapplication.database.AppRepository;
import com.example.myfirstapplication.database.ItemEntity;

import java.util.List;

public class MainViewModel extends AndroidViewModel {
    public LiveData<List<ItemEntity>> mItems;
    private AppRepository mRepository;

    public MainViewModel(@NonNull Application application) {
        super(application);

        mRepository = AppRepository.getInstance(application.getApplicationContext());
        mItems = mRepository.mItems;
    }

    public void addData() {
        mRepository.addData();
    }
}
