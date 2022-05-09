package com.example.project2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.project2.DB.AppDatabase;
import com.example.project2.DB.UserDAO;
import com.example.project2.databinding.ActivityLandingBinding;

public class LandingActivity extends AppCompatActivity {
    private static final String USER_ID_KEY = "com.example.project2.userIdKey";

    TextView mUsername;
    Button mAdminButton;
    Button mLogoutButton;

    ActivityLandingBinding binding;

    UserDAO mUserDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        binding = ActivityLandingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mUsername = binding.landingUsername;
        // Get userId from LastPage(MainActivity/LoginActivity)
        int userId = getIntent().getIntExtra(USER_ID_KEY, 0);

        mUserDAO = Room.databaseBuilder(this, AppDatabase.class, AppDatabase.DATABASE_NAME)
                .allowMainThreadQueries()
                .build()
                .UserDAO();

        User user = mUserDAO.findUser(userId);
        mUsername.setText(user.getUsername());

        mAdminButton = binding.landingAdmin;
        if (user.isAdmin()) {
            mAdminButton.setVisibility(View.VISIBLE);
        } else {
            mAdminButton.setVisibility(View.INVISIBLE);
        }


        // Logout
        mLogoutButton = binding.landingLogout;
        mLogoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Delete userId from SharedPreference
                PrefUtils.removeUserIdFromSharedPreference(getApplicationContext());
                Intent intent = MainActivity.intentFactory(getApplicationContext());
                startActivity(intent);
            }
        });
    }

    public static Intent intentFactory(Context context, int userId) {
        Intent intent = new Intent(context, LandingActivity.class);
        intent.putExtra(USER_ID_KEY, userId);
        return intent;
    }
}