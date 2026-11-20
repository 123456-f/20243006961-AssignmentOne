package com.example.assignmentone;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.ImageButton;
import android.widget.Toast;
import android.content.Intent;
import android.view.View;


public class MainActivity extends AppCompatActivity {
    private ImageButton btnFacilities;
    private ImageButton btnEvents;
    private ImageButton btnClubs;
    private ImageButton btnSupport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnFacilities = findViewById(R.id.btnFacilities);
        btnEvents = findViewById(R.id.btnEvents);
        btnClubs = findViewById(R.id.btnClubs);
        btnSupport = findViewById(R.id.btnSupport);

        // 跳转到 Facilities
        btnFacilities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FacilitiesActivity.class);
                startActivity(intent);
            }
        });

        // 跳转到 Events
        btnEvents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EventsActivity.class);
                startActivity(intent);
            }
        });

        // 跳转到 Clubs
        btnClubs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ClubsActivity.class);
                startActivity(intent);
            }
        });

        // 跳转到 Support
        btnSupport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SupportActivity.class);
                startActivity(intent);
            }
        });

    }
}


