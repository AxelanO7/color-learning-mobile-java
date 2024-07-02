package com.learning.color;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Objects;

public class PickColorActivity extends AppCompatActivity {
    TextView btnBack;
    View redRectange, blueRectange, greenRectange, yellowRectange, purpleRectange, cyanRectange;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pick_color);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.pick), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Objects.requireNonNull(getSupportActionBar()).hide();
        int colorStatusBar = Color.parseColor("#CADEDF");
        int colorNavigationBar = Color.parseColor("#04ECF0");
        getWindow().setStatusBarColor(colorStatusBar);
        getWindow().setNavigationBarColor(colorNavigationBar);

        TextView btnBack = findViewById(R.id.buttonPickBack);
        redRectange = findViewById(R.id.redContainer);
        blueRectange = findViewById(R.id.blueContainer);
        greenRectange = findViewById(R.id.greenContainer);
        yellowRectange = findViewById(R.id.yellowContainer);
        purpleRectange = findViewById(R.id.purpleContainer);
        cyanRectange = findViewById(R.id.cyanContainer);

        btnBack.setOnClickListener(v -> onBackPressed());
        redRectange.setOnClickListener(v -> onColorClick("#FF0000"));
        blueRectange.setOnClickListener(v -> onColorClick("#0500FF"));
        greenRectange.setOnClickListener(v -> onColorClick("#00FF00"));
        cyanRectange.setOnClickListener(v -> onColorClick("#00FFFF"));
        purpleRectange.setOnClickListener(v -> onColorClick("#BF00FF"));
        yellowRectange.setOnClickListener(v -> onColorClick("#FFFF00"));
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(PickColorActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void onColorClick(String color) {
        Intent intent = new Intent(PickColorActivity.this, DetailColorActivity.class);
        intent.putExtra("color", color);
        startActivity(intent);
        finish();
    }
}