package problems

class BestTimeToBuyAndSellStock2 {
    fun maxProfit(prices: IntArray): Int {
        var now = prices[0]
        var profit = 0

        for (i in 0..prices.size - 2) {
            if (prices[i + 1] < prices[i]) {
                profit += prices[i] - now
                now = prices[i + 1]
            }
        }

        if (now < prices[prices.size - 1]) {
            profit += prices[prices.size - 1] - now
        }

        return profit
    }
}