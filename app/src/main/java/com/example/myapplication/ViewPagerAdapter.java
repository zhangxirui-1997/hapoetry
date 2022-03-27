package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

// 3 RecyclerView.Adapter(后面要跟着一个范型)
public class ViewPagerAdapter extends RecyclerView.Adapter<ViewPagerAdapter.HorizontalVpViewHolder> {
    private List<Integer> backgrounds;
    private Context mContext;

    ViewPagerAdapter(Context context) {
        mContext = context;
        if (backgrounds == null) {
            backgrounds = new ArrayList<>();
            backgrounds.add(android.R.color.holo_blue_bright);
            backgrounds.add(android.R.color.holo_red_dark);
        }
    }

    @NonNull
    @Override
    public HorizontalVpViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HorizontalVpViewHolder(LayoutInflater.from(mContext).inflate((R.layout.item_pager), parent, false));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull HorizontalVpViewHolder holder, int position) {

        holder.mTextView.setText("第  " + (position + 1) + " 界面");
        holder.mLinearLayout.setBackgroundResource(backgrounds.get(position));
    }

    @Override
    public int getItemCount() {
        if (backgrounds == null) {
            return 0;
        }
        return backgrounds.size();
    }

    class HorizontalVpViewHolder extends RecyclerView.ViewHolder {
        LinearLayout mLinearLayout;
        TextView mTextView;

        HorizontalVpViewHolder(@NonNull View itemView) {
            super(itemView);
            mLinearLayout = itemView.findViewById(R.id.ll_h_v);
            mTextView = itemView.findViewById(R.id.tv_hv);
        }
    }

    public class MyFragment extends Fragment
    {
        @Override
        public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup,    Bundle paramBundle)
        {
            return paramLayoutInflater.inflate(R.layout.firstpager, paramViewGroup, false);
        }
    }
}