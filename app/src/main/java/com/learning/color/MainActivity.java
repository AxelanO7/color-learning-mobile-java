package com.learning.color;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    Button btnStart;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.pick), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Objects.requireNonNull(getSupportActionBar()).hide();
        int colorStatusBar = Color.parseColor("#04ECF0");
        int colorNavigationBar = Color.parseColor("#CADEDF");
        getWindow().setStatusBarColor(colorStatusBar);
        getWindow().setNavigationBarColor(colorNavigationBar);


        btnStart = findViewById(R.id.buttonStart);
        btnStart.setOnClickListener(v -> goToPickColor());
    }

    private void goToPickColor() {
        Intent intent = new Intent(MainActivity.this, PickColorActivity.class);
        startActivity(intent);
        finish();
    }
}