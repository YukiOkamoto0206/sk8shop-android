package com.example.project2.Entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.project2.DB.AppDatabase;

@Entity(tableName = AppDatabase.ITEMS_TABLE)
public class Item {
    @PrimaryKey(autoGenerate = true)
    private int mItemId;

    private String mName;
    private double mDeckSize;
    private double mPrice;
    private int mUserId;

    public Item(String name, double deckSize, double price, int userId) {
        mName = name;
        mDeckSize = deckSize;
        mPrice = price;
        mUserId = userId;
    }

    public int getItemId() {
        return mItemId;
    }

    public void setItemId(int itemId) {
        mItemId = itemId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public double getDeckSize() {
        return mDeckSize;
    }

    public void setDeckSize(double deckSize) {
        mDeckSize = deckSize;
    }

    public double getPrice() {
        return mPrice;
    }

    public void setPrice(double price) {
        mPrice = price;
    }

    public int getUserId() {
        return mUserId;
    }

    public void setUserId(int userId) {
        mUserId = userId;
    }

    @Override
    public String toString() {
        return "ItemId: " + mItemId +
                "Name: " + mName +
                "DeckSize: " + mDeckSize +
                "Price: $" + mPrice +
                "Username: " + mUserId;
    }
}
