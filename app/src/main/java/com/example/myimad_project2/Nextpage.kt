package com.example.myimad_project2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class Nextpage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nextpage)

        val feed = findViewById<Button>(R.id.buttonHungry)
        val clean= findViewById<Button>(R.id.buttonClean)
        val happy= findViewById<Button>(R.id.buttonHappy)
        val image = findViewById<ImageView>(R.id.imageView3)

        feed.setOnClickListener {
            test(image, R.drawable.hungryreggie)
        }

        clean.setOnClickListener {
            test(image, R.drawable.cleanreggie)
        }
        happy.setOnClickListener {
            test(image, R.drawable.happyreggie)
        }
    }

    private fun test(imageView3: ImageView, drawableId: Int) {
        imageView3.setImageResource(drawableId)

    }
}