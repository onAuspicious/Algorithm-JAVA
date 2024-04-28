package problems

class BestTimeToBuyAndSellStock {
    fun maxProfit(prices: IntArray): Int {
        var now = prices[0]
        var profit = 0

        for (i in 1..prices.size - 1) {
            if (now > prices[i]) {
                now = prices[i]
            } else if (profit < prices[i] - now) {
                profit = prices[i] - now
            }
        }

        return profit
    }
}