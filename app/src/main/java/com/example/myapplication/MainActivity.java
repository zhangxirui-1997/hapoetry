package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
//import android.support.v7.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
//import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private String[] title = {"第一页", "第二页"};
    private Boolean judge1 = Boolean.FALSE;
    private LinearLayout linearlayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager2 viewPager2 = findViewById(R.id.viewpager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(this);
        MYFragmentStateAdapter myFragmentStateAdapter = new MYFragmentStateAdapter(this);
        viewPager2.setAdapter(myFragmentStateAdapter);

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        //TabLayout与ViewPager2联动
        new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(title[position]);
            }
        }).attach();


        ImageButton imageButton = findViewById(R.id.imageButton);
        NavigationView navigationview = (NavigationView) findViewById(R.id.navigation_view);
        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        RotateAnimation animation = new RotateAnimation(0, 90,
                Animation.RELATIVE_TO_SELF,  0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        animation.setDuration(100);
        animation.setFillAfter(true);

        RotateAnimation animation1 = new RotateAnimation(90, 180,
                Animation.RELATIVE_TO_SELF,  0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        animation1.setDuration(100);
        animation1.setFillAfter(true);


        drawer.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerClosed(@NonNull View drawerView) {
//                judge1 = Boolean.FALSE;
                imageButton.startAnimation(animation1);
            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (judge1){
                    drawer.closeDrawer(Gravity.LEFT);
                }else{
                    drawer.openDrawer(Gravity.LEFT);
                    imageButton.startAnimation(animation);
                }
            }
        });


        /*---------------------------添加头布局和尾布局-----------------------------*/
        //获取xml头布局view
        View headerView = navigationview.getHeaderView(0);
        //添加头布局的另外一种方式
        //View headview=navigationview.inflateHeaderView(R.layout.navigationview_header);

        //Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        //setSupportActionBar(myToolbar);
    }


}