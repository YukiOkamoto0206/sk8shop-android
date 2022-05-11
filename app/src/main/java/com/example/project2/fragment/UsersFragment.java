package com.example.project2.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.project2.DB.Database;
import com.example.project2.DB.UserDAO;
import com.example.project2.R;
import com.example.project2.User;
import com.example.project2.databinding.FragmentUsersBinding;

import java.util.ArrayList;
import java.util.List;

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
        mArrayList = (ArrayList<User>) mUserDAO.getAllUsers();
        userDisplay();
    }

    private void userDisplay() {
        if (mArrayList.size() >= 1) {
            ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, mArrayList);
            mListView.setAdapter(arrayAdapter);
        }
    }
}