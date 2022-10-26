package ru.hivislav.pddtestapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.hivislav.pddtestapp.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.mainContainer, WelcomeFragment.newInstance())
                .commit()
        }
    }
}