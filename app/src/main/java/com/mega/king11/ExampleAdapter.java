package com.mega.king11;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {
    public Context mContext;
    private ArrayList<ExampleItem> mExampleList;

    public ExampleAdapter(Context context,ArrayList<ExampleItem> exampleList)
    {
        mContext = context;
        mExampleList= exampleList;
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View v = LayoutInflater.from(mContext).inflate(R.layout.hsinglerow,parent,false);
      return new ExampleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        ExampleItem currentItem = mExampleList.get(position);

        String seriesName = currentItem.getmSeriesName();
        String uniqueId = currentItem.getuId();

        holder.mTextView.setText(seriesName);
        holder.jTextView.setText(uniqueId);


        holder.button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String matchId =currentItem.getId();
                Intent intent = new Intent(mContext,MatchSummaryActivity.class);
                intent.putExtra("match_id",matchId);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }

    public class ExampleViewHolder extends RecyclerView.ViewHolder
    {
        public TextView mTextView,jTextView;
        public Button button1;

        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextView = (itemView).findViewById(R.id.venue);
            jTextView = (itemView).findViewById(R.id.uniqueid);
            button1 = (itemView).findViewById(R.id.MatchSummary);

        }
    }
}
