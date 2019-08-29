package com.example.myfirstapplication;


import android.content.Context;
import android.util.Log;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.myfirstapplication.database.AppDatabase;
import com.example.myfirstapplication.database.ItemDao;
import com.example.myfirstapplication.utilities.SampleData;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class DatabaseTest {
    public static final String TAG = "Junit";
    private AppDatabase mDb;
    private ItemDao mDao;

    @Before
    public void createDb() {
        Context context = ApplicationProvider.getApplicationContext();
        mDb = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).build();
        mDao = mDb.itemDao();
        Log.i(TAG, "createdDb");
    }

    @After
    public void closeDb() {
        mDb.close();
        Log.i(TAG, "closeDb");
    }

    @Test
    public void createAndRetriveItems() {
        mDao.insertAll(SampleData.getItems());
        int count = mDao.getCount();
        Log.i(TAG, "createAndRetrieveItems: count = ");
        Assert.assertEquals(SampleData.getItems().size(), count);
    }
}
