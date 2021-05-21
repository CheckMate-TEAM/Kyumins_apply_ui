package com.eatx.wdj.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.eatx.wdj.R;

public class applyInfo extends Fragment {

    private MainViewModel mViewModel;
    private Intent intent;
    private String id;
    private String text;
    private String time;
    private RadioGroup radioGroup;
    private RadioButton ten, eleven, twelve;
    private String selected;

    public static applyInfo newInstance() {
        return new applyInfo();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.apply_info, container, false);
        TextView dateText = (TextView)view.findViewById(R.id.textView);
        TextView infoText = (TextView)view.findViewById(R.id.infoText);
        Button applyBtn = (Button)view.findViewById(R.id.infoApply);

        radioGroup = (RadioGroup)view.findViewById(R.id.radioGroup);
        ten = (RadioButton)view.findViewById(R.id.ten);
        eleven = (RadioButton)view.findViewById(R.id.eleven);
        twelve = (RadioButton)view.findViewById(R.id.twelve);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.ten) {
                    selected = ten.getText().toString();
                } else if (checkedId == R.id.eleven) {
                    selected = eleven.getText().toString();
                } else if (checkedId == R.id.twelve) {
                    selected = twelve.getText().toString();
                }
            }
        });

        applyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                infoText.setText(id + "님 " + text + " " + selected + " 신청되었습니다.");
                System.out.println(selected);
            }
        });

        if(getArguments() != null) {
            text = getArguments().getString("date");
            dateText.setText(text);

            time = getArguments().getString("selected");
        }
        intent = getActivity().getIntent();
        id = intent.getStringExtra("id");
        infoText.setText(id + "님 " + text + " " + time + " 신청되었습니다.");
        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        // TODO: Use the ViewModel
    }
}
