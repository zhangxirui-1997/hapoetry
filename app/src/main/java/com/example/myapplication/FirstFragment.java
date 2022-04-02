package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

// 榜单 每日一读 讨论区入口
public class FirstFragment extends Fragment {
    private View viewFirst;
    private List<Integer> bg;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.firstpager,container,false);
        viewFirst = view;
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        bg = new ArrayList<>();
        bg.add(android.R.color.holo_blue_bright);
        bg.add(android.R.color.holo_red_dark);
        ViewPager2 viewPager2 = viewFirst.findViewById(R.id.viewpager1);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getContext(), bg);
        viewPager2.setAdapter(adapter);
        viewPager2.setOffscreenPageLimit(3);
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                if (position==bg.size()-1){
                    bg.add(android.R.color.holo_blue_bright);
                    adapter.notifyDataSetChanged();
                }

            }
        });

    }
}
