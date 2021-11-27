package problems;

import java.util.ArrayDeque;
import java.util.Stack;

public class PostAndPrePrice {

    static class Product {
        int price;
        int quantity;

        public Product(int price, int quantity) {
            this.price = price;
            this.quantity = quantity;
        }
    }

    public int[] solution(String[] record) {
        int postPrice = getPostPrice(record);
        int prePrice = getPrePrice(record);

        return new int[]{prePrice, postPrice};
    }

    private int getPrePrice(String[] record) {
        ArrayDeque<Product> deque = new ArrayDeque<>();
        int prePrice = 0;
        for (String rec : record) {
            String[] r = rec.split(" ");
            if (r[0].equals("P")) {
                deque.offerLast(new Product(Integer.parseInt(r[1]), Integer.parseInt(r[2])));
            } else {
                int sell = Integer.parseInt(r[2]);
                while (sell != 0) {
                    Product now = deque.removeFirst();
                    if (now.quantity < sell) {
                        sell -= now.quantity;
                        prePrice += now.price * now.quantity;
                    } else if (now.quantity > sell) {
                        now.quantity -= sell;
                        prePrice += sell * now.price;
                        deque.offerFirst(now);
                        break;
                    } else {
                        prePrice += sell * now.price;
                        break;
                    }
                }
            }
        }
        return prePrice;
    }

    private int getPostPrice(String[] record) {
        Stack<Product> stack = new Stack<>();
        int postPrice = 0;
        for (String rec : record) {
            String[] r = rec.split(" ");
            if (r[0].equals("P")) {
                stack.push(new Product(Integer.parseInt(r[1]), Integer.parseInt(r[2])));
            } else {
                int sell = Integer.parseInt(r[2]);
                while (sell != 0) {
                    Product pop = stack.pop();
                    if (pop.quantity < sell) {
                        sell -= pop.quantity;
                        postPrice += pop.quantity * pop.price;
                    } else if (pop.quantity > sell) {
                        pop.quantity -= sell;
                        postPrice += sell * pop.price;
                        stack.push(pop);
                        break;
                    } else {
                        postPrice += sell * pop.price;
                        break;
                    }
                }
            }
        }
        return postPrice;
    }
}
