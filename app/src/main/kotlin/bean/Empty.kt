package bean

import android.util.Log

/**
 * Created by jishubu1 on 2016/3/18.
 */
class Empty(name: String = "") {


    init {
        Log.d(this.javaClass.name, "name =$name")
    }

    constructor(name: String, empty: Empty) : this(name) {

    }

}