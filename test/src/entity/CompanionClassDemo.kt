package entity

/**
 * Created by Tao.ZT.Zhang on 2017/6/30.
 */
//class CompanionClassDemo {
//    companion object {
//
//    }
//}

class CompanionClassDemo{
    companion object Factory{
        fun create():String{
            return "hello,Companion Class"
        }

    }
}