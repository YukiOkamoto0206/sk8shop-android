package com.example.project2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.project2.DB.AppDatabase;
import com.example.project2.DB.UserDAO;
import com.example.project2.databinding.ActivityLandingBinding;

public class LandingActivity extends AppCompatActivity {
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
        int userId = getIntent().getIntExtra("user_id", 0);

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
                // Delete userId at SharedPreference
                SharedPreferences sp = getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.remove(getString(R.string.preference_userid_key));
                editor.commit();
                Intent intent = new Intent(getApplication(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}