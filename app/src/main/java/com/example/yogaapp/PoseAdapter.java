package com.example.yogaapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yogaapp.story.Story;
import com.example.yogaapp.story.StoryAdapter;

import java.util.List;

public class PoseAdapter extends RecyclerView.Adapter<PoseAdapter.PosesViewHolder> {
    private List<Pose> poseList;
    private Context context;
    MainActivity mainActivity;

    public PoseAdapter(Context context) {
        this.context = context;
        this.mainActivity = (MainActivity) context;
    }

    public PoseAdapter() {

    }

    public void setData(List<Pose> poseList){
        this.poseList= poseList;
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public PosesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pose,parent,false);
        return new PoseAdapter.PosesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PosesViewHolder holder, int position) {
        Pose pose = poseList.get(position);
        if(pose == null){
            return;
        }
        holder.imageView.setImageResource(pose.imgPose);
        holder.textView.setText(pose.namePose);

    }

    @Override
    public int getItemCount() {
        if(poseList !=null){
            return poseList.size();
        }
        return 0;
    }


    public  class PosesViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public PosesViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_pose_name);
            imageView=  itemView.findViewById(R.id.img_pose);
        }
    }


}
