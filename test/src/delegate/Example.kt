package delegate

/**
 * Created by Tao.ZT.Zhang on 2017/6/30.
 */
class Example constructor(val score:Int = 88) {

    var name:String by Delegate()
    val socre:Int by DelegateForInt()
}