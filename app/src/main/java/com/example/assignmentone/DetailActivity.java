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

        // 取出 G 部分传入的唯一标识符（数组下标），默认 0
        int position = getIntent().getIntExtra("ITEM_INDEX", 0);

        // 读取 arrays.xml 中的三个数组
        String[] titles   = getResources().getStringArray(R.array.string_array_titles);
        String[] contents = getResources().getStringArray(R.array.string_array_content);
        String[] images   = getResources().getStringArray(R.array.string_array_images);

        // 直接用下标取值，无需分支判断
        detailTitle.setText(titles[position]);
        detailContent.setText(contents[position]);

        // 根据图片名动态获取 drawable 资源 id
        String imageName = images[position];
        int imageResId = getResources().getIdentifier(
                imageName, "drawable", getPackageName());
        detailImage.setImageResource(imageResId);
    }
}