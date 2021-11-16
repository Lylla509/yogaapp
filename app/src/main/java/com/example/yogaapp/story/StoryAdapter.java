package com.example.yogaapp.story;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yogaapp.MainActivity;
import com.example.yogaapp.R;

import java.util.List;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.StoriesViewHolder>{
    private List<Story> storiesList;
    private Context context;
    MainActivity mainActivity;


    public StoryAdapter(Context context) {
        this.context = context;
        this.mainActivity = (MainActivity) context;
    }

    public StoryAdapter() {

    }

    public void setData(List<Story> strList){
        this.storiesList= strList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public StoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_story,parent,false);
        return new StoriesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StoriesViewHolder holder, int position) {
        Story story = storiesList.get(position);
        if(story==null){
            return;
        }
        holder.imageView.setImageResource(story.img);
        holder.textView.setText(story.nameStr);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent i = new Intent(context, ListStr.class);
//                i.putExtra("Stories",story.nameStr);
//                i.putExtra("USER_ID",mainActivity.getG_uid());
//                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        if(storiesList !=null){
            return storiesList.size();
        }
        return 0;
    }

    public  class StoriesViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public StoriesViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.txt_Titlestr);
            imageView=  itemView.findViewById(R.id.img_str);
        }
    }
}
