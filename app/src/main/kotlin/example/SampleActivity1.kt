package example

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import bean.User
import com.example.mykotlin.R
import kotlinx.android.synthetic.main.activity_sample1.*

/**
 * Created by gf535 on 2016/3/13 0013.
 *
 * 数据对象的使用
 */
class SampleActivity1 : AppCompatActivity() {


    /**
     *1.函数方法的订阅
     * 参数：类型 返回类型也基本和java语法相反
     */
    fun sum(a: Int, b: Int): Int {
        var sum = a + b
        print(sum)
        return sum
    }

    fun sum2(a: Int, b: Int): Int = a + b
    fun sum3(a: Int, b: Int) = a + b

    /*
       * 可变参数申明类型
          */
    private var x: Int = 5
    private var tag: String = "SampleActivity1"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample1)
        createMode()
        changeData()
    }

    /**
     * 2.对象创建，及相关方法说明
     */
    fun createMode() {
        val user = User("小明", 2, "562401002@qq.com")//name,age,对应构造函数类型 var是可变变量，val是不可变(相当于final)
        var usr = user.copy(name = "小红")//"小红", 3
        Log.d(tag, String.format("name = %s email = %s", usr.component1(), usr.component3()))//get方法按照构造函数的顺序生成，不过貌似没有set方法
        //字符串模板表达式
        var name1 = user.name
        var name2 = usr.name
        var sum = "$name1 和 $name2 的年龄之和为 ${sum(user.age, usr.age)}"
        Log.d(tag, sum)
    }

    /**
     *3.基本类型转换
     */
    fun changeData() {
        val b: Byte = 1
        val i: Int = b.toInt() //显式转换
    }

}