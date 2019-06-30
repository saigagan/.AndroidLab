package com.example.cvr.studentdetails;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private ArrayList<Student> dataset;
    private ClickListener mListener;

    public static interface ClickListener {
        public void onClick(int position);
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView name, rollno;
        public ClickListener mListener;
        public MyViewHolder(View v, ClickListener mListener) {
            super(v);
            name = v.findViewById(R.id.title);
            rollno = v.findViewById(R.id.subtitle);

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

    public MyAdapter(ArrayList<Student> dataset, ClickListener mListener) {
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
        holder.name.setText(dataset.get(position).Name);
        holder.rollno.setText("Roll No: " + dataset.get(position).rollno);
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }
}
