package com.example.project2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.example.project2.DB.AppDatabase;
import com.example.project2.DB.UserDAO;
import com.example.project2.databinding.ActivityCreateAccountBinding;

public class CreateAccountActivity extends AppCompatActivity {

    EditText mCreateUsername;
    EditText mCreatePassword;
    Switch mIsAdminSwitch;
    Button mCreateButton;

    ActivityCreateAccountBinding binding;

    UserDAO mUserDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        binding = ActivityCreateAccountBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mCreateUsername = binding.createUsername;
        mCreatePassword = binding.createPassword;
        mCreateButton = binding.createButton;

        mUserDAO = Room.databaseBuilder(this, AppDatabase.class, AppDatabase.DATABASE_NAME)
                .allowMainThreadQueries()
                .build()
                .UserDAO();

        mIsAdminSwitch = binding.switchAdmin;
        mIsAdminSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    mIsAdminSwitch.setChecked(true);
                } else {
                    mIsAdminSwitch.setChecked(false);
                }
            }
        });

        mCreateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = mCreateUsername.getText().toString();
                String password = mCreatePassword.getText().toString();
                boolean isAdmin = mIsAdminSwitch.isChecked();
                User user = new User(name, password, isAdmin);
                if (validateInput(user)) {
                    mUserDAO.registerUser(user);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(), "User Registered!!!", Toast.LENGTH_SHORT).show();
                        }
                    });
                    setResult(RESULT_OK, getIntent());
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Fill all fields", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean validateInput(User user) {
        if (user.getUsername().isEmpty() || user.getPassword().isEmpty()) {
            return false;
        } else return true;
    }
}