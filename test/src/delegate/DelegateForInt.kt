package delegate

import kotlin.reflect.KProperty

/**
 * Created by Tao.ZT.Zhang on 2017/6/30.
 */


class DelegateForInt{
    operator fun getValue(thisRef:Any?,  pro: KProperty<*>): Int{
        return pro.getter<Int>
    }

}