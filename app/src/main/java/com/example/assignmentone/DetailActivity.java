package com.example.assignmentone;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        TextView detailTitle   = findViewById(R.id.detailTitle);
        TextView detailContent = findViewById(R.id.detailContent);
        ImageView detailImage  = findViewById(R.id.detailImage);

        // Retrieve the unique identifier (array index) passed in from part G, default to 0
        int position = getIntent().getIntExtra("ITEM_INDEX", 0);

        // Read three arrays from arrays.xml
        String[] titles   = getResources().getStringArray(R.array.string_array_titles);
        String[] contents = getResources().getStringArray(R.array.string_array_content);
        String[] images   = getResources().getStringArray(R.array.string_array_images);

        // Directly use subscript values without the need for branching judgment
        detailTitle.setText(titles[position]);
        detailContent.setText(contents[position]);

        // Dynamically obtain the drawable resource ID based on the image name
        String imageName = images[position];
        int imageResId = getResources().getIdentifier(
                imageName, "drawable", getPackageName());
        detailImage.setImageResource(imageResId);
    }
}