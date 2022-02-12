package com.mega.king11;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FantasyNewsAdapter extends RecyclerView.Adapter<FantasyNewsAdapter.ExampleViewHolder> {

    private Context mContext;
    private ArrayList<FetchFantasyNews> ExampleList;


    public FantasyNewsAdapter(Context mContext, ArrayList<FetchFantasyNews> ExampleList) {
        this.mContext = mContext;
        this.ExampleList = ExampleList;
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.singlerow,parent,false);
        return new ExampleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        FetchFantasyNews currentItem = ExampleList.get(position);

        String Text1 = currentItem.getTitle();
        holder.textView1.setText(Text1);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),MainActivity2.class);
                intent.putExtra("header",currentItem.getDesc());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                v.getContext().startActivity(intent);
            }
        });



    }

    @Override
    public int getItemCount() {
        return ExampleList.size();
    }


    public class ExampleViewHolder extends RecyclerView.ViewHolder{
        TextView textView1;

        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            textView1 = itemView.findViewById(R.id.title1);
        }
    }
}
