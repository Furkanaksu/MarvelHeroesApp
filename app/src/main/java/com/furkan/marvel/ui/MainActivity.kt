package com.furkan.marvel.ui

import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import com.furkan.marvel.R


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val frame = findViewById<FrameLayout>(R.id.frame)
        this.supportFragmentManager
            .beginTransaction()
            .replace(
                R.id.frame,
                CharactersFragment()
            )
            .commit()

    }
}