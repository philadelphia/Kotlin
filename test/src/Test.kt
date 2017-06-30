import entity.*
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

/**
 * Created by Tao.ZT.Zhang on 2017/6/14.
 */
fun main(args: Array<String>) {
    var person:Person = Person("xx", 24)
    var student:Student = Student(70)
    student.printInfo()
    var fooString = "ddd"
    val fooTemplateString = "$fooString has ${fooString.length} characters"
    println(fooTemplateString)

    var fooNullable: String? = "abc"
    println(fooNullable?.length) // => 3
    println(fooNullable?.length ?: -1) // => 3
    fooNullable = null
    println(fooNullable?.length) // => null
    println(fooNullable?.length ?: -1) // => -1
//    main()
    println(varArgFun(1))
    println(varArgFun(1, 2))
    println(varArgFun(1, 2, 3, 4, 5, 6))

    println(isOdd(3))
    println(isOdd(4))

    var numberTest:NumberTest = NumberTest(4)
    println(numberTest.add(5))
    println(numberTest.multi(5))

    var dataBean:DataBean = DataBean(3,5)
    println(dataBean.hashCode())
    println(dataBean.toString())
    println(dataBean.equals(DataBean(3,5)))
    with(dataBean){
        x -= 5
        y += 5
    }
    println(dataBean.toString())

    var dataBean1 = dataBean.copy(y=2)
    println("------dataBean1---------")
    println(dataBean1.toString())

    var(a, b) = dataBean;
    println("$a,$b")

    for ((a ,b) in listOf(dataBean)){
        print("$a,$b")
    }

    println()
    /*----List-----*/
//    testListOf()
//    testMutableList()
//    testSet()
//    testMap()
//    testSequence()

//    testLoop()
//println(smartCastExample(4))
//println(smartCastExample("test"))
//println(smartCastExample(false))

    println(smartCastwithWhen(4))
    println(smartCastwithWhen("test"))
    println(smartCastwithWhen(false))
    println(smartCastwithWhen(10.5))

    fun String.remove(char:Char):String{
        return this.filter { it != char }
    }

    println("Hello,World".remove('o'))

    println(EnumClass.A)
    println(EnumClass.B)
    println(EnumClass.C)

    var objectEx1 :ObjectExample = ObjectExample;
    var objectEx2 :ObjectExample = ObjectExample;
    objectEx1.hello()
    println("objectEx1's hashCode" + objectEx1.hashCode())
    println("objectEx2's hashCode" + objectEx2.hashCode())

    var obj = object {
        var x:Int = 0
        var y:Int = 3
    }

    println(obj.x + obj.y)

//    student.add(object : Base {
//        var x = 3
//        var y = 3
//        override fun print() {
//           println(student.score)
//           println(student.name)
//        }
//
//        override fun countPlusPlus() {
//            println(x++)
//        }
//        override fun countMinusMinus() {
//            println(y--)
//        }
//
//    })
    testObjectExpression(student)
}



//interface Base {
//    fun print()
//    fun countPlusPlus()
//    fun countMinusMinus()
//}

class BaseImpl(val x: Int) : Base {
    override fun countMinusMinus() {
    }

    override fun countPlusPlus() {
    }

    override fun print() { print(x) }
}

class Derived(b: Base) : Base by b

fun main() {
    val b = BaseImpl(10)
    Derived(b).print()
}

fun varArgFun(vararg arg:Int):Int{
    return arg.size
}

fun isOdd(arg:Int):Boolean = arg % 2 == 1

fun testListOf(){
    var list = listOf<String>("a", "b", "c", "d", "d", "e", "f", "g","a","b")
    println("list's size== " + list.size)
    println("list's first== " + list.first())
    println("list's last== " + list.last())
    println("list's indexOf== " + list.indexOf("a"))
    println("list's get== " + list.get(0))
    println("list's lastIndexOf== " + list.lastIndexOf("a"))
}


fun testMutableList(){
    var list = mutableListOf<String>("a", "b", "c", "d")
    println("list's size== " + list.size)
    list.add("e")
    println("list's size== " + list.size)
}

fun testSet(){
    //set的长度在定义的时候已经定了，往里面添加重复的元素时自动添加失败！
    var set = setOf<String>("a", "b", "c", "d", "a","b","e")
    println("set's size ==" +set.size)
    println("set's contains ==" +set.contains("a")) //true
    println("set's contains ==" +set.contains("z")) //false
}

fun testMap() {
    //set的长度在定义的时候已经定了，往里面添加重复的元素时自动添加失败！
    var map = mapOf<String, Int>("a" to 1, "b" to 2, "c" to 3, "d" to 4)
    println("map's size ==" + map.size)
    println("map's size ==" + map.get("a"))
    println("map's size ==" + map["a"])

    val toList = map.entries.toList()
    for (entry in toList) {
        println(entry.key +"---"+ entry.value )
    }

}

fun testSequence(){
    var sequnce = generateSequence(1, { it+1 })
    var x = sequnce.take(10).toList()
    print(x)
}

fun testLoop(){

    for (c in "Hello"){
        println(c)
    }

    var x =1;
    while (x <10){
        println(x)
         x ++
    }

    var y = 10
    do {
        println(y)
        y--
    }while (y >= 0)

    when (30) {
        0, 21 -> println("0 or 21")
        in 1..20 -> println("in the range 1 to 20")
        else -> println("none of the above")
    }
}


fun smartCastExample(x: Any) : Boolean {
    if (x is Boolean) {
        // x is automatically cast to Boolean
        return x
    } else if (x is Int) {
        // x is automatically cast to Int
        return x > 0
    } else if (x is String) {
        // x is automatically cast to String
        println(x)
        return x.isNotEmpty()
    } else {
        return false
    }
}

fun smartCastwithWhen(x:Any):Boolean{
    when (x){
        is String -> return  x.isNotEmpty()
        is Int -> return  x>5
        is Boolean -> return x
        else -> return  false
    }
    return  false
}

 enum class EnumClass{
    A, B, C
}

object  ObjectExample {

    fun hello(){
        println("Hello, world")
    }
}

fun testObjectExpression(student:Student){
    var x :Int = 4
    var y :Int = 4
    student.add(object : Base{
        override fun print() {
            println("x + y == "  + (x+y))
        }

        override fun countPlusPlus() {
            println("x++==" + x++)
        }

        override fun countMinusMinus() {
            println("y--==" + y--)
        }

    })
}
