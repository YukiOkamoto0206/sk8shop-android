package com.example.project2.DB;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.project2.Entity.Item;
import com.example.project2.Entity.User;

import java.util.List;

@Dao
public interface UserDAO {
    /* User */
    @Insert
    void registerUser(User... user);

    @Delete
    void deleteUser(User user);

    @Query("SELECT * FROM " + AppDatabase.USERS_TABLE + " WHERE mUsername = :username and mPassword = :password")
    User login(String username, String password);

    @Query("SELECT * FROM " + AppDatabase.USERS_TABLE + " WHERE mUserId = :userId")
    User findUser(int userId);

    @Query("SELECT * FROM " + AppDatabase.USERS_TABLE)
    List<User> getAllUsers();

    /* Item */
    @Insert
    void registerItem(Item... items);

    @Delete
    void deleteItem(Item item);

    @Query("SELECT * FROM " + AppDatabase.ITEMS_TABLE + " WHERE mUserId = :userId")
    List<Item> getAllItemsByUserId(int userId);

}
