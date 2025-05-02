package atividade1

import kotlin.math.sqrt

fun main() {
    //6°
    println(7.isPrime())
    //7°
    println(gcd(36, 63))
    //8°
    println(listPrimesInRange(7..31))
}

fun Int.isPrime(): Boolean {
    if (this <= 1) {
        return false
    }
    for (i in 2..sqrt(this.toDouble()).toInt()) {
        if (this % i == 0) {
            return false
        }
    }
    return true
}

fun gcd(a: Int, b: Int): Int {
    var num1 = a
    var num2 = b

    while (num1 != num2) {
        if (num1 > num2) {
            num1 -= num2
        } else {
            num2 -= num1
        }
    }
    return num1
}

fun listPrimesInRange(range: IntRange): List<Int> {
    val primes = mutableListOf<Int>()
    for (number in range) {
        if (number.isPrime()) {
            primes.add(number)
        }
    }
    return primes
}
