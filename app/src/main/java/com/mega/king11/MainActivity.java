package com.mega.king11;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static String PACKAGE_NAME;
    RecyclerView vrecview,recyclerView;
    ArrayList<FetchFantasyNews> mExampleList2;
    FantasyNewsAdapter fantasyNewsAdapter;
    RequestQueue requestQueue;



    ImageView imageView;

    private ExampleAdapter mExampleAdapter;
    private ArrayList<ExampleItem> mExampleList;
    private RequestQueue mRequestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });


        // this is for our share button working
        PACKAGE_NAME=getApplicationContext().getPackageName();

        imageView = (ImageView)findViewById(R.id.share);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String value="https://play.google.com/store/apps/details?id="+PACKAGE_NAME;
                intent.putExtra(Intent.EXTRA_TEXT,value);
                startActivity(Intent.createChooser(intent,"share via"));
            }
        });

        vrecview = (RecyclerView) findViewById(R.id.vrecview);
        vrecview.setLayoutManager(new LinearLayoutManager(this));

        recyclerView = (RecyclerView) findViewById(R.id.hrecview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));


        //this is for scorecard
        mExampleList = new ArrayList<>();

        mRequestQueue = Volley.newRequestQueue(this);
        parseJSON();


       //here we start our Fantasy News API Calling...
        mExampleList2=new ArrayList<>();

        requestQueue = Volley.newRequestQueue(this);
        parseJSON2();


        //in this portion for bottom navigation
        //intialize and asign value
        BottomNavigationView bottomNavigationView =(BottomNavigationView)findViewById(R.id.BottomNavigation);
        //set home selected
        bottomNavigationView.setSelectedItemId(R.id.home);


       //perform itemselectedlistner
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        return true;
                    case R.id.news:
                        startActivity(new Intent(getApplicationContext(),NewsActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.rank:
                        startActivity(new Intent(getApplicationContext(),RankActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

    }

    private void parseJSON2() {
        String url ="https://drive.google.com/uc?export=download&id=1elNdZwcouG2NxxRrRDmjZvc7mpUsm8Fr";

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {


            @Override
            public void onResponse(JSONObject response) {
                progressDialog.dismiss();
                try {
                    JSONArray jsonArray = response.getJSONArray("matches");

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject match = jsonArray.getJSONObject(i);

                        String title = match.getString("title");
                        String description = match.getString("desc");

                        mExampleList2.add(new FetchFantasyNews(title, description));

                    }

                    fantasyNewsAdapter = new FantasyNewsAdapter(MainActivity.this,mExampleList2);
                    vrecview.setAdapter(fantasyNewsAdapter);

                } catch (JSONException e) {
                    e.printStackTrace();

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(request);
    }

    private void parseJSON() {
          String url = "https://cricapi.com/api/matches/IsBQEmFUaYScy3eFQ6RLYRFH8Yv1";

          final ProgressDialog pd = new ProgressDialog(this);
          pd.setMessage("Loading...");
          pd.show();

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        pd.dismiss();
                        try {
                            JSONArray jsonArray = response.getJSONArray("matches");

                            for (int i =0; i<10; i++)
                            {
                                JSONObject match = jsonArray.getJSONObject(i);

                                String seriesName = match.getString("team-1");
                                String uniqueId = match.getString("team-2");
                                String id = match.getString("unique_id");


                               mExampleList.add(new ExampleItem(seriesName,uniqueId,id));
                            }

                            mExampleAdapter = new ExampleAdapter(MainActivity.this, mExampleList);
                            recyclerView.setAdapter(mExampleAdapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        mRequestQueue.add(request);

    }


    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finishAffinity();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();

    }

}