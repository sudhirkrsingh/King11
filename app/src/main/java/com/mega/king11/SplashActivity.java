package com.mega.king11;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import static java.lang.Thread.sleep;

public class SplashActivity extends AppCompatActivity {
    ImageView splashImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        splashImage=(ImageView) findViewById(R.id.splash);

         Animation myanim= AnimationUtils.loadAnimation(this,R.anim.myanimation);
         splashImage.startAnimation(myanim);

         Thread myThread=new Thread(new Runnable() {
             @Override
             public void run() {
                 try {
                     sleep(2000);
                     Intent intent=new Intent(SplashActivity.this,MainActivity.class);
                     startActivity(intent);

                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             }
         });

         myThread.start();

         checkConnection();
    }
    public void checkConnection(){
        ConnectivityManager manager= (ConnectivityManager)
        getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork=manager.getActiveNetworkInfo();

        if(null!=activeNetwork){
            if(activeNetwork.getType() == ConnectivityManager.TYPE_WIFI){ }
            else if(activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE){ }
        }
        else {
            Toast.makeText(this, "Please Check Your Internet Connection", Toast.LENGTH_SHORT).show();
        }

    }
}