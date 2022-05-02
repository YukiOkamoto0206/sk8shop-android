package com.example.project2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Entity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.project2.databinding.ActivityMainBinding;


//@Entity(tableName = AppData)
public class MainActivity extends AppCompatActivity {
    TextView mMainDisplay; // first letter m is for non public and non static field
    Button mLoginButton;
    Button mCreateAccountButton;

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mMainDisplay = binding.mainTitle;
        mLoginButton = binding.mainLoginButton;
        mCreateAccountButton = binding.mainCreateAccountButton;

        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplication(), LoginActivity.class);
                startActivity(intent);
            }
        });

        mCreateAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplication(), CreateAccountActivity.class);
                startActivity(intent);
            }
        });
    }
}