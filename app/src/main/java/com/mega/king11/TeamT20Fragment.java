package com.mega.king11;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class TeamT20Fragment extends Fragment {
    RadioButton button2,button3,button4,button5,button6;
    RecyclerView recyclerView;
    ArrayList<FetchRankTeam> mExampleList2;
    RankTeamAdapter rankTeamAdapter;
    RequestQueue requestQueue;


    public TeamT20Fragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_team_t20, container, false);

        recyclerView=view.findViewById(R.id.recview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        button2=(RadioButton)view.findViewById(R.id.button22);
        button3=(RadioButton)view.findViewById(R.id.button23);
        button4=(RadioButton)view.findViewById(R.id.button24);
        button5=(RadioButton)view.findViewById(R.id.button25);
        button6=(RadioButton)view.findViewById(R.id.button26);

        mExampleList2=new ArrayList<>();
        requestQueue = Volley.newRequestQueue(getContext());

        String url ="https://drive.google.com/uc?export=download&id=1uzG7rzn5BWXHzMa1l27EUfkzFqdyMEnu";
        final ProgressDialog progressDialog = new ProgressDialog(getContext());
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

                        Long sno = match.getLong("sno");
                        String team = match.getString("team");
                        Long rating = match.getLong("rating");
                        Long point = match.getLong("point");

                        mExampleList2.add(new FetchRankTeam(team,sno,rating,point));

                    }

                    rankTeamAdapter = new RankTeamAdapter(getContext(),mExampleList2);
                    recyclerView.setAdapter(rankTeamAdapter);


                } catch (JSONException e) {

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {


            }
        });
        requestQueue.add(request);





        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr=getFragmentManager().beginTransaction();
                fr.replace(R.id.Frame,new BatsmenOdiFragment());
                fr.commit();

            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr=getFragmentManager().beginTransaction();
                fr.replace(R.id.Frame,new BowlerOdiFragment());
                fr.commit();

            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr=getFragmentManager().beginTransaction();
                fr.replace(R.id.Frame,new AllRounderOdiFragment());
                fr.commit();

            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr=getFragmentManager().beginTransaction();
                fr.replace(R.id.Frame,new TeamOdiFragment());
                fr.commit();


            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr=getFragmentManager().beginTransaction();
                fr.replace(R.id.Frame,new TeamTestFragment());
                fr.commit();

            }
        });

        return view;
    }

}