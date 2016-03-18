package example

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import bean.Empty
import bean.I_Say
import com.example.mykotlin.R

/**
 * Created by jishubu1 on 2016/3/18.
 */
class SampleActivity2 : AppCompatActivity() {
    private var tag: String = "SampleActivity2"
    fun log(log: String): Unit {
        //返回空类型可忽略
        Log.d(tag, log)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample2)
        var empty = Empty()

        var chi = Chinese()
        var eng = English()
        chi.hello()
        eng.hello()
    }
}

class Chinese() : I_Say() {
    override fun hello() {
        Log.d("SampleActivity2", "你好")
    }
}

class English() : I_Say() {
    override fun hello() {
        Log.d("SampleActivity2", "hello")
    }
}


