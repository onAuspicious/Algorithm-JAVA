package problems

import kotlin.math.max

class Kakao2024MostGifted {
    fun solution(friends: Array<String>, gifts: Array<String>): Int {
        val giftPointMap = friends.associateWith { 0 }.toMutableMap()
        val giftsMap: Map<String, MutableMap<String, Int>> =
            friends.associateWith { friends.associateWith { 0 }.toMutableMap() }
        var result = 0

        gifts.associate {
            val split = it.split(" ")
            Pair(split[0], mutableMapOf(Pair(split[1], 0)))
        }

        gifts.forEach {
            val split = it.split(" ")
            val giver = split[0]
            val taker = split[1]

            // giftPointMap
            giftPointMap[taker] = giftPointMap[taker]!! - 1
            giftPointMap[giver] = giftPointMap[giver]!! + 1

            // giftsMap
            giftsMap[taker]!![giver] = giftsMap[taker]!![giver]!! + 1
        }

        friends.forEach { taker ->
            var cnt = 0
            friends.forEach { giver ->
                if (giftsMap[taker]!![giver]!! < giftsMap[giver]!![taker]!!) {
                    cnt++
                }
                if (giftsMap[taker]!![giver]!! == giftsMap[giver]!![taker]!! && giftPointMap[taker]!! > giftPointMap[giver]!!) {
                    cnt++
                }
            }
            result = max(result, cnt)
        }

        return result
    }
}

fun main() {
    val solution = Kakao2024MostGifted()
    val friends = arrayOf("muzi", "ryan", "frodo", "neo")
    val gifts = arrayOf("muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi")
    val result = solution.solution(friends, gifts)
    println(result)
}