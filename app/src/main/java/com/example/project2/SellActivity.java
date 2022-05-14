package com.example.project2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.project2.DB.Database;
import com.example.project2.DB.UserDAO;

public class SellActivity extends AppCompatActivity {
    private static final String USER_ID_KEY = "com.example.project2.SellActivity.userIdKey";
    UserDAO mUserDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell);

        int userId = getIntent().getIntExtra(USER_ID_KEY, 0);
        mUserDAO = Database.getDatabase(getApplicationContext());


    }

    public static Intent intentFactory(Context context, int userId) {
        Intent intent = new Intent(context, SellActivity.class);
        intent.putExtra(USER_ID_KEY, userId);
        return intent;
    }
}