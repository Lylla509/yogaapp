package com.example.yogaapp.story;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yogaapp.R;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryviewHolder> {
    private Context context;
    private List<Category> mListCat;

    public CategoryAdapter(Context context) {
        this.context = context;
    }
    public void setData(List<Category> list){
        this.mListCat = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CategoryviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false);

        return new CategoryviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryviewHolder holder, int position) {
        Category category= mListCat.get(position);
        if(category==null){return;}
        holder.tvNameCat.setText(category.getNameCategory());

        LinearLayoutManager linearLayoutManager =new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false);
        holder.rcvStr.setLayoutManager(linearLayoutManager);


        StoryAdapter storyAdapter= new StoryAdapter( );
        storyAdapter.setData(category.getStories());
        holder.rcvStr.setAdapter(storyAdapter);
    }

    @Override
    public int getItemCount() {
        if(mListCat !=null){return mListCat.size();}
        return 0;
    }

    public class CategoryviewHolder extends RecyclerView.ViewHolder{
        private TextView tvNameCat;
        private RecyclerView rcvStr;
        private ImageView btnback;

        public CategoryviewHolder(@NonNull View itemView) {
            super(itemView);

            tvNameCat = itemView.findViewById(R.id.txtnameT);
            rcvStr = itemView.findViewById(R.id.rcv);
            btnback = itemView.findViewById(R.id.img_back);
        }
    }
}
