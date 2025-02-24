package com.example.recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    private ArrayList<Games> itemList;
    private OnItemClickListener listener;  // Interface listener

    // Konstruktor untuk adapter
    public ItemAdapter(ArrayList<Games> itemList, OnItemClickListener listener) {
        this.itemList = itemList;
        this.listener = listener;  // Menyimpan listener
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflate layout item untuk setiap row dalam RecyclerView
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // Set data pada setiap item
        Games games = itemList.get(position);
        holder.nameTextView.setText(games.getName());
        holder.statusTextView.setText(String.valueOf(games.getStatus()));
        holder.descriptionTextView.setText(games.getDescription());

        // Menambahkan OnClickListener pada item
        holder.itemView.setOnClickListener(v -> listener.onItemClick(games));
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    // ViewHolder untuk menyimpan referensi ke elemen tampilan
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView, statusTextView, descriptionTextView;
        public ViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            statusTextView = itemView.findViewById(R.id.statusTextView);
            descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
        }
    }

    // Interface untuk menangani item klik
    public interface OnItemClickListener{
        void onItemClick(Games games);
    }
}
