package com.example.food;

import android.os.Bundle;

import android.content.SharedPreferences;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Food> foodList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        foodList = new ArrayList<>();

        foodList.add(new Food("Phở", R.drawable.pho, "Phở bò truyền thống với nước dùng đậm đà.", 45000));
        foodList.add(new Food("Bún chả", R.drawable.buncha, "Bún chả Hà Nội thơm ngon.", 40000));
        foodList.add(new Food("Bánh mì", R.drawable.banhmi, "Bánh mì kẹp thịt và rau sống.", 20000));
        foodList.add(new Food("Cơm tấm", R.drawable.comtam, "Cơm tấm sườn bì chả, trứng ốp la.", 50000));
        foodList.add(new Food("Gỏi cuốn", R.drawable.goicuon, "Gỏi cuốn tôm thịt, nước chấm đậm đà.", 30000));


        FoodAdapter adapter = new FoodAdapter(this, foodList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);TextView txtLastViewed = findViewById(R.id.txtLastViewed);
        TextView txtLastOrdered = findViewById(R.id.txtLastOrdered);

        // Đọc dữ liệu từ SharedPreferences
        SharedPreferences preferences = getSharedPreferences("food_pref", MODE_PRIVATE);
        String lastViewed = preferences.getString("last_viewed", null);
        String lastOrdered = preferences.getString("last_ordered", null);

        if (lastViewed != null) {
            txtLastViewed.setText("Bạn vừa xem: " + lastViewed);
        }

        if (lastOrdered != null) {
            txtLastOrdered.setText("Bạn đã gọi món: " + lastOrdered);
        }


    }


}
