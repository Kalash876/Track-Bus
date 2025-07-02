package com.example.smartbustracker;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.airbnb.lottie.LottieAnimationView;

public class Splashactivity extends AppCompatActivity {

    private static final int SPLASH_DURATION = 3000; // reduced duration
    private static final String TYPEWRITER_TEXT = "Welcome to SmartBus Tracker";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splashactivity);

        // Get views
        LottieAnimationView lottieBusAnimation = findViewById(R.id.lottie_bus_animation);
        TextView footerTextView = findViewById(R.id.footer_text);

        // Initially hide footer text
        footerTextView.setVisibility(View.INVISIBLE);

        // Start Lottie animation
        lottieBusAnimation.playAnimation();

        // Show and start typewriter effect in parallel
        footerTextView.setVisibility(View.VISIBLE);
        int delayPerChar = SPLASH_DURATION / TYPEWRITER_TEXT.length(); // ~93ms per character
        startTypewriterEffect(footerTextView, TYPEWRITER_TEXT, delayPerChar);

        // After SPLASH_DURATION, move to MainActivity
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            startActivity(new Intent(Splashactivity.this, MainActivity.class));
            finish();
        }, SPLASH_DURATION);

        // Edge-to-edge padding
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    // Typewriter effect logic
    private void startTypewriterEffect(TextView textView, String text, int delayPerChar) {
        Handler handler = new Handler(Looper.getMainLooper());
        textView.setText("");
        for (int i = 0; i < text.length(); i++) {
            int finalI = i;
            handler.postDelayed(() -> {
                textView.append(String.valueOf(text.charAt(finalI)));
            }, i * delayPerChar);
        }
    }
}
