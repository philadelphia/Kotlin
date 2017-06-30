package delegate

import kotlin.reflect.KProperty

/**
 * Created by Tao.ZT.Zhang on 2017/6/30.
 */
class Delegate {
  operator  fun getValue(thisRef:Any?,  pro: KProperty<*>):String{
      return "$thisRef, thank you for delegating '${pro.name}' to me! "
  }


    operator  fun setValue(thisRef:Any?,  pro: KProperty<*>,  value: String){
        println("$value has been assigned to '${pro.name} in $thisRef.'")
    }
}

class DelegateForInt{
    operator fun getValue(thisRef:Any?,  pro: KProperty<*>): Int{
        return pro.getter<Int>
    }

}