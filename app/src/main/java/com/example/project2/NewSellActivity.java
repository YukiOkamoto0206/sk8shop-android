package com.example.project2;

import static java.lang.Double.parseDouble;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.project2.DB.Database;
import com.example.project2.DB.UserDAO;
import com.example.project2.Entity.Item;
import com.example.project2.databinding.ActivityNewSellBinding;

public class NewSellActivity extends AppCompatActivity {
    private static final String USER_ID_KEY = "com.example.project2.NewSellActivity.userIdKey";

    ActivityNewSellBinding binding;
    EditText mDeckEditText;
    EditText mSizeEditText;
    EditText mPriceEditText;
    Button mAddButton;

    UserDAO mUserDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_sell);

        binding = ActivityNewSellBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int userId = getIntent().getIntExtra(USER_ID_KEY, -1);

        mDeckEditText = binding.decknameEditText;
        mSizeEditText = binding.sizeEditText;
        mPriceEditText = binding.priceEditText;
        mAddButton = binding.addButton;

        mUserDAO = Database.getDatabase(getApplicationContext());

        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String deckname = mDeckEditText.getText().toString();
                String size = mSizeEditText.getText().toString();
                String price = mPriceEditText.getText().toString();
                System.out.println("size: " + size);
                if (deckname.isEmpty() || size.isEmpty() || price.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "FIll all fields", Toast.LENGTH_SHORT).show();
                } else {
                    double sizeDouble = parseDouble(size);
                    double priceDouble = parseDouble(price);
                    Item item = new Item(deckname, sizeDouble, priceDouble, userId);
                    mUserDAO.registerItem(item);
                    Toast.makeText(getApplicationContext(), "Item Registered!!!", Toast.LENGTH_SHORT).show();
                    Intent intent = SellActivity.intentFactory(getApplicationContext(), userId);
                    startActivity(intent);
                }
            }
        });
    }

    public static Intent intentFactory(Context context, int userId) {
        Intent intent = new Intent(context, NewSellActivity.class);
        intent.putExtra(USER_ID_KEY, userId);
        return intent;
    }
}