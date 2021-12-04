package problems;

import java.util.HashMap;
import java.util.PriorityQueue;

public class LastOrderEndTime {
    static class Order implements Comparable<Order>{
        String menu;
        int orderTime;
        int endTime;

        public Order(String menu, int endTime, int orderTime) {
            this.menu = menu;
            this.endTime = endTime;
            this.orderTime = orderTime;
        }

        @Override
        public int compareTo(Order o) {
            return this.endTime - o.endTime;
        }
    }

    public int solution(int n, String[] recipes, String[] orders) {
        // last order
        String[] lastOrder = orders[orders.length-1].split(" ");
        String lastMenu = lastOrder[0];
        int lastTime = Integer.parseInt(lastOrder[1]);

        // recipes to hash
        HashMap<String, Integer> recipeMap = new HashMap<>();
        for (String recipe : recipes) {
            String[] split = recipe.split(" ");
            recipeMap.put(split[0], Integer.parseInt(split[1]));
        }

        PriorityQueue<Order> cook = new PriorityQueue<>();
        int time = 0;

        for (String order : orders) {
            String[] split = order.split(" ");
            String menu = split[0];
            int orderTime = Integer.parseInt(split[1]);

            // 현재 들어온 메뉴보다 기존의 메뉴가 더 빨리 끝나는 경우
            while (!cook.isEmpty() && orderTime >= cook.peek().endTime) {
                cook.poll();
                n++;
            }

            // 현재 메뉴가 들어갈 화구가 없는 경우
            if (n == 0) {
                Order end = cook.poll();
                time = end.endTime;
                n++;
            }
            time = Math.max(time, orderTime);

            // 화구에 주문 시작
            cook.offer(new Order(menu, recipeMap.get(menu) + time, orderTime));
            n--;
        }

        int result = 0;

        while (!cook.isEmpty()) {
            Order order = cook.poll();
            if (order.menu.equals(lastMenu) && order.orderTime == lastTime) {
                result = order.endTime;
                break;
            }
        }
        return result;
    }
}
