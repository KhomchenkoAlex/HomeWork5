package com.example.android.hw5

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.android.hw5.fragments.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frame_fragment, MainFragment())
        transaction.commit()
    }
}
