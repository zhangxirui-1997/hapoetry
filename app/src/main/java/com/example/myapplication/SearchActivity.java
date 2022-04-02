package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;


public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        要显示的activity的动画  要消失的activity的动画
//        overridePendingTransition(R.anim.layout_down_up, R.anim.layout_center );
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Toolbar searchtoolbar = (Toolbar) findViewById(R.id.searchtoolbar);
        setSupportActionBar(searchtoolbar);
        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void finish() {
//        overridePendingTransition(R.anim.layout_down_up, R.anim.layout_center );
        super.finish();

    }
}