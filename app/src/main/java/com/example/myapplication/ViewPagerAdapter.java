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

    ViewPagerAdapter(Context context, List<Integer> bg) {
        mContext = context;
        backgrounds = bg;
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
        holder.item_title.setText("将进酒");
        holder.item_author.setText("李白");
        holder.item_years.setText("[唐代]");
        holder.item_content.setText("君不见黄河之水天上来，奔流到海不复回。\n" +
                "君不见高堂明镜悲白发，朝如青丝暮成雪。\n" +
                "人生得意须尽欢，莫使金樽空对月。\n" +
                "天生我材必有用，千金散尽还复来。\n" +
                "烹羊宰牛且为乐，会须一饮三百杯。\n" +
                "岑夫子，丹丘生，将进酒，杯莫停。\n" +
                "与君歌一曲，请君为我倾耳听。\n" +
                "钟鼓馔玉不足贵，但愿长醉不愿醒。\n" +
                "古来圣贤皆寂寞，惟有饮者留其名。\n" +
                "陈王昔时宴平乐，斗酒十千恣欢谑。\n" +
                "主人何为言少钱，径须沽取对君酌。\n" +
                "五花马、千金裘，\n呼儿将出换美酒，与尔同销万古愁。");
    }

    @Override
    public int getItemCount() {
        if (backgrounds == null) {
            return 0;
        }
        return backgrounds.size();
    }

    class HorizontalVpViewHolder extends RecyclerView.ViewHolder {

        TextView item_title;
        TextView item_content;
        TextView item_author;
        TextView item_years;

        HorizontalVpViewHolder(@NonNull View itemView) {
            super(itemView);
            item_title=itemView.findViewById(R.id.item_title);
            item_author=itemView.findViewById(R.id.item_author);
            item_years=itemView.findViewById(R.id.item_years);
            item_content=itemView.findViewById(R.id.item_content);
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