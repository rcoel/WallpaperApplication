package com.example.wallpaper;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnWallpaper;
    boolean running;
    int [] ia = new int[]{
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5,
            R.drawable.img6,
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnWallpaper = (Button) findViewById(R.id.btn);
        btnWallpaper.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(!running){
            new Timer().schedule(new MyTimer(), 0, 3000);
            running = true;
        }
    }

    class MyTimer extends TimerTask{

        @Override
        public void run() {
            try{
                WallpaperManager wallpaperManager = WallpaperManager.getInstance(getBaseContext());
                Random random = new Random();
                wallpaperManager.setBitmap(BitmapFactory.decodeResource(getResources(), ia[random.nextInt(5)]));
            }
            catch (Exception e){

            }
        }
    }
}