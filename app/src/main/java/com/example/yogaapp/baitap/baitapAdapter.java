package com.example.yogaapp.baitap;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yogaapp.PoseAdapter;
import com.example.yogaapp.R;
import com.example.yogaapp.story.Category;
import com.example.yogaapp.story.CategoryAdapter;
import com.example.yogaapp.story.StoryAdapter;

import java.util.List;

public class baitapAdapter extends RecyclerView.Adapter<baitapAdapter.BaitapviewHolder>{
    private Context context;
    private List<baitap> mListBaitap;

    public baitapAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<baitap> list){
        this.mListBaitap = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BaitapviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_baitap, parent, false);

        return new baitapAdapter.BaitapviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BaitapviewHolder holder, int position) {

        baitap bt= mListBaitap.get(position);
        if(bt==null){return;}
        holder.tvtenBt.setText(bt.getTenBT());

        LinearLayoutManager linearLayoutManager =new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false);
        holder.rcvBt.setLayoutManager(linearLayoutManager);


        PoseAdapter poseAdapter= new PoseAdapter();
        poseAdapter.setData(bt.getListBt());
        holder.rcvBt.setAdapter(poseAdapter);
    }

    @Override
    public int getItemCount() {
        if(mListBaitap !=null){return mListBaitap.size();}
        return 0;
    }

    public class BaitapviewHolder extends RecyclerView.ViewHolder{
        private TextView tvtenBt;
        private RecyclerView rcvBt;
        private ImageView btnback;

        public BaitapviewHolder(@NonNull View itemView) {
            super(itemView);

            tvtenBt = itemView.findViewById(R.id.tv_tenbaitap);
            rcvBt = itemView.findViewById(R.id.rcvBaitap);
            btnback = itemView.findViewById(R.id.img_back);
        }
    }
}
