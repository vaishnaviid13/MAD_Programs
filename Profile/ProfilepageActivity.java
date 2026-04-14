package com.example.profilepage;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ProfilepageActivity extends AppCompatActivity {

    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        btnBack = findViewById(R.id.btnBack);

        btnBack.setOnClickListener(v -> {
            Toast.makeText(this, "Back Button Clicked", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}