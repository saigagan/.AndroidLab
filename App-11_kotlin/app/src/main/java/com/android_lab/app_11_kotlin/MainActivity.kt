package com.android_lab.app_11_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), MyAdapter.ClickListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    private var cars = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cars.add("Model S")
        cars.add("Model X")
        cars.add("Model 3")
        cars.add("Model Y")
        cars.add("Roadster")

        viewManager = LinearLayoutManager(this)
        viewAdapter = MyAdapter(cars, this)
        val itemDecoration = DividerItemDecoration(this, (viewManager as LinearLayoutManager).getOrientation())

        recyclerView = findViewById<RecyclerView>(R.id.recyclerView).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
            addItemDecoration(itemDecoration)
        }
    }

    override fun onClick(position: Int) {
        Toast.makeText(this, "Selected: " + cars.get(position), Toast.LENGTH_LONG).show()
    }

}
