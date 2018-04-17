package com.example.arrayadapterjay;

import android.support.v4.app.Fragment;
import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Fragment fragment = new BlankFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container,fragment)
                .commit();
    }
}
