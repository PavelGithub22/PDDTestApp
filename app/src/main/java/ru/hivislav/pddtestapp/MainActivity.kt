package ru.hivislav.pddtestapp

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import ru.hivislav.pddtestapp.data.RepositoryImpl

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val repositoryImpl = RepositoryImpl(this.application)

        val imageView = findViewById<ImageView>(R.id.imageView)
        val btn = findViewById<Button>(R.id.btn)
        btn.setOnClickListener {
            imageView.setImageResource(repositoryImpl.generateQuestion().pictureOfQuestion)
        }
    }
}