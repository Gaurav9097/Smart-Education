package com.example.smarteducation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashscreenActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN=3000;
    Animation spalsh_screen_animation,spalsh_screen_animation_end;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        // hide top bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Animation
        spalsh_screen_animation = AnimationUtils.loadAnimation(this,R.anim.splash_screen_animation);
        imageView = findViewById(R.id.imageView1);
        imageView.setAnimation(spalsh_screen_animation);

        // move splash screen to other screen
        new Handler().postDelayed(new Runnable() {
            public void run() {
                startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                finish();
            }
        }, SPLASH_SCREEN);
    }
}