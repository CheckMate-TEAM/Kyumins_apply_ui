package com.eatx.wdj.ui.main;

import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eatx.wdj.R;
import com.eatx.wdj.ui.login.LoginActivity;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;
    private TextView hello ;
    public static MainFragment newInstance() {
        return new MainFragment();
    }
    View inflatedview = null;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        inflatedview = inflater.inflate(R.layout.main_fragment, container, false);
        hello = (TextView)inflatedview.findViewById(R.id.text_self_auth_need);
        getUserName();
        return inflatedview;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        // TODO: Use the ViewModel
        }

    private void getUserName() {
        Intent intent = getActivity().getIntent();
        String id = intent.getStringExtra("id");
        hello.setText(id + "님 반갑습니다!");
    }



}