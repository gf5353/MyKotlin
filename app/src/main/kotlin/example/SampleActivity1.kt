package example

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.TextView
import bean.User
import com.example.mykotlin.R
import java.util.*

/**
 * Created by gf535 on 2016/3/13 0013.
 *
 * 数据对象的使用
 */
class SampleActivity1 : AppCompatActivity() {


    /**
     *1.函数方法的定义
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
    private var tv_sample1: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample1)
        tv_sample1 = findViewById(R.id.tv_sample1) as TextView?
        createMode()
        //        changeData()
        //        control()
        //        breakAndContinue()
    }


    /**
     * 2.对象创建，及相关方法说明
     */
    fun createMode() {
        val user = User("A", 2, "562401002@qq.com")//name,age,对应构造函数类型 var是可变变量，val是不可变(相当于final)
        var u = User()
        var usr = user.copy(age = 1)
        usr = user.copy("B")

        this.log(String.format("name = %s email = %s", usr.component1(), usr.component3()))//get方法按照构造函数的顺序生成，不过貌似没有set方法


        //字符串模板表达式
        var (name, age) = user//多重申明方式
        this.log("name=$name,age= $age ")

        var name1 = user.name
        var name2 = usr.name
        var sum = "$name1 和 $name2 的年龄之和为 ${sum(user.age, usr.age)}"
        this.log(sum)
    }

    /**
     *3.基本数据类型操作
     */
    fun changeData() {
        val b: Byte = 0
        var i: Int = b.toInt() //显式转换
        var str: String = "hello word ! \n"
        this.log(String.format("$str has word is %b \n", str.compareTo("word")))

        // var arry: Array<User> = emptyArray() //返回指定类型空数组,指定大小为0，不能添加？
        var arry: Array<User?> = arrayOfNulls(str.length)
        for (c in  str) {
            var name = c.toString()//需要char 转string
            var user = User(name, i + 1, "")
            this.log(user.name)
            arry.set(i++, user)//和java不同，没有add方法，需要预先指定大小
        }
        this.log("size = " + arry.size + "\n")
    }

    /**
     * 3.表达式控制相关
     */
    private fun control() {
        var a: Int = 1
        var b: Int = 2
        //传统用法
        var max: Int = a
        if (a < b)
            max = b

        //带 else
        if (a > b)
            max = a
        else
            max = b

        //作为表达式 返回最后的值
        max = if (a > b) a else b
        max = if (a > b) {
            print("Choose a")
            a
        } else {
            print("Choose b")
            b
        }
        this.log("max:" + max.toString() + "\n")

        //When 表达式 代替switch
        var randInt = Random().nextInt(10)
        var rand = when (randInt) {
            1 -> {
                this.log("randInt =1")
                randInt
            }
            2, 3 -> {
                this.log("randInt = 2 or 3")  //多分支处理
                randInt
            }
            in 4..6 -> {
                this.log("randInt in 4-6")  //区间检查
                randInt
            }
            else -> {
                this.log("randInt = other:" + randInt)
                randInt
            }
        }
        //当做if else if 表达式
        when {
            rand in   0..5 -> this.log(" in 0-5")
            rand == 6 -> this.log(" is 6")
            else -> this.log(" is other")
        }
        var users: Array<User?> = arrayOfNulls(10)
        for (i in users.indices) {
            //通过索引迭代
            var usr = User("" + i, i + 1, "")
            //            usr.name = null!!//抛出KotlinNullPointerException
            users.set(i, usr)
        }
        for (user in users) {
            this.log("name=" + user?.name + "age:" + user?.age)//空安全调用操作符
        }
    }

    /**
     *4.返回与跳转
     */
    private fun breakAndContinue() {
        //@标签的使用，可以决定 在哪break或者continue
        loop@for (i in 1..10) {
            for (j in 1..10) {
                if (j == 6) {
                    this.log(" break i=" + i + "j=" + j)
                    break@loop //不加标签则结束本次循环
                }
                this.log("i=" + i + "j=" + j)
            }
        }
        foo()
    }

    fun foo() {
        var users: Array<User?> = arrayOfNulls(10)
        for (i in users.indices) {
            var usr = User("name" + i, i, "")
            users.set(i, usr)
        }
        users.forEach {
            this.log("i:" + it?.name + "size=" + users.size)
            if (it?.age == 3) {
                this.log("return" + it?.age)
                return@forEach //可以通过函数名代替表达式
            }
        }
    }

    fun log(log: String): Unit {
        //返回空类型可忽略
        Log.d(tag, log)
        var buffer = StringBuffer()
        buffer.appendln(tv_sample1?.text?.trim())
        buffer.appendln(log)
        tv_sample1?.setText(buffer.toString())
    }

}