package com.example.recycler;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Info extends AppCompatActivity {

    private TextView nameTextView, statusTextView, descriptionTextView;
    private ImageView ivProfile;
    private Button btnBack;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        nameTextView = findViewById(R.id.nameTextView);
        statusTextView = findViewById(R.id.statusTextView);
        descriptionTextView = findViewById(R.id.descriptionTextView);
        ivProfile = findViewById(R.id.ivProfile);
        btnBack = findViewById(R.id.buttonBack);

        String name = getIntent().getStringExtra("name");
        String status = getIntent().getStringExtra("status");
        String description = getIntent().getStringExtra("description");
        int imageResId = getIntent().getIntExtra("ivProfile", -1);  // Get the image resource ID

        nameTextView.setText(name);
        statusTextView.setText(status);
        descriptionTextView.setText(description);

        if (imageResId != -1) {
            ivProfile.setImageResource(imageResId);
        }

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Info.this, Recycler.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
