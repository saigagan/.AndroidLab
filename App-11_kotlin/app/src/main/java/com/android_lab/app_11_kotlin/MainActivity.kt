package com.android_lab.app_11_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONArray
import java.io.File
import java.io.InputStreamReader

class MainActivity : AppCompatActivity(), MyAdapter.ClickListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    private var cars = arrayOf<Car>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cars = readJSON()

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

    fun readJSON(): Array<Car> {
        val json = assets.open("cars.json").bufferedReader().use { it.readText() }
        return Gson().fromJson(json, Array<Car>::class.java)
    }

}
