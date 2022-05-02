package com.example.project2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.project2.DB.AppDatabase;
import com.example.project2.DB.UserDAO;
import com.example.project2.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {
    EditText mUsernameEditText;
    EditText mPasswordEditText;
    Button mLoginButton;

    ActivityLoginBinding binding;

    UserDAO mUserDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mUsernameEditText = binding.loginUsername;
        mPasswordEditText = binding.loginPassword;
        mLoginButton = binding.loginButton;

        mUserDAO = Room.databaseBuilder(this, AppDatabase.class, AppDatabase.DATABASE_NAME)
                .allowMainThreadQueries()
                .build()
                .UserDAO();


        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = mUsernameEditText.getText().toString();
                String password = mPasswordEditText.getText().toString();
                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "FIll all fields", Toast.LENGTH_SHORT).show();
                } else {
                    User user = mUserDAO.login(username, password);
                    if (user == null) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getApplicationContext(), "Invalid Credentials!", Toast.LENGTH_SHORT).show();
                            }
                        });
                    } else {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                // Landing page
                                Intent intent = new Intent(LoginActivity.this, LandingActivity.class);
                                intent.putExtra("user_id", user.getUserId());
                                startActivity(intent);
                            }
                        });
                    }
                }
            }
        });
    }
}