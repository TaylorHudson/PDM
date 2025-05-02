package atividade1

fun main() {
    // 1°
    println(last(listOf(1, 1, 2, 3, 5, 8)))
    // 2°
    println(penultimate(listOf(1, 1, 2, 3, 5, 8)))
    //3°
    println(isPalindrome(listOf(1, 2, 3, 2, 1)))
    //4°
    println(encode("aaaabccaadeeee".toList()))
    //5°
    println(decode(listOf(
        Pair(4, "a"),
        Pair(1, "b"),
        Pair(2, "c"),
        Pair(2, "a"),
        Pair(1, "d"),
        Pair(4, "e")
    )))
}

fun findByIndex(list: List<Any>, index: Int): Any {
    var i = 1
    for(element in list) {
        if (i == index) {
            return element
        }
        i++
    }
    return -1
}

fun last(list: List<Any>): Any {
    return findByIndex(list, list.size)
}

fun penultimate(list: List<Any>): Any {
    return findByIndex(list, list.size - 1)
}

fun isPalindrome(list: List<Any>): Boolean {
    var reversed = mutableListOf<Any>()
    var size = list.size
    while(size > 0) {
        reversed.add(list[size - 1])
        size--
    }

    for (i in 0..list.size-1) {
        if(list[i] != reversed[i]) {
            return false
        }
    }
    return true
}

fun encode(list: List<Any>): List<Pair<Int, Any>> {
    if (list.isEmpty()) return emptyList()

    val result = mutableListOf<Pair<Int, Any>>()
    var current = list[0]
    var count = 1

    for (i in 1..list.size - 1) {
        if (list[i] == current) {
            count++
        } else {
            result.add(Pair(count, current))
            current = list[i]
            count = 1
        }
    }

    result.add(Pair(count, current))

    return result
}

fun decode(list: List<Pair<Int, Any>>): MutableList<Any> {
    var result = mutableListOf<Any>()
    for ((len, value) in list) {
        for (i in 1..len) {
            result.add(value)
        }
    }
    return result
}