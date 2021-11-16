package com.example.yogaapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ThtAdapter extends RecyclerView.Adapter<ThtAdapter.ThtViewHolder> {

    private List<Tht> mthtList;

    public ThtAdapter(List<Tht> mthtList) {
        this.mthtList = mthtList;
    }

    @NonNull
    @Override
    public ThtViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tht, parent,false);
        return new ThtViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ThtViewHolder holder, int position) {

        Tht tht = mthtList.get(position);
        if (tht == null){return;}
        holder.txtidTht.setText("ID" + tht.getIdTht());
        holder.txtnameTht.setText("Name" + tht.getNameTht());
    }

    @Override
    public int getItemCount() {
        if (mthtList !=null){return mthtList.size();}
        return 0;
    }

    public class ThtViewHolder extends RecyclerView.ViewHolder{
        private TextView txtnameTht;
        private TextView txtidTht;

        public ThtViewHolder(@NonNull View itemView) {
            super(itemView);
            txtnameTht = itemView.findViewById(R.id.tv_tht_name);
            txtidTht = itemView.findViewById(R.id.tv_id_tht);
        }
    }
}
