package atividade1

interface Tree<out T>
data class Node<out T>(
    val value: T,
    val left: Tree<T> = End,
    val right: Tree<T> = End
) : Tree<T> {
    override fun toString(): String {
        val children = if (left == End && right == End) "" else " $left $right"
        return "T($value$children)"
    }
}
val End = object : Tree<Nothing>{
    override fun toString() = "."
}

fun main() {
    //9°
    println(Node(10, Node(8), End).add(9))
    //10°
    println(Node(10, Node(8), End).leafCount())
    //11°
    println(
        Node("a",
            Node("b"),
           Node("c",
               Node("d"), Node("e")
           )
        ).leafValues())
    //12°
    println(Node(
        "a",
        Node("b",
            Node("d"), Node("e")
        ),
       Node("c",
           End, Node("f", Node("g"), End)
       )
    ).convertToString())
    //13°
}

fun <T : Comparable<T>> Tree<T>.add(newValue: T): Tree<T> {
    return when(this) {
        End -> Node(newValue)
        is Node -> {
            if (newValue < this.value) {
                Node(
                    value = this.value,
                    left = left.add(newValue),
                    right = right
                )
            } else if (newValue > this.value) {
                Node(
                    value = value,
                    left = left,
                    right = right.add(newValue)
                )
            } else {
               this
            }
        }
        else -> this
    }
}

fun <T> Tree<T>.leafCount(): Int {
    return when (this) {
        is Node -> {
            if (this.left === End && this.right === End) {
                1
            } else {
                this.left.leafCount() + this.right.leafCount()
            }
        }
        else -> 0
    }
}

fun <T> Tree<T>.leafValues(): List<T> {
    return when (this) {
        is Node -> {
            if (left === End && right === End) {
                listOf(value)
            } else {
                left.leafValues() + right.leafValues()
            }
        }
        else -> emptyList()
    }
}

fun <T> Tree<T>.convertToString(): String {
    return when (this) {
        is Node -> {
            if (left === End && right === End) {
                "$value"
            } else {
                "$value(${left.convertToString()},${right.convertToString()})"
            }
        }
        else -> ""
    }
}