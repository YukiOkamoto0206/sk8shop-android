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
import com.example.project2.databinding.ActivityBuyBinding;
import com.example.project2.databinding.ActivityModifyBuyBinding;

import java.util.ArrayList;

public class ModifyBuyActivity extends AppCompatActivity {
    private static final String USER_ID_KEY = "com.example.project2.ModifyBuyActivity.userIdKey";
    UserDAO mUserDAO;
    ListView mListView;
    ArrayList<Item> mArrayList;
    ActivityModifyBuyBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);

        binding = ActivityModifyBuyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        int userId = getIntent().getIntExtra(USER_ID_KEY, 0);
        mUserDAO = Database.getDatabase(getApplicationContext());

        mListView = binding.modifyBuyItems;

        refreshPage();

        mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Item item = mArrayList.get(i);
                item.setIsPurchased(false);
                mUserDAO.updateItem(item);
                Toast.makeText(getApplicationContext(), "The purchase of " + item.getName() + " is canceled!!", Toast.LENGTH_SHORT).show();
                refreshPage();
                return true;
            }
        });

    }

    public static Intent intentFactory(Context context, int userId) {
        Intent intent = new Intent(context, ModifyBuyActivity.class);
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
        mArrayList = (ArrayList<Item>) mUserDAO.getPurchasedItems();
        userDisplay();
    }
}