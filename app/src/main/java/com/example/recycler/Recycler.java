package com.example.recycler;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Recycler extends AppCompatActivity implements ItemAdapter.OnItemClickListener {

    private RecyclerView recyclerView;
    private ItemAdapter itemAdapter;
    private ArrayList<Games> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        recyclerView = findViewById(R.id.recyclerView);

        // Menambahkan data games
        itemList = new ArrayList<>();
        itemList.add(new Games("Garten of Banban 0", "Free", "Explore the origins of the mysterious Banban’s Kindergarten. Survive the dark past of the establishment. Try to make some friends. Uncover the truth behind the place, and who you are…", R.drawable.banban));
        itemList.add(new Games("Garten of Banban", "Free", "Enter Banban's Kindergarten, and you're sure to make some friends. Explore the mysterious establishment and don't lose your life and sanity. Uncover the horrifying truth behind the place, but be careful, as you are far from alone…",  R.drawable.banban1));
        itemList.add(new Games("TEKKEN 7", "Rp 399.000", "The legendary fighting game franchise fights back with stunning story-driven cinematic battles and intense duels that can be enjoyed with friends and rivalsGet ready for the next battle!",  R.drawable.tekken));
        itemList.add(new Games("TEKKEN 8", "Rp 699.000", "Get ready for the next chapter in the legendary fighting game franchise, TEKKEN 8.",  R.drawable.tekken8));
        itemList.add(new Games("Counter Strike 2", "Free", "For over two decades, Counter-Strike has offered an elite competitive experience, one shaped by millions of players from across the globe. And now the next chapter in the CS story is about to begin. This is Counter-Strike 2.", R.drawable.cs2));
        itemList.add(new Games("Monster Hunter: World", "Rp 334.999", "Welcome to a new world! In Monster Hunter: World, the latest installment in the series, you can enjoy the ultimate hunting experience, using everything at your disposal to hunt monsters in a new world teeming with surprises and excitement.", R.drawable.mhw));

        // Set up RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        itemAdapter = new ItemAdapter(itemList, this);  // Menyambungkan listener
        recyclerView.setAdapter(itemAdapter);
    }

    // Mengimplementasikan onItemClick untuk menangani klik item
    @Override
    public void onItemClick(Games games) {
        // Membuat Intent untuk membuka ActivityDetail
        Intent intent = new Intent(Recycler.this, Info.class);
        intent.putExtra("name", games.getName());
        intent.putExtra("status", games.getStatus());
        intent.putExtra("description", games.getDescription());
        intent.putExtra("ivProfile", games.getImage());
        startActivity(intent);
    }
}