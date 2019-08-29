package com.example.myfirstapplication.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ItemDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertItem(ItemEntity itemEntity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<ItemEntity> items);

    @Delete
    void deleteItem(ItemEntity itemEntity);

    @Query("Select * FROM items WHERE id = :id")
    ItemEntity getItemById(int id);

    @Query("Select * FROM items ORDER BY date DESC")
    LiveData<List<ItemEntity>> getAll();

    @Query("DELETE FROM items")
    int deleteAll();

    @Query("SELECT COUNT(*) FROM items")
    int getCount();
}