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

        // Facilities，传索引0
        btnFacilities.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            intent.putExtra("ITEM_INDEX", 0); // 传递唯一标识符
            startActivity(intent);
        });

        // Events，传索引1
        btnEvents.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            intent.putExtra("ITEM_INDEX",1);
            startActivity(intent);
        });

        // Clubs，传索引2
        btnClubs.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            intent.putExtra("ITEM_INDEX",2);
            startActivity(intent);
        });

        // Support，传索引3
        btnSupport.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            intent.putExtra("ITEM_INDEX",3);
            startActivity(intent);
        });

    }
}


