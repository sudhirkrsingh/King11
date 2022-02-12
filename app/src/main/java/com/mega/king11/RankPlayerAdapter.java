package com.mega.king11;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RankPlayerAdapter extends RecyclerView.Adapter<RankPlayerAdapter.ExampleViewHolder> {

    private Context mContext;
    private ArrayList<FetchRankPlayer> ExampleList;

    public RankPlayerAdapter(Context mContext, ArrayList<FetchRankPlayer> exampleList) {
        this.mContext = mContext;
        ExampleList = exampleList;
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.ptsingle,parent,false);
        return new ExampleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {

        FetchRankPlayer currentItem = ExampleList.get(position);

        String Text1 = currentItem.getSno().toString();
        String Text2 = currentItem.getPlayer();
        String Text3 = currentItem.getTeam();
        String Text4 = currentItem.getPoint().toString();

        holder.snoplayer.setText(Text1);
        holder.playername.setText(Text2);
        holder.playerteam.setText(Text3);
        holder.playerpoint.setText(Text4);

    }

    @Override
    public int getItemCount() {
        return ExampleList.size();
    }

    class  ExampleViewHolder extends RecyclerView.ViewHolder
    {
        TextView snoplayer,playername,playerteam,playerpoint;
        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            snoplayer = itemView.findViewById(R.id.snoplayer);
            playername = itemView.findViewById(R.id.playername);
            playerteam= itemView.findViewById(R.id.playerteam);
            playerpoint= itemView.findViewById(R.id.playerpoint);

        }
    }
}
