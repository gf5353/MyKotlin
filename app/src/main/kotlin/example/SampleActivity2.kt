package example

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import bean.Empty
import com.example.mykotlin.R

/**
 * Created by jishubu1 on 2016/3/18.
 */
class SampleActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_sample2)

        var empty = Empty()
    }
}