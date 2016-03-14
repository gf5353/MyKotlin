package example

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import bean.User
import com.example.mykotlin.R
import kotlinx.android.synthetic.main.activity_sample1.*

/**
 * Created by gf535 on 2016/3/13 0013.
 */
class SampleActivity1 : AppCompatActivity() {

    /*
     * 可变参数申明类型
     */
    var x: Int = 5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample1)

        val user = User("小明", 2)//name,age,对应构造函数类型 var是可变变量，val是不可变(相当于final)
        var usr = User("小红", 3)

        x += 1
        Toast.makeText(baseContext, "总年龄：" + sum(user.age, usr.age), Toast.LENGTH_LONG).show();
    }

    fun sum(a: Int, b: Int): Int {
        var sum = a + b
        print(sum)
        return sum
    }

    fun sum2(a: Int, b: Int): Int = a + b

    fun sum3(a: Int, b: Int) = a + b

}