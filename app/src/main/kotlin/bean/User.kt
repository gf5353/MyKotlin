package bean

/**
 * Created by gf535 on 2016/3/13 0013.
 * var 可变参数类型，val不可变参数类型相当于final
 *
 */
data class User(
        var name: String,
        var age: Int,
        var email: String

        //private -- 只在声明的范围和同一个模块的子范围可见；
        //
        //protected -- (只可以用在类或接口的成员上)和 privete 很像，但在子类中也可见；
        //
        //internal -- (默认使用) 在同一个模块中都可见；
        //
        //public -- 在任何地方均可见；
)