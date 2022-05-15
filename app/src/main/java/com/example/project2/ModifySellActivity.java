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
import com.example.project2.databinding.ActivityModifySellBinding;

public class ModifySellActivity extends AppCompatActivity {
    private static final String ITEM_ID_KEY = "com.example.project2.ModifySellActivity.itemIdKey";

    ActivityModifySellBinding binding;
    EditText mDeckEditText;
    EditText mSizeEditText;
    EditText mPriceEditText;
    Button mModifyButton;

    UserDAO mUserDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_sell);

        binding = ActivityModifySellBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mDeckEditText = binding.decknameEditModifyText;
        mSizeEditText = binding.sizeEditModifyText;
        mPriceEditText = binding.priceEditModifyText;
        mModifyButton = binding.modifyButton;

        int itemId = getIntent().getIntExtra(ITEM_ID_KEY, -1);
        mUserDAO = Database.getDatabase(getApplicationContext());
        Item item = mUserDAO.findItem(itemId);


        mDeckEditText.setText(item.getName());
        mSizeEditText.setText(String.valueOf(item.getDeckSize()));
        mPriceEditText.setText(String.valueOf(item.getPrice()));

        // delete and add ?
        mModifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String deckname = mDeckEditText.getText().toString();
                String size = mSizeEditText.getText().toString();
                String price = mPriceEditText.getText().toString();
                if (deckname.isEmpty() || size.isEmpty() || price.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "FIll all fields", Toast.LENGTH_SHORT).show();
                } else {
                    double sizeDouble = parseDouble(size);
                    double priceDouble = parseDouble(price);
                    int userId = item.getUserId();
                    item.setName(deckname);
                    item.setDeckSize(sizeDouble);
                    item.setPrice(priceDouble);
                    mUserDAO.updateItem(item);
                    Toast.makeText(getApplicationContext(), "Item Modified!!!", Toast.LENGTH_SHORT).show();
                    Intent intent = SellActivity.intentFactory(getApplicationContext(), userId);
                    startActivity(intent);
                }
            }
        });
    }

    public static Intent intentFactory(Context context, int itemId) {
        Intent intent = new Intent(context, ModifySellActivity.class);
        intent.putExtra(ITEM_ID_KEY, itemId);
        return intent;
    }
}