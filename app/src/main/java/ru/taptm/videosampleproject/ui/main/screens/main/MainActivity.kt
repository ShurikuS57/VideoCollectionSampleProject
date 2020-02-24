package ru.taptm.videosampleproject.ui.main.screens.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.taptm.videosampleproject.R
import ru.taptm.videosampleproject.ui.main.screens.collections.CollectionsFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        savedInstanceState ?: supportFragmentManager.beginTransaction()
            .replace(
                R.id.container,
                CollectionsFragment.newInstance()
            )
            .commit()
    }
}
