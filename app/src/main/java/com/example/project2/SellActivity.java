package com.example.project2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.project2.DB.Database;
import com.example.project2.DB.UserDAO;
import com.example.project2.Entity.Item;
import com.example.project2.databinding.ActivitySellBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class SellActivity extends AppCompatActivity {
    private static final String USER_ID_KEY = "com.example.project2.SellActivity.userIdKey";
    ListView mListView;
    FloatingActionButton mAddButton;
    ActivitySellBinding binding;

    int mUserId;

    UserDAO mUserDAO;
    ArrayList<Item> mArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell);

        binding = ActivitySellBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mListView = binding.sellItems;
        mUserDAO = Database.getDatabase(getApplicationContext());
        mUserId = getIntent().getIntExtra(USER_ID_KEY, -1);
        refreshPage();

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Item item = mArrayList.get(i);
                int itemId = item.getItemId();
                Intent intent = ModifySellActivity.intentFactory(getApplicationContext(), itemId);
                startActivity(intent);
            }
        });

        mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Item item = mArrayList.get(i);
                mUserDAO.deleteItem(item);
                Toast.makeText(getApplicationContext(), item.getName() + " is deleted", Toast.LENGTH_SHORT).show();
                refreshPage();
                return true;
            }
        });

        mAddButton = binding.addIcon;
        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = NewSellActivity.intentFactory(getApplicationContext(), mUserId);
                startActivity(intent);
            }
        });
    }

    public static Intent intentFactory(Context context, int userId) {
        Intent intent = new Intent(context, SellActivity.class);
        intent.putExtra(USER_ID_KEY, userId);
        return intent;
    }

    private void userDisplay() {
        if (mArrayList.size() >= 1) {
            ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, mArrayList);
            mListView.setAdapter(arrayAdapter);
        }
    }

    private void refreshPage() {
        mArrayList = (ArrayList<Item>) mUserDAO.getAllItemsByUserId(mUserId);
        userDisplay();
    }
}