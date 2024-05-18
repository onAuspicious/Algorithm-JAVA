package problems

import java.util.*

class IPO {
    fun findMaximizedCapital(k: Int, w: Int, profits: IntArray, capital: IntArray): Int {
        val projects = Array<Project?>(profits.size) { null }
        var worth = w

        for (i in 0..profits.size - 1) {
            projects[i] = Project(capital[i], profits[i])
        }
        Arrays.sort(projects)
        var n = 0
        val pq = PriorityQueue<Project> {
                o1, o2 -> o2.profit - o1.profit
        }

        for (i in 0..k - 1) {
            while (n < profits.size && projects[n]!!.capital <= worth) {
                pq.add(projects[n])
                n++
            }
            if (pq.isEmpty()) {
                break
            }
            worth += pq.poll().profit
        }

        return worth
    }
}

data class Project(
    val capital: Int,
    val profit: Int,
) : Comparable<Project> {
    override fun compareTo(project: Project): Int {
        return this.capital - project.capital
    }
}