package com.example.myimad_project2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar

class Nextpage : AppCompatActivity() {

    private val handler = Handler()

    @SuppressLint("MissingInflatedId", "CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nextpage)

        val feed = findViewById<Button>(R.id.buttonHungry)
        val clean= findViewById<Button>(R.id.buttonClean)
        val happy= findViewById<Button>(R.id.buttonHappy)
        val image = findViewById<ImageView>(R.id.imageView3)

        image.setImageResource(R.drawable.pngegg)

        val hungerProgressBar = findViewById<ProgressBar>(R.id.hungerProgressBar)
        val cleanProgressBar = findViewById<ProgressBar>(R.id.cleanProgressBar)
        val happyProgressBar = findViewById<ProgressBar>(R.id.happyProgressBar)


        feed.setOnClickListener {
            test(image, R.drawable.hungryreggie2)
            updateHungerProgress(hungerProgressBar)
            decreaseProgressOverTime(hungerProgressBar)
        }

        clean.setOnClickListener {
            test(image, R.drawable.cleanreggie)
            updateCleanProgress(cleanProgressBar)
            decreaseProgressOverTime(cleanProgressBar)
        }
        happy.setOnClickListener {
            test(image, R.drawable.happyreggie)
            updateHappyProgress(happyProgressBar)
            decreaseProgressOverTime(happyProgressBar)
        }
    }

    private fun test(imageView3: ImageView, drawableId: Int) {
        imageView3.setImageResource(drawableId)
    }

    private fun updateHungerProgress(progressBar: ProgressBar){
        //Update hunger progress bar in increments of 10
        if (progressBar.progress + 10 <= progressBar.max) {
            progressBar.progress += 10
        } else {
            // If progress is at Max
            progressBar.progress = progressBar.max
        }
    }

    private fun updateCleanProgress(progressBar: ProgressBar){
        //Update hunger progress bar in increments of 10
        if (progressBar.progress + 10 <= progressBar.max) {
            progressBar.progress += 10
        } else {
            // If progress is at Max
            progressBar.progress = progressBar.max
        }
    }

    private fun updateHappyProgress(progressBar: ProgressBar){
        //Update hunger progress bar in increments of 10
        if (progressBar.progress + 10 <= progressBar.max) {
            progressBar.progress += 10
        } else {
            // If progress is at Max
            progressBar.progress = progressBar.max
        }
    }

    private fun decreaseProgressOverTime(progressBar: ProgressBar) {
        // Decreasing the bar overtime
        handler.postDelayed(object : Runnable {
            override fun run() {
                if (progressBar.progress >= 10) {
                    progressBar.progress -= 1
                }
                handler.postDelayed(this,40000) // Repeat every 40 seconds
            }
        }, 20000) // Start after 20 seconds
    }
}