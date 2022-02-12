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

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ExampleViewHolder> {
    private Context mContext;
    private ArrayList<FetchNews> ExampleList;

    public NewsAdapter(Context mContext, ArrayList<FetchNews> exampleList) {
        this.mContext = mContext;
        ExampleList = exampleList;
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.newssinglerow,parent,false);
        return new ExampleViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {

        FetchNews currentItem = ExampleList.get(position);

        String Text1 = currentItem.getTitle1();
        String Text2 = currentItem.getSubtitle();


        holder.textView1.setText(Text1);
        holder.textView2.setText(Text2);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),MainActivity3.class);
                intent.putExtra("innerdesc1",currentItem.getDesc1());
                intent.putExtra("innerdesc2",currentItem.getDesc2());
                intent.putExtra("innerdesc3",currentItem.getDesc3());
                intent.putExtra("innerimg1",currentItem.getPurl1());
                intent.putExtra("innerimg2",currentItem.getPurl2());
                intent.putExtra("innerimg3",currentItem.getPurl3());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                v.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() { return ExampleList.size(); }

    public class ExampleViewHolder extends RecyclerView.ViewHolder{
        TextView textView1,textView2;

        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            textView1 = itemView.findViewById(R.id.title3);
            textView2 = itemView.findViewById(R.id.subtitle);
        }
    }

}
