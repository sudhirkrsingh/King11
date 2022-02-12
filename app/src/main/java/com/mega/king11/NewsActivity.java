package com.mega.king11;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class NewsActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    RecyclerView recyclerView;
    ArrayList<FetchNews> mExampleList2;
    NewsAdapter NewsAdapter;
    RequestQueue requestQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        recyclerView=findViewById(R.id.vrecviewone);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //here we start  for news Activity...
        mExampleList2=new ArrayList<>();

        requestQueue = Volley.newRequestQueue(this);
        parseJSON();


        //intialize and asign value
         bottomNavigationView =(BottomNavigationView)findViewById(R.id.BottomNavigation);
        //set home selected
        bottomNavigationView.setSelectedItemId(R.id.news);

        //perform itemselectedlistner
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.news:
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

    private void parseJSON() {

        String url ="https://drive.google.com/uc?export=download&id=16xYoVbWpOLlxB5kLd096Pq6JcNt3OKKd";

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

                        String title1 = match.getString("title1");
                        String subtitle = match.getString("subtitle");
                        String desc1 = match.getString("desc1");
                        String desc2 = match.getString("desc2");
                        String desc3 = match.getString("desc3");
                        String purl1 = match.getString("purl1");
                        String purl2 = match.getString("purl2");
                        String purl3 = match.getString("purl3");

                        mExampleList2.add(new FetchNews(desc1,desc2,desc3,purl1,purl2,purl3,title1,subtitle));

                    }

                    NewsAdapter = new NewsAdapter(NewsActivity.this,mExampleList2);
                    recyclerView.setAdapter(NewsAdapter);

                } catch (JSONException e) {
                    Toast.makeText(NewsActivity.this, "Error"+e, Toast.LENGTH_SHORT).show();

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(NewsActivity.this, "Error"+error, Toast.LENGTH_SHORT).show();

            }
        });
        requestQueue.add(request);
    }

    @Override
    public void onBackPressed() {
        bottomNavigationView.setSelectedItemId(R.id.home);
    }

}