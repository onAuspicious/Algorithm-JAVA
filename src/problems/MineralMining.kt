package problems

import java.util.PriorityQueue
import kotlin.math.min

class MineralMining {
    fun solution(picks: IntArray, minerals: Array<String>): Int {
        val pq = this.createPriorityQueue(minerals, (picks[0] + picks[1] + picks[2]) * 5)
        var result = 0

        while (picks[0] + picks[1] + picks[2] > 0 && pq.isNotEmpty()) {
            val mines = pq.poll()
            if (picks[0] > 0) {
                result += mines.calculateFatigue(0)
                picks[0]--
            } else {
                if (picks[1] > 0) {
                    result += mines.calculateFatigue(1)
                    picks[1]--
                } else {
                    result += mines.calculateFatigue(2)
                    picks[2]--
                }
            }
        }

        return result
    }

    private fun createPriorityQueue(minerals: Array<String>, limit: Int): PriorityQueue<Mines> {
        val pq = PriorityQueue<Mines>()
        for (i in 0..min(limit - 1, minerals.size - 1) step 5) {
            val mines = Mines(0, 0, 0)
            for (j in i..min(i + 4, minerals.size - 1)) {
                if (minerals[j] == "diamond") {
                    mines.dia++
                } else if (minerals[j] == "iron") {
                    mines.iron++
                } else {
                    mines.stone++
                }
            }
            pq.add(mines)
        }
        return pq
    }

    data class Mines(
        var dia: Int,
        var iron: Int,
        var stone: Int,
    ) : Comparable<Mines> {
        fun calculateFatigue(pick: Int): Int {
            return if (pick == 0) {
                dia + iron + stone
            } else if (pick == 1) {
                dia * 5 + iron + stone
            } else {
                dia * 25 + iron * 5 + stone
            }
        }

        override fun compareTo(other: Mines): Int {
            return if (other.dia == this.dia) {
                if (other.iron == this.iron) {
                    if (other.stone == this.stone) {
                        return 0
                    } else {
                        other.stone - this.stone
                    }
                } else {
                    other.iron - this.iron
                }
            } else {
                other.dia - this.dia
            }
        }
    }
}

fun main() {
    val mineralMining = MineralMining()
    println(
        mineralMining.solution(
            intArrayOf(1, 3, 2),
            arrayOf("diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone")
        )
    )
    println(
        mineralMining.solution(
            intArrayOf(0, 1, 1),
            arrayOf(
                "diamond",
                "diamond",
                "diamond",
                "diamond",
                "diamond",
                "iron",
                "iron",
                "iron",
                "iron",
                "iron",
                "diamond"
            )
        )
    )

}