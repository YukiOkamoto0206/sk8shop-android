package com.example.project2.DB;

import android.content.Context;

import androidx.room.Room;

public class Database {
    public static UserDAO getDatabase(Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, AppDatabase.DATABASE_NAME)
                .allowMainThreadQueries()
                .build()
                .UserDAO();
    }
}
