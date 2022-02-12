package com.mega.king11;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.AudienceNetworkAds;

import org.json.JSONArray;
import org.json.JSONObject;

public class MatchSummaryActivity extends AppCompatActivity {

    private AdView adView1,adView2,adView3,adView4;

    public String url1 = "https://cricapi.com/api/cricketScore/?apikey=IsBQEmFUaYScy3eFQ6RLYRFH8Yv1&unique_id=";

    String url = "https://cricapi.com/api/fantasySummary/?apikey=IsBQEmFUaYScy3eFQ6RLYRFH8Yv1&unique_id=";

    TextView fieldT1TitleTv,fieldT1DetailTv,fieldT2TitleTv,fieldT2DetailTv,
            bowlT1TitleTv,bowlT1DetailTv,bowlT2TitleTv,bowlT2DetailTv,
            batT1TitleTv,batT1DetailTv,batT2TitleTv,batT2DetailTv,
            otherResultsTv;

    TextView t1,t2,t3,t4,t5,t6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_summary);

        Intent intent = getIntent();
        String id = intent.getStringExtra("match_id");
        url = url+id;
        url1 = url1+id;

        fieldT1TitleTv = (TextView)findViewById(R.id.fieldT1TitleTv);
        fieldT1DetailTv = (TextView)findViewById(R.id.fieldT1DetailTv);
        fieldT2TitleTv = (TextView)findViewById(R.id.fieldT2TitleTv);
        fieldT2DetailTv = (TextView)findViewById(R.id.fieldT2DetailTv);


        bowlT1TitleTv = (TextView)findViewById(R.id.bowlT1TitleTv);
        bowlT1DetailTv = (TextView)findViewById(R.id.bowlT1DetailTv);
        bowlT2TitleTv = (TextView)findViewById(R.id.bowlT2TitleTv);
        bowlT2DetailTv = (TextView)findViewById(R.id.bowlT2DetailTv);

        batT1TitleTv = (TextView)findViewById(R.id.batT1TitleTv);
        batT1DetailTv = (TextView)findViewById(R.id.batT1DetailTv);
        batT2TitleTv = (TextView)findViewById(R.id.batT2TitleTv);
        batT2DetailTv = (TextView)findViewById(R.id.batT2DetailTv);

        otherResultsTv = (TextView)findViewById(R.id.otherResultsTv);

        t1 = (TextView)findViewById(R.id.text1);
        t2 = (TextView)findViewById(R.id.text2);
        t3 = (TextView)findViewById(R.id.text3);
        
        t4 = (TextView)findViewById(R.id.text4);
        t5 = (TextView)findViewById(R.id.text5);
        t6 = (TextView)findViewById(R.id.stats);

        AudienceNetworkAds.initialize(this);


        adView1 = new AdView(this, "332418414686629_333215047940299", AdSize.BANNER_HEIGHT_50);

        adView2 = new AdView(this, "332418414686629_447183536543449", AdSize.BANNER_HEIGHT_50);

        adView3 = new AdView(this, "332418414686629_333215057940298", AdSize.BANNER_HEIGHT_50);

        adView4 = new AdView(this, "332418414686629_332427668019037", AdSize.BANNER_HEIGHT_50);


        // Find the Ad Container
        LinearLayout adContainer1 = (LinearLayout) findViewById(R.id.banner_container1);

        // Add the ad view to your activity layout
        adContainer1.addView(adView1);

        // Request an ad
        adView1.loadAd();

        // Find the Ad Container
        LinearLayout adContainer2 = (LinearLayout) findViewById(R.id.banner_container2);

        // Add the ad view to your activity layout
        adContainer2.addView(adView2);

        // Request an ad
        adView2.loadAd();

        // Find the Ad Container
        LinearLayout adContainer3 = (LinearLayout) findViewById(R.id.banner_container3);

        // Add the ad view to your activity layout
        adContainer3.addView(adView3);

        // Request an ad
        adView3.loadAd();

        // Find the Ad Container
        LinearLayout adContainer4 = (LinearLayout) findViewById(R.id.banner_container4);

        // Add the ad view to your activity layout
        adContainer4.addView(adView4);

        // Request an ad
        adView4.loadAd();

        AdListener adListener1 = new AdListener() {
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
        adView1.loadAd(adView1.buildLoadAdConfig().withAdListener(adListener1).build());

        AdListener adListener2 = new AdListener() {
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
        adView2.loadAd(adView2.buildLoadAdConfig().withAdListener(adListener2).build());

        AdListener adListener3 = new AdListener() {
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
        adView3.loadAd(adView3.buildLoadAdConfig().withAdListener(adListener3).build());

        AdListener adListener4 = new AdListener() {
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
        adView4.loadAd(adView4.buildLoadAdConfig().withAdListener(adListener4).build());



        ScoreData();

        loadData();

    }

    private void ScoreData() {
        final ProgressDialog pd = new ProgressDialog(this);
        pd.setMessage("Loading...");
        pd.show();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url1,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        pd.dismiss();
                        try {
                            JSONObject jsonObject = new JSONObject(response);

                            String team1 = jsonObject.getString("team-1");
                            String team2 = jsonObject.getString("team-2");
                            String stats = jsonObject.getString("stat");
                            String matchStatus = jsonObject.getString("matchStarted");

                            if (matchStatus.equals("true")){
                                matchStatus = "Match Started";
                                t6.setText(stats);

                            }
                            else {
                                matchStatus ="Match not started";
                            }
                            t1.setText(team1);
                            t2.setText(team2);
                            t3.setText(matchStatus);

                            try {
                                // these values will be received only if match is started
                                //so we are enclosing in separate try catch

                                String score = jsonObject.getString("score");
                                String description = jsonObject.getString("description");

                                t4.setText(score);
                                t5.setText(description);

                            }
                            catch (Exception e)
                            {
                                Toast.makeText(MatchSummaryActivity.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                            }

                        }
                        catch (Exception e){
                            Toast.makeText(MatchSummaryActivity.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MatchSummaryActivity.this, "Error: "+error.toString(), Toast.LENGTH_SHORT).show();

            }
        });

        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);


    }


    private void loadData()
    {
        final ProgressDialog pd = new ProgressDialog(this);
        pd.setMessage("Loading...");
        pd.show();

        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                pd.dismiss();

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONObject dataJObject = jsonObject.getJSONObject("data");

                    JSONArray fieldJArray = dataJObject.getJSONArray("fielding");
                    JSONArray bowlJArray = dataJObject.getJSONArray("bowling");
                    JSONArray batJArray = dataJObject.getJSONArray("batting");

                    JSONObject fieldO = fieldJArray.getJSONObject(0);
                    JSONObject field1 = fieldJArray.getJSONObject(1);

                    String field1Title =  fieldO.getString("title");
                    String field2Title =  field1.getString("title");

                    JSONArray field1ScoresJArray = fieldO.getJSONArray("scores");
                    JSONArray field2ScoresJArray = field1.getJSONArray("scores");

                    fieldT1TitleTv.setText(field1Title);
                    for (int i=0; i<field1ScoresJArray.length(); i++)
                    {
                        String name = field1ScoresJArray.getJSONObject(i).getString("name");
                        String bowled = field1ScoresJArray.getJSONObject(i).getString("bowled");
                        String catchh = field1ScoresJArray.getJSONObject(i).getString("catch");
                        String lbw = field1ScoresJArray.getJSONObject(i).getString("lbw");
                        String runout = field1ScoresJArray.getJSONObject(i).getString("runout");
                        String stumped = field1ScoresJArray.getJSONObject(i).getString("stumped");

                        fieldT1DetailTv.append("Name: "+ name
                        +"\nBowled: "+bowled
                        +"\nCatch: "+catchh
                        +"\nLBW: "+lbw
                        +"\nRunOut: "+runout
                        +"\nStumped: "+stumped +"\n\n"
                        );

                    }
                    fieldT2TitleTv.setText(field2Title);
                    for (int i=0; i<field2ScoresJArray.length(); i++)
                    {
                        String name = field2ScoresJArray.getJSONObject(i).getString("name");
                        String bowled = field2ScoresJArray.getJSONObject(i).getString("bowled");
                        String catchh = field2ScoresJArray.getJSONObject(i).getString("catch");
                        String lbw = field2ScoresJArray.getJSONObject(i).getString("lbw");
                        String runout = field2ScoresJArray.getJSONObject(i).getString("runout");
                        String stumped = field2ScoresJArray.getJSONObject(i).getString("stumped");

                        fieldT2DetailTv.append("Name: "+ name
                                +"\nBowled: "+bowled
                                +"\nCatch: "+catchh
                                +"\nLBW: "+lbw
                                +"\nRunOut: "+runout
                                +"\nStumped: "+stumped +"\n\n"
                        );

                    }


                    JSONObject bowlO = bowlJArray.getJSONObject(0);
                    JSONObject bowl1 = bowlJArray.getJSONObject(1);

                    String bowl1Title =  bowlO.getString("title");
                    String bowl2Title =  bowl1.getString("title");

                    JSONArray bowl1ScoresJArray = bowlO.getJSONArray("scores");
                    JSONArray bowl2ScoresJArray = bowl1.getJSONArray("scores");

                    bowlT1TitleTv.setText(bowl1Title);
                    for (int i =0; i<bowl1ScoresJArray.length(); i++)
                    {

                        String bowlerName = bowl1ScoresJArray.getJSONObject(i).getString("bowler");
                        String overs = bowl1ScoresJArray.getJSONObject(i).getString("O");
                        String wickets = bowl1ScoresJArray.getJSONObject(i).getString("W");
                        String runs = bowl1ScoresJArray.getJSONObject(i).getString("R");
                        String zeores = bowl1ScoresJArray.getJSONObject(i).getString("0s");
                        String fours = bowl1ScoresJArray.getJSONObject(i).getString("4s");
                        String sixes = bowl1ScoresJArray.getJSONObject(i).getString("6s");
                        String m = bowl1ScoresJArray.getJSONObject(i).getString("M");
                        String econ = bowl1ScoresJArray.getJSONObject(i).getString("Econ");

                        bowlT1DetailTv.append("Name: " +bowlerName
                        +"\nOvers: " +overs
                        +"\nWickets: " +wickets
                        +"\nRuns: " +runs
                        +"\n0s: " +zeores
                        +"\n4s: " +fours
                        +"\n6s: " +sixes
                        +"\nM: " +m
                        +"\nEcon: " +econ
                        +"\n\n"
                        );
                    }

                    bowlT2TitleTv.setText(bowl2Title);
                    for (int i =0; i<bowl2ScoresJArray.length(); i++)
                    {

                        String bowlerName = bowl2ScoresJArray.getJSONObject(i).getString("bowler");
                        String overs = bowl2ScoresJArray.getJSONObject(i).getString("O");
                        String wickets = bowl2ScoresJArray.getJSONObject(i).getString("W");
                        String runs = bowl2ScoresJArray.getJSONObject(i).getString("R");
                        String zeores = bowl2ScoresJArray.getJSONObject(i).getString("0s");
                        String fours = bowl2ScoresJArray.getJSONObject(i).getString("4s");
                        String sixes = bowl2ScoresJArray.getJSONObject(i).getString("6s");
                        String m = bowl2ScoresJArray.getJSONObject(i).getString("M");
                        String econ = bowl2ScoresJArray.getJSONObject(i).getString("Econ");

                        bowlT2DetailTv.append("Name: " +bowlerName
                                +"\nOvers: " +overs
                                +"\nWickets: " +wickets
                                +"\nRuns: " +runs
                                +"\n0s: " +zeores
                                +"\n4s: " +fours
                                +"\n6s: " +sixes
                                +"\nM: " +m
                                +"\nEcon: " +econ
                                +"\n\n"
                        );
                    }

                    JSONObject bat0 = batJArray.getJSONObject(0);
                    JSONObject bat1 = batJArray.getJSONObject(1);

                    String bat1Title = bat0.getString("title");
                    String bat2Title = bat1.getString("title");

                    JSONArray bat1ScoresJArray = bat0.getJSONArray("scores");
                    JSONArray bat2ScoresJArray = bat1.getJSONArray("scores");

                    batT1TitleTv.setText(bat1Title);
                    for (int i=0; i<bat1ScoresJArray.length(); i++){
                        String batsmen = bat1ScoresJArray.getJSONObject(i).getString("batsman");
                        String balls = bat1ScoresJArray.getJSONObject(i).getString("B");
                        String runs = bat1ScoresJArray.getJSONObject(i).getString("R");
                        String fours = bat1ScoresJArray.getJSONObject(i).getString("4s");
                        String sixes = bat1ScoresJArray.getJSONObject(i).getString("6s");
                        String strikeRate = bat1ScoresJArray.getJSONObject(i).getString("SR");
                        String dismissalInfo = bat1ScoresJArray.getJSONObject(i).getString("dismissal-info");

                        batT1DetailTv.append("Batsman: " +batsmen
                                +"\nBalls: " +balls
                                +"\nRuns: " +runs
                                +"\n4s: " +fours
                                +"\n6s: " +sixes
                                +"\nSR: " +strikeRate
                                +"\nDismissal Info: " +dismissalInfo
                                +"\n\n");
                    }

                    batT2TitleTv.setText(bat2Title);
                    for (int i=0; i<bat2ScoresJArray.length(); i++){
                        String batsmen = bat2ScoresJArray.getJSONObject(i).getString("batsman");
                        String balls =bat2ScoresJArray.getJSONObject(i).getString("B");
                        String runs = bat2ScoresJArray.getJSONObject(i).getString("R");
                        String fours = bat2ScoresJArray.getJSONObject(i).getString("4s");
                        String sixes = bat2ScoresJArray.getJSONObject(i).getString("6s");
                        String strikeRate = bat2ScoresJArray.getJSONObject(i).getString("SR");
                        String dismissalInfo = bat2ScoresJArray.getJSONObject(i).getString("dismissal-info");

                        batT2DetailTv.append("Batsman: " +batsmen
                                +"\nBalls: " +balls
                                +"\nRuns: " +runs
                                +"\n4s: " +fours
                                +"\n6s: " +sixes
                                +"\nSR: " +strikeRate
                                +"\nDismissal Info: " +dismissalInfo
                                +"\n\n");

                    }

                    String manOfTheMatch = "", tossWinner = "", winnerTeam = "";

                    try {
                        manOfTheMatch = dataJObject.getJSONObject("man-of-the-match").getString("name");
                    }
                    catch (Exception e){

                    }
                    try {
                        tossWinner = dataJObject.getString("toss_winner_team");
                    }
                    catch (Exception e){

                    }
                    try {
                        winnerTeam = dataJObject.getString("winner_team");
                    }
                    catch (Exception e){

                    }

                    otherResultsTv.setText("Toss Winner: " +tossWinner
                    +"\nWinner: " +winnerTeam
                    +"\nMan of the Match: " +manOfTheMatch);

                }
                catch (Exception e){
                    Toast.makeText(MatchSummaryActivity.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MatchSummaryActivity.this, "Error: "+error.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    @Override
    protected void onDestroy() {
        if (adView1 != null) {
            adView1.destroy();
        }

        super.onDestroy();
    }


}