package com.example.project2.DB;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.project2.User;

@Dao
public interface UserDAO {
    @Insert
    void registerUser(User... user);

    @Query("SELECT * FROM " + AppDatabase.USERS_TABLE + " WHERE mUsername = :username and mPassword = :password")
    User login(String username, String password);

    @Query("SELECT * FROM " + AppDatabase.USERS_TABLE + " WHERE mUserId = :userId")
    User findUser(int userId);

}