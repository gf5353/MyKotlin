package com.example.mykotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import example.SampleActivity1
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv.text = "Hello MyKotlin"
        tv.textSize = 20.0f
        btn_sample_1.setOnClickListener {
            v: View ->
            startActivity(Intent(this, SampleActivity1::class.java))
        }
    }

}

