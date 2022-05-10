package com.example.project2.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.project2.DB.Database;
import com.example.project2.DB.UserDAO;
import com.example.project2.R;
import com.example.project2.User;
import com.example.project2.databinding.FragmentUsersBinding;

import java.util.List;

public class UsersFragment extends Fragment {
    TextView mTextView;
    UserDAO mUserDAO;

    FragmentUsersBinding binding;


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
        mTextView = (TextView) view.findViewById(R.id.userFragmentDisplay);
        mUserDAO = Database.getDatabase(getContext());
        List<User> usersList = mUserDAO.getAllUsers();
        mTextView.setMovementMethod(new ScrollingMovementMethod());
        if (usersList.size() >= 1) {
            StringBuilder sb = new StringBuilder();
            for (User user: usersList) {
                sb.append(user.toString());
            }
            mTextView.setText(sb);
        } else {
            mTextView.setText("No users");
        }

    }
}