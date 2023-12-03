import java.io.File
import java.io.InputStream

fun main() {
    val inputStream: InputStream = File("input.txt").inputStream()
    val schematic = Array(140) { CharArray(140) }
    var sum = 0

    var iterator = 0;
    inputStream.bufferedReader().forEachLine {
        schematic[iterator] = it.toCharArray();
        iterator++
    }

    for(i in schematic.indices) {

        var j = 0
        while(j < 140) {

            var number = 0
            var isPartNumber = false
            while(schematic[i][j].isDigit()) {
                number = "${number.toString()}${schematic[i][j].toString()}".toInt()

                if(!isPartNumber && partAround(schematic, i, j)) {
                    isPartNumber = true
                }

                if(j != 139) {
                    j++
                } else {
                    break
                }
            }

            if(isPartNumber) {
                sum += number
            }

            j++
        }
    }

    println(sum);
}

fun partAround(schematic: Array<CharArray>, i: Int, j: Int): Boolean {
    if(j == 0) {
        return isPart(schematic[i][j + 1]) || isPart(schematic[i - 1][j]) ||
                isPart(schematic[i - 1][j + 1]) || isPart(schematic[i + 1][j]) ||
                isPart(schematic[i + 1] [j + 1])
    }

    if(j == 139) {
        return isPart(schematic[i][j - 1]) || isPart(schematic[i - 1][j]) ||
                isPart(schematic[i - 1][j - 1]) || isPart(schematic[i + 1][j]) ||
                isPart(schematic[i + 1][j - 1])
    }

    if(i == 0) {
        return isPart(schematic[i][j - 1]) || isPart(schematic[i][j + 1]) || isPart(schematic[i + 1][j]) ||
                isPart(schematic[i + 1][j - 1]) || isPart(schematic[i + 1] [j + 1])
    }

    if(i == 139) {
        return isPart(schematic[i][j - 1]) || isPart(schematic[i][j + 1]) || isPart(schematic[i - 1][j]) ||
                isPart(schematic[i - 1][j - 1]) || isPart(schematic[i - 1][j + 1])
    }

   return isPart(schematic[i][j - 1]) || isPart(schematic[i][j + 1]) || isPart(schematic[i - 1][j]) ||
           isPart(schematic[i - 1][j - 1]) || isPart(schematic[i - 1][j + 1]) || isPart(schematic[i + 1][j]) ||
           isPart(schematic[i + 1][j - 1]) || isPart(schematic[i + 1] [j + 1])
}

fun isPart(c: Char): Boolean {
    return !c.isDigit() && c.code != 46;
}

main()