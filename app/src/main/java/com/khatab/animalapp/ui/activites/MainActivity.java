package com.khatab.animalapp.ui.activites;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.khatab.animalapp.R;

public class MainActivity extends AppCompatActivity {


    private static final String VIDEO_SAMPLE = "tacoma_narrows";
    private final int splash_Display_Length = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final ImageView zoom = (ImageView) findViewById(R.id.Splash_Logo);

        final Animation zoomAnimation = AnimationUtils.loadAnimation(this, R.anim.zoom);
        zoom.startAnimation(zoomAnimation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, MainMenueActivity.class);
                MainActivity.this.startActivity(intent);
                MainActivity.this.finish();
            }
        }, splash_Display_Length);
    }

}

