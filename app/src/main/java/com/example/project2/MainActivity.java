package com.example.project2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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

        /**
         * Check if the user is already logged in.
         * @ True -> Take to Landing Page
         * @ False -> Nothing
         */
        SharedPreferences sp = getApplicationContext().getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        int sharedPrefUserId = sp.getInt(getString(R.string.preference_userid_key), -1);
        if (sharedPrefUserId != -1) {
            Intent intent = LandingActivity.intentFactory(getApplicationContext(), sharedPrefUserId);
            startActivity(intent);
        }

        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = LoginActivity.intentFactory(getApplicationContext());
                startActivity(intent);
            }
        });

        mCreateAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = CreateAccountActivity.intentFactory(getApplicationContext());
                startActivity(intent);
            }
        });
    }

    // Change the activity to MainActivity
    public static Intent intentFactory(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }
}