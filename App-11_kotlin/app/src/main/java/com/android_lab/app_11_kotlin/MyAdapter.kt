package com.android_lab.app_11_kotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val dataset: Array<Car>, private val mListener: ClickListener): RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    interface ClickListener {
        fun onClick(position: Int)
    }

    class MyViewHolder(val view: View, val mListener: ClickListener): RecyclerView.ViewHolder(view) {
        var title: TextView
        val onClickListener = View.OnClickListener {
            mListener.onClick(adapterPosition)
        }

        init {
            title = view.findViewById(R.id.title)
            view.setOnClickListener(onClickListener)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cell_layout, parent, false)

        return MyViewHolder(view, mListener)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title.text = dataset[position].name
    }

    override fun getItemCount() = dataset.size

}