package com.eatx.wdj.ui.main;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.eatx.wdj.R;
import com.eatx.wdj.ui.login.MainActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class applySelfStudy extends Fragment {
    private MainViewModel mViewModel;
    private static long mNow;
    private static Date mDate;
    private static SimpleDateFormat mFormat = new SimpleDateFormat("yyyy년 MM월 dd일");
    private RadioGroup radioGroup;
    private RadioButton ten, eleven, twelve;
    private String selected;

    public static applySelfStudy newInstance() {
        return new applySelfStudy();
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.apply_self_study, container, false);
        Button applyBtn = (Button)view.findViewById(R.id.apply);
        TextView dateText = (TextView)view.findViewById(R.id.dateText);
        dateText.setText(getTime());

        radioGroup = (RadioGroup)view.findViewById(R.id.homeRadio);
        ten = (RadioButton)view.findViewById(R.id.ten);
        eleven = (RadioButton)view.findViewById(R.id.eleven);
        twelve = (RadioButton)view.findViewById(R.id.twelve);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.ten) {
                    selected = ten.getText().toString();
                } else if(checkedId == R.id.eleven) {
                    selected = eleven.getText().toString();
                } else if(checkedId == R.id.twelve) {
                    selected = twelve.getText().toString();
                }
            }

        });


        applyBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Bundle bundle = new Bundle();
                        bundle.putString("date", getTime());
                        bundle.putString("selected", selected);
                        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                        applyInfo applyinfo = new applyInfo();
                        applyinfo.setArguments(bundle);
                        transaction.replace(R.id.container, applyinfo);
                        transaction.commit();
            }
        });
        return view;
    }

    private static String getTime() {
        mNow = System.currentTimeMillis();
        mDate = new Date(mNow);
        return mFormat.format(mDate);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        // TODO: Use the ViewModel
    }

}
