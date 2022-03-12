package problems;

import java.util.*;

public class ProductSuggestion {

    // todo
    //  1. purchase 기반으로 점수를 파악
    //  2. 아직 구매하지 않은 상품들을 추출해서 구현

    static class Product {
        String name;
        Set<String> features;

        public Product(String name, Set<String> features) {
            this.name = name;
            this.features = features;
        }
    }

    static class Feature implements Comparable<Feature>{
        String name;
        int cnt;

        public Feature(String name, int cnt) {
            this.name = name;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Feature feature) {
            if (this.cnt == feature.cnt) {
                return this.name.compareTo(feature.name);
            }
            return this.cnt - feature.cnt;
        }
    }

    public String solution(String[] products, String[] purchased) {
        // 1.
        HashMap<String, Product> productMap = new HashMap<>();
        HashSet<String> notPurchased = new HashSet<>();
        for (String product : products) {
            String[] productSplit = product.split(" ");
            productMap.put(productSplit[0], getProduct(productSplit));
            notPurchased.add(productSplit[0]);
        }

        HashMap<String, Integer> featureMap = new HashMap<>();

        for (String p : purchased) {
            for (String feature : productMap.get(p).features) {
                featureMap.put(feature, featureMap.getOrDefault(feature, 0) + 1);
            }
            notPurchased.remove(p);
        }

        Feature[] features = new Feature[featureMap.size()];
        int index = 0;
        for (String key : featureMap.keySet()) {
            features[index++] = new Feature(key, featureMap.get(key));
        }
        Arrays.sort(features);

        PriorityQueue<Product> productPriorityQueue = new PriorityQueue<>((o1, o2) -> {
            for (Feature feature : features) {
                if (o1.features.contains(feature.name) && !o2.features.contains(feature.name)) {
                    return -1;
                } else if (!o1.features.contains(feature.name) && o2.features.contains(feature.name)) {
                    return 1;
                }
            }
            return o1.features.size() - o2.features.size();
        });

        for (String product : notPurchased) {
            productPriorityQueue.offer(productMap.get(product));
        }

        return productPriorityQueue.peek().name;
    }

    public Product getProduct(String[] productSplit) {
        Set<String> features = new HashSet<>(Arrays.asList(productSplit).subList(1, productSplit.length));
        return new Product(productSplit[0], features);
    }

    public static void main(String[] args) {
        ProductSuggestion productSuggestion = new ProductSuggestion();
        String[] products = new String[]{"sofa red long", "blanket blue long", "towel red", "mattress long", "curtain blue long cheap"};
        String[] purchased = new String[]{"towel", "mattress", "curtain"};
        String[] products2 = new String[]{"towel red long thin", "blanket red thick short", "curtain red long wide", "mattress thick", "hat red thin", "pillow red long", "muffler blue thick long"};
        String[] purchased2 = new String[]{"blanket", "curtain", "hat", "muffler"};
        String solution = productSuggestion.solution(products2, purchased2);
        System.out.println(solution);
    }
}
