package com.mega.king11;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RankTeamAdapter extends RecyclerView.Adapter<RankTeamAdapter.ExampleViewHolder> {

    private Context mContext;
    private ArrayList<FetchRankTeam> ExampleList;

    public RankTeamAdapter(Context mContext, ArrayList<FetchRankTeam> exampleList) {
        this.mContext = mContext;
        ExampleList = exampleList;
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.tsingle,parent,false);
        return new ExampleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        FetchRankTeam currentItem = ExampleList.get(position);

        String Text1 = currentItem.getSno().toString();
        String Text2 = currentItem.getTeam();
        String Text3 = currentItem.getRating().toString();
        String Text4 = currentItem.getPoint().toString();

        holder.sno.setText(Text1);
        holder.team.setText(Text2);
        holder.rating.setText(Text3);
        holder.point.setText(Text4);

    }

    @Override
    public int getItemCount() {
        return ExampleList.size();
    }

    class  ExampleViewHolder extends RecyclerView.ViewHolder
    {
        TextView sno,team,rating,point;
        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            sno = itemView.findViewById(R.id.sno);
            team = itemView.findViewById(R.id.team);
            rating = itemView.findViewById(R.id.rating);
            point = itemView.findViewById(R.id.point);

        }
    }
}
