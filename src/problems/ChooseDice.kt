package problems

import kotlin.math.*

class ChooseDice {
    fun solution(dice: Array<IntArray>): IntArray {
        val result = IntArray(dice.size / 2 + 1)

        this.combination(0, -1, mutableListOf(), dice, dice.size, result)

        val resultArray = IntArray(dice.size / 2)

        for (i in 0..resultArray.size - 1) {
            resultArray[i] = result[i + 1] + 1
        }

        return resultArray
    }

    private fun combination(depth: Int, before: Int, aArr: MutableList<Int>, dice: Array<IntArray>, size: Int, result: IntArray) {
        if (depth == size / 2 && aArr.size == size / 2) {
            // create bArr by aArr and execute calc
            val bArr = mutableListOf<Int>()
            for (i in 0..size - 1) {
                if (!aArr.contains(i)) {
                    bArr.add(i)
                }
            }
            val save = IntArray(2)
            this.calc(0, 0, 0, aArr, bArr, dice, save)

            if (save[0] > result[0]) {
                result[0] = save[0]
                for (i in 1..size / 2) {
                    result[i] = aArr[i - 1]
                }
            }
            return
        }

        // combination size C size / 2
        for (i in before + 1..size - 1) {
            aArr.add(i)
            this.combination(depth + 1, i, aArr, dice, size, result)
            aArr.removeLast()
        }
    }

    private fun calc(depth: Int, aScore: Int, bScore: Int, aArr: List<Int>, bArr: List<Int>, dice: Array<IntArray>, save: IntArray) {
        if (depth == aArr.size) {
            if (aScore > bScore) {
                save[0]++
            } else if (aScore < bScore) {
                save[1]++
            }
            return
        }

        for (i in 0..5) {
            for (j in 0..5) {
                this.calc(depth + 1, aScore + dice[aArr[depth]][i], bScore + dice[bArr[depth]][j], aArr, bArr, dice, save)
            }
        }
    }
}

fun main() {
    val c = ChooseDice()
    c.solution(arrayOf(intArrayOf(1, 2, 3, 4, 5, 6), intArrayOf(3, 3, 3, 3, 4, 4), intArrayOf(1, 3, 3, 4, 4, 4), intArrayOf(1, 1, 4, 4, 5, 5))).forEach { println(it) }
    c.solution(arrayOf(intArrayOf(1, 2, 3, 4, 5, 6), intArrayOf(2, 2, 4, 4, 6, 6))).forEach { println(it) }
}