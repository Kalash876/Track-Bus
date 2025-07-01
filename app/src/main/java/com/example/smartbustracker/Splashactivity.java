package com.example.smartbustracker;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Splashactivity extends AppCompatActivity {

    private static final int SPLASH_DURATION = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splashactivity);

        // Get views
        ImageView logoImageView = findViewById(R.id.logo_image);
        TextView footerTextView = findViewById(R.id.footer_text);

        // Load animations
        Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in); // Create this
        Animation scaleUp = AnimationUtils.loadAnimation(this, R.anim.scale_up); // Create this
        Animation footerBlast = AnimationUtils.loadAnimation(this, R.anim.footer_blast); // Already created earlier

        // Combine fade + scale for logo
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(fadeIn);
        animationSet.addAnimation(scaleUp);
        logoImageView.startAnimation(animationSet);

        // Apply window insets for edge-to-edge
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Play footer blast animation after 1.5 seconds
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            footerTextView.startAnimation(footerBlast);
        }, 1500);

        // Go to MainActivity after splash duration
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            startActivity(new Intent(Splashactivity.this, MainActivity.class));
            finish();
        }, SPLASH_DURATION);
    }
}
