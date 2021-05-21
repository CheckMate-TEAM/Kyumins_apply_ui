package com.eatx.wdj.ui.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.eatx.wdj.ui.main.Board;
import com.eatx.wdj.ui.main.Check;
import com.eatx.wdj.ui.main.CheckActivity;
import com.eatx.wdj.ui.main.MainFragment;

import me.ibrahimsn.lib.OnItemSelectedListener;

import com.eatx.wdj.R;
import com.eatx.wdj.ui.main.SecondFragment;
import com.eatx.wdj.ui.main.TimeTable;
import com.eatx.wdj.ui.main.applyInfo;
import com.eatx.wdj.ui.main.applySelfStudy;

import java.text.SimpleDateFormat;
import java.util.Date;


public class MainActivity extends AppCompatActivity {
    private long backpressedTime = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        me.ibrahimsn.lib.SmoothBottomBar bottomBar = findViewById(R.id.bottomBar);
        bottomBar.bringToFront();
        bottomBar.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public boolean onItemSelect(int i) {
                switch(i) {
                    case 0: System.out.println("첫번째탭");
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.container, new MainFragment()).commit();
                    break;
                    case 1: System.out.println("두번째탭");
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.container, new SecondFragment()).commit();
                    break;
                    case 2: System.out.println("세번째탭");
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.container, new TimeTable()).commit();
                    break;
                    case 3: System.out.println("네번째탭");
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.container, new Board()).commit();
                    break;
                    case 4:
                        getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container, new applySelfStudy()).commit();

                    break;
                }
                return true;
            }
        });
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow();
        }


    }

    public void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_rigth, R.anim.enter_from_right, R.anim.exit_to_rigth);
        fragmentTransaction.replace(R.id.container, fragment).commit();
    }


    public void goCheck(View v) {
        Intent intent = new Intent(this, Check.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {

        if (System.currentTimeMillis() > backpressedTime + 2000) {
            backpressedTime = System.currentTimeMillis();
            Toast.makeText(this, "\'뒤로\' 버튼을 한번 더 누르시면 앱이 종료됩니다.", Toast.LENGTH_SHORT).show();
        } else if (System.currentTimeMillis() <= backpressedTime + 2000) {
            finish();
            return;
        }

    }
}

