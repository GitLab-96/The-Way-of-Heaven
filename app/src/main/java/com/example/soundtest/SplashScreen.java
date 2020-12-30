package com.example.soundtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.DoubleBounce;

public class SplashScreen extends AppCompatActivity {
    private ProgressBar progressBar;
    private int progress;

    TextView welcomeTV,theWayTV,splafHeaven;
    Typeface typeface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       requestWindowFeature(Window.FEATURE_NO_TITLE);
       getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash_screen);

        welcomeTV = findViewById(R.id.welcome);
        theWayTV = findViewById(R.id.way);
        splafHeaven = findViewById(R.id.splashHeaven);
        typeface = Typeface.createFromAsset(getAssets(),"alexbrush_regular.ttf");

        welcomeTV.setTypeface(typeface);
        theWayTV.setTypeface(typeface);
        splafHeaven.setTypeface(typeface);




        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                doWork();
                startApp();
            }
        });

        thread.start();



        progressBar = (ProgressBar)findViewById(R.id.spin_kit);
        Sprite doubleBounce = new DoubleBounce();
        progressBar.setIndeterminateDrawable(doubleBounce);



    }

    private void startApp() {

        startActivity(new Intent(SplashScreen.this,MainActivity.class));
        finish();

    }

    private void doWork() {

        for(progress = 20;progress<=100;progress=progress+20){

            try{
                Thread.sleep(1000);
                progressBar.setProgress(progress);
            } catch (InterruptedException e){

                e.printStackTrace();
            }
        }
    }
}
