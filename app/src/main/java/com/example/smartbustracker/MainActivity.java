package com.example.smartbustracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnAdmin, btnDriver, btnStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // System bar padding
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize buttons
        btnAdmin = findViewById(R.id.btnAdmin);
        btnDriver = findViewById(R.id.btnDriver);
        btnStudent = findViewById(R.id.btnStudent);

        // Click listeners
        btnAdmin.setOnClickListener(view -> {
           // Intent intent = new Intent(MainActivity.this, AdminLoginActivity.class);
            //startActivity(intent);
        });

        btnDriver.setOnClickListener(view -> {
//            Intent intent = new Intent(MainActivity.this, DriverLoginActivity.class);
//            startActivity(intent);
        });

        btnStudent.setOnClickListener(view -> {
//            Intent intent = new Intent(MainActivity.this, StudentLoginActivity.class);
//            startActivity(intent);
        });
    }
}
