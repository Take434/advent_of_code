import java.io.File
import java.io.InputStream

fun main() {
    val inputStream: InputStream = File("input.txt").inputStream()
    val schematic = Array(140) { CharArray(140) }
    var sum = 0

    var iterator = 0
    inputStream.bufferedReader().forEachLine {
        schematic[iterator] = it.toCharArray()
        iterator++
    }

    for(i in schematic.indices) {
        for(j in schematic[i].indices) {
            if(schematic[i][j] != '*') {
                continue
            }

            val numbers = ArrayList<Int>()
            for(k in -1..1) {
                for(l in -1..1) {
                    try {
                        if(schematic[i + k][j + l].isDigit()) {
                            numbers.add(parseNumber(j + l, j + l, schematic[i + k]).toInt())
                        }
                    } catch(_: Exception) {

                    }
                }
            }

            val distinctNums = numbers.distinct()
            if(distinctNums.size == 2) {
                sum += distinctNums[0] * distinctNums[1]
            }
        }
    }

    println(sum)
}

fun parseNumber(i: Int, a: Int, array: CharArray): String {
    if(array.indices.contains(i) && array[i].isDigit()) {
        if(i < a) {
            return "${parseNumber(i - 1, i, array)}${array[i]}"
        }

        if(i > a) {
            return "${array[i]}${parseNumber(i + 1, i, array)}"
        }

        return "${parseNumber(i - 1, i, array)}${array[i]}${parseNumber(i + 1, i, array)}"
    }

    return ""
}