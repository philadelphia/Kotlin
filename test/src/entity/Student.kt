package entity

/**
 * Created by Tao.ZT.Zhang on 2017/6/14.
 */
class Student(var score: Int) : Person(" ", 0) {

    init {
        println("init class Student")
    }

    constructor(name:String, age:Int,score: Int):this(score)

    override fun printInfo() {
        println("this is class Student")
        println("name: " + name)
        println("age:  "+age)
        println("score: "+score)

    }

    fun add(base: Base){
        base.print()
        base.countPlusPlus()
        base.countMinusMinus()
    }
}