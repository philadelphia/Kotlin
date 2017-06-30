package delegate

/**
 * Created by Tao.ZT.Zhang on 2017/6/30.
 */
class User(var map:MutableMap<String,Any>) {
    val name:String by map
    var age:Int by map
    var address:String by map

}