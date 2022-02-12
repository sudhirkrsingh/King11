package com.mega.king11;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.AudienceNetworkAds;

public class MainActivity3 extends AppCompatActivity {

    ImageView img,img2,img3;
    TextView description1,description2,description3;
    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Intent intent=getIntent();

        img=(ImageView)findViewById(R.id.inimg1);
        img2=(ImageView)findViewById(R.id.inimg2);
        img3=(ImageView)findViewById(R.id.inimg3);
        description1=(TextView)findViewById(R.id.desc1);
        description2=(TextView)findViewById(R.id.desc2);
        description3=(TextView)findViewById(R.id.desc3);


        String img1=intent.getStringExtra("innerimage1");
        String img4=intent.getStringExtra("innerimage2");
        String img5=intent.getStringExtra("innerimage3");
        description1.setText(getIntent().getStringExtra("innerdesc1"));
        description2.setText(getIntent().getStringExtra("innerdesc2"));
        description3.setText(getIntent().getStringExtra("innerdesc3"));

        Glide.with(this).load(img1).fitCenter().into(img);
        Glide.with(this).load(img4).fitCenter().into(img2);
        Glide.with(this).load(img5).fitCenter().into(img3);

        AudienceNetworkAds.initialize(this);


        adView = new AdView(this, "332418414686629_447183536543449", AdSize.BANNER_HEIGHT_50);

        // Find the Ad Container
        LinearLayout adContainer = (LinearLayout) findViewById(R.id.banner_container);

        // Add the ad view to your activity layout
        adContainer.addView(adView);

        // Request an ad
        adView.loadAd();

        AdListener adListener = new AdListener() {
            @Override
            public void onError(Ad ad, AdError adError) {
                // Ad error callback


            }

            @Override
            public void onAdLoaded(Ad ad) {
                // Ad loaded callback
            }

            @Override
            public void onAdClicked(Ad ad) {
                // Ad clicked callback
            }

            @Override
            public void onLoggingImpression(Ad ad) {
                // Ad impression logged callback
            }
        };

        // Request an ad
        adView.loadAd(adView.buildLoadAdConfig().withAdListener(adListener).build());



    }

    @Override
    protected void onDestroy() {
        if (adView != null) {
            adView.destroy();
        }
        super.onDestroy();
    }

}

