package bean

import android.util.Log

/**
 * Created by jishubu1 on 2016/3/18.
 */
open class Empty(name: String = "") {


    init {
        Log.d(this.javaClass.name, "name =$name")
    }

    constructor(name: String, empty: Empty) : this(name) {

    }

    open fun hello() {
        Log.d("SayHello", "Empty SayHello!!!!!!")
    }

    interface SayHello {
        fun hello() {
            Log.d("SayHello", "SayHello!!!!!!")
        }
    }

    open class NewEmpty() : Empty(), SayHello {
        final override fun hello() {
            super<Empty>.hello()    //可以选择性的用谁的父类方法
            super<SayHello>.hello()
        }
    }

    //    class NewE() : NewEmpty() {
    //        override fun hello() {
    //            super.hello()
    //        }
    //    }
}
