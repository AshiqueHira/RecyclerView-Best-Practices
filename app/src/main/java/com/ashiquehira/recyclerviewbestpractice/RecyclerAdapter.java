package com.ashiquehira.recyclerviewbestpractice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

    private ArrayList<MyModel> models = new ArrayList<>();
    private CardClickListner myCardClickListener;

    public RecyclerAdapter(ArrayList<MyModel> models, CardClickListner cardClickListner) {
        this.models = models;
        this.myCardClickListener = cardClickListner;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent,false);
        return new RecyclerViewHolder(view, myCardClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {

        holder.headingTV.setText(models.get(position).getMyTitle());
        holder.discTV.setText(models.get(position).getMyDisc());
        holder.imageV.setImageResource(models.get(position).getMyImg());
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public void updateList(List <MyModel> newList){
        models = new ArrayList<>();
        models.addAll(newList);
        notifyDataSetChanged();
    }
}
