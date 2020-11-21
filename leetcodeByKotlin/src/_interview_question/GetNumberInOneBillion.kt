package _interview_question

import java.util.*
import kotlin.collections.ArrayList

/**
 * 有1千万个随机数，随机数的范围在1到1亿之间。现在要求写出一种算法，将1到1亿之间没有在随机数中的数求出来？
 * */
class Solution9 {
    fun getNumberInOneBillion(){
//        val TenMillion = 10000000
//        val OneBillion = 100000000
        //for test
        val TenMillion = 10
        val OneBillion = 20
        val random = Random()
        val list = ArrayList<Int>()
        for (i in 1 .. TenMillion){//<-here is ten million
            list.add(random.nextInt(OneBillion))//<-here is one billion
        }
        val bitSet = BitSet(OneBillion)
        for (i in 1 .. TenMillion){
            //sets the bit at the specified index to true
            bitSet.set(list.get(i-1))
        }
        //println("range 0-one billion, the count of not including in random is:${bitSet.cardinality()})")
        //没有在随机数中的数字
        for (i in 1 .. OneBillion){
            if (!bitSet.get(i)){
                println(i)
            }
        }
        println("===")
        //有在随机数中的数字
        for (i in 1 .. OneBillion){
            if (bitSet.get(i)){
                println(i)
            }
        }
    }
}