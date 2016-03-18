package com.example.mykotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import example.SampleActivity1
import example.SampleActivity2

class MainActivity : AppCompatActivity() {
    var tv: TextView ? = null
    var btn_sample_1: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv = findViewById(R.id.tv) as TextView?
        btn_sample_1 = findViewById(R.id.btn_sample_1) as Button?
        tv!!.text = "Hello MyKotlin"
        (tv as TextView).textSize = 20.0f
        btn_sample_1?.setOnClickListener(onclick)
        findViewById(R.id.btn_sample_2).setOnClickListener(onclick)
    }


    var onclick = View.OnClickListener { v: View ->
        when (v?.id) {
            R.id.btn_sample_1 -> {
                startActivity(Intent(this, SampleActivity1::class.java))
            }
            R.id.btn_sample_2 -> {
                startActivity(Intent(this, SampleActivity2::class.java))
            }
        }
    }
}

