package com.furkan.marvel.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.furkan.marvel.R
import com.furkan.marvel.adapters.ComicsAdapter
import com.furkan.marvel.utils.Globals

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val image = findViewById<ImageView>(R.id.image)
        val desc = findViewById<TextView>(R.id.desc)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            true
        )

        val adapter = ComicsAdapter(Globals.shared.Comics!!)

        recyclerView.adapter = adapter

        desc.text = intent.getStringExtra("desc")

        Glide.with(this)
            .load(intent.getStringExtra("img"))
            .transform(CenterCrop())
            .into(image)
    }
}