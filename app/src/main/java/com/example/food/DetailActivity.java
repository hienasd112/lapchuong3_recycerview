package com.example.food;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {
    ImageView imgDetail;
    TextView txtDetailName, txtDescription, txtPrice;
    Button btnOrder, btnBack;
    Food food;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        imgDetail = findViewById(R.id.imgDetail);
        txtDetailName = findViewById(R.id.txtDetailName);
        txtDescription = findViewById(R.id.txtDescription);
        txtPrice = findViewById(R.id.txtPrice);
        btnOrder = findViewById(R.id.btnOrder);
        btnBack = findViewById(R.id.btnBack);

        Intent intent = getIntent();
        food = intent.getParcelableExtra("food");

        if (food != null) {
            imgDetail.setImageResource(food.getImageResId());
            txtDetailName.setText(food.getName());
            txtDescription.setText(food.getDescription());
            txtPrice.setText("Giá: " + food.getPrice() + " VND");
        }

        btnOrder.setOnClickListener(v -> {
            Toast.makeText(this, "Đã gọi món: " + food.getName(), Toast.LENGTH_SHORT).show();
        });
        // Lưu tên món ăn vừa xem vào SharedPreferences
        SharedPreferences preferences = getSharedPreferences("food_pref", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("last_viewed", food.getName());
        editor.apply();

        btnOrder.setOnClickListener(v -> {
            Toast.makeText(this, "Đã gọi món: " + food.getName(), Toast.LENGTH_SHORT).show();

            // Ghi lại món ăn đã gọi
            editor.putString("last_ordered", food.getName());
            editor.apply();
        });


        btnBack.setOnClickListener(v -> {
            finish(); // Quay lại MainActivity
        });
    }
}
