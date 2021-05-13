package com.eatx.wdj.ui.main;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.eatx.wdj.R;
import com.github.tlaabs.timetableview.Schedule;
import com.github.tlaabs.timetableview.Time;
import com.github.tlaabs.timetableview.TimetableView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SecondFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TimeTable extends Fragment {

    private Context context;
    public static final int REQUEST_ADD = 1;
    public static final int REQUEST_EDIT = 2;

    private Button addBtn;
    private Button clearBtn;
    private Button saveBtn;
    private Button loadBtn;

    private TimetableView timetable;
    private MainViewModel mViewModel;
    View inflatedview = null;
    public static TimeTable newInstance() {
        return new TimeTable();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        inflatedview =  inflater.inflate(R.layout.fragment_time_table, container, false);
//        addBtn = inflatedview.findViewById(R.id.add_btn);
//        clearBtn = inflatedview.findViewById(R.id.clear_btn);
//        saveBtn = inflatedview.findViewById(R.id.save_btn);
//        loadBtn =  inflatedview.findViewById(R.id.load_btn);

        timetable =  inflatedview.findViewById(R.id.timetable);

        ArrayList<Schedule> schedules = new ArrayList<Schedule>();
        Schedule schedule = new Schedule();
        schedule.setClassTitle("IT 직무의사소통"); // sets subject
        schedule.setClassPlace("202호"); // sets place
        schedule.setProfessorName("서희경"); // sets professor
        schedule.setStartTime(new Time(11,0)); // sets the beginning of class time (hour,minute)
        schedule.setEndTime(new Time(13,00)); // sets the end of class time (hour,minute)
        schedules.add(schedule);

        ArrayList<Schedule> schedules2 = new ArrayList<Schedule>();
        Schedule schedule2 = new Schedule();
        schedule2.setClassTitle("객체 지향 프로그래밍"); // sets subject
        schedule2.setClassPlace("211호"); // sets place
        schedule2.setProfessorName("박성철"); // sets professor
        schedule2.setStartTime(new Time(14,0)); // sets the beginning of class time (hour,minute)
        schedule2.setEndTime(new Time(16,00)); // sets the end of class time (hour,minute)
        schedules2.add(schedule2);
//.. add one or more schedules
        timetable.add(schedules);
        timetable.add(schedules2);
        timetable.setHeaderHighlight(0);
        return inflatedview;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        // TODO: Use the ViewModel
    }
    private void init(){

    }
    private void initView(){


    }


}