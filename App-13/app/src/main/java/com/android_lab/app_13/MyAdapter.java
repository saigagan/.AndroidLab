package com.android_lab.app_13;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    public ArrayList<Message> dataset;
    private ClickListener mListener;

    public static interface ClickListener {
        public void onClick(int position);
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView title, subtitle;
        public ClickListener mListener;

        public MyViewHolder(View v, ClickListener mListener) {
            super(v);
            title = v.findViewById(R.id.title);
            subtitle = v.findViewById(R.id.subtitle);

            this.mListener = mListener;
            v.setOnClickListener(onClickListener);
        }

        private final View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onClick(getAdapterPosition());
            }
        };
    }

    public MyAdapter(ArrayList<Message> dataset, ClickListener mListener) {
        this.dataset = dataset;
        this.mListener = mListener;
    }

    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = (View) LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_layout, parent, false);

        MyViewHolder vh = new MyViewHolder(v, mListener);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.title.setText(dataset.get(position).address);
        holder.subtitle.setText(dataset.get(position).body);
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }
}
