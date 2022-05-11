package com.example.project2.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.project2.DB.Database;
import com.example.project2.DB.UserDAO;
import com.example.project2.R;
import com.example.project2.User;

import java.util.ArrayList;

public class UsersFragment extends Fragment {
    ListView mListView;
    UserDAO mUserDAO;

    ArrayList<User> mArrayList;

    public UsersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_users, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mListView = (ListView) view.findViewById(R.id.userFragmentDisplay);
        mUserDAO = Database.getDatabase(getContext());

        refreshPage();

        mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                User clickedUser = mArrayList.get(i);
                int userId = getArguments().getInt("USER_ID_KEY_FROM_ADMIN_ACTIVITY");
                if (clickedUser.getUserId() == userId) {
                    Toast.makeText(getContext(), "Cannot delete yourself", Toast.LENGTH_SHORT).show();
                    return false;
                }
                mUserDAO.deleteUser(clickedUser);
                Toast.makeText(getContext(), clickedUser.getUsername() + " is deleted", Toast.LENGTH_SHORT).show();
                refreshPage();
                return true;
            }
        });
    }

    private void userDisplay() {
        if (mArrayList.size() >= 1) {
            ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, mArrayList);
            mListView.setAdapter(arrayAdapter);
        }
    }

    private void refreshPage() {
        mArrayList = (ArrayList<User>) mUserDAO.getAllUsers();
        userDisplay();
    }
}