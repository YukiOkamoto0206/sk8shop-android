package com.example.project2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.project2.databinding.ActivityLoginBinding;
import com.example.project2.databinding.ActivityMainBinding;

public class LoginActivity extends AppCompatActivity {
    EditText mUsernameEditText;
    EditText mPasswordEditText;
    Button mLoginButton;

    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mUsernameEditText = binding.loginUsername;
        mPasswordEditText = binding.loginPassword;
        mLoginButton = binding.loginButton;

        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplication(), LandingActivity.class);
                startActivity(intent);
            }
        });
    }
}