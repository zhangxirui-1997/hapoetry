package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MYFragmentStateAdapter extends FragmentStateAdapter {
    //存放Fragment
    Fragment[] fragments;
    public MYFragmentStateAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        fragments=new Fragment[2];
    }
    //创建Fragment
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (fragments[position]==null){
            //创建Fragment
            FirstFragment checkListFragment=new FirstFragment();
            SecondFragment inventoryDrugListFragment=new SecondFragment();
            fragments[0]=checkListFragment;
            fragments[1]=inventoryDrugListFragment;
        }
        return fragments[position];
    }
    //获取Fragment的数量
    @Override
    public int getItemCount() {
        return fragments.length;
    }
}
