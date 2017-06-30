package entity

/**
 * Created by Tao.ZT.Zhang on 2017/6/27.
 */
open class Person constructor(var name: String, var age: Int) {

    open fun printInfo() {
        println("this is class Person")
        println("name: " + name)
        println("age: " + age)
    }


}
