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


public class BatsmenOdiFragment extends Fragment {
    RadioButton button1,button3,button4,button6,button7;
    RecyclerView recyclerView;
    ArrayList<FetchRankPlayer> mExampleList2;
    RankPlayerAdapter rankPlayerAdapter;
    RequestQueue requestQueue;


    public BatsmenOdiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_batsmen_odi, container, false);
        recyclerView=view.findViewById(R.id.recview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        button1=(RadioButton)view.findViewById(R.id.button21);
        button3=(RadioButton)view.findViewById(R.id.button23);
        button4=(RadioButton)view.findViewById(R.id.button24);
        button6=(RadioButton)view.findViewById(R.id.button26);
        button7=(RadioButton)view.findViewById(R.id.button27);

        mExampleList2=new ArrayList<>();
        requestQueue = Volley.newRequestQueue(getContext());

        String url ="https://drive.google.com/uc?export=download&id=18-gOj3OE8Hgxqy96CLxlHmfEAkjCYxQQ";
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
                        String player = match.getString("player");
                        String team = match.getString("team");
                        Long point = match.getLong("point");

                        mExampleList2.add(new FetchRankPlayer(team,player,sno,point));

                    }

                    rankPlayerAdapter = new RankPlayerAdapter(getContext(),mExampleList2);
                    recyclerView.setAdapter(rankPlayerAdapter);

                } catch (JSONException e) {

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {


            }
        });
        requestQueue.add(request);



        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr=getFragmentManager().beginTransaction();
                fr.replace(R.id.Frame,new TeamOdiFragment());
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

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr=getFragmentManager().beginTransaction();
                fr.replace(R.id.Frame,new BatsmenTestFragment());
                fr.commit();

            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr=getFragmentManager().beginTransaction();
                fr.replace(R.id.Frame,new BatsmenT20Fragment());
                fr.commit();

            }
        });

         return view;
    }

}