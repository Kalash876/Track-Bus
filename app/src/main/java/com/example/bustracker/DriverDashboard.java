package com.example.bustracker;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class DriverDashboard extends AppCompatActivity {
    TextView driver_name;
    TextView bus_num;
    ImageButton settings;

    TextView tracking_off;
    TextView tracking_on;
    CardView start_tracking;
    CardView stop_tracking;
    CardView take_attendance;
    CardView edit_attendance;
    BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_driver_dashboard);

        driver_name=findViewById(R.id.driver_name);
        bus_num=findViewById(R.id.bus_num);
        settings=findViewById(R.id.settings);
        tracking_off=findViewById(R.id.tracking_off);
        tracking_on=findViewById(R.id.tracking_on);
        start_tracking=findViewById(R.id.start_tracking);
        stop_tracking=findViewById(R.id.stop_tracking);
        take_attendance=findViewById(R.id.take_attendance);
        edit_attendance=findViewById(R.id.edit_attendance);
        bottomNavigation=findViewById(R.id.bottomNavigation);


        bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                return false;
                //phle saare xml bna le
            }
        });
    }
}