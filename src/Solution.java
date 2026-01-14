import java.util.*;

class Solution {

    static class Pizza {
        public String name;
        public int price_S;
        public int price_M;
        public int price_L;

        public Pizza(String name, int price_S, int price_M, int price_L) {
            this.name = name;
            this.price_S = price_S;
            this.price_M = price_M;
            this.price_L = price_L;
        }

        public String getName() {
            return name;
        }

        public int getPrice_S() {
            return price_S;
        }

        public int getPrice_M() {
            return price_M;
        }

        public int getPrice_L() {
            return price_L;
        }
    }
    static class OrderItem {
        public String name;
        public String size;
        public int quantity;

        public OrderItem(String name, String size, int quantity) {
            this.name = name;
            this.size = size;
            this.quantity = quantity;
        }

        public String getName() {
            return name;
        }

        public String getSize() {
            return size;
        }

        public int getQuantity() {
            return quantity;
        }
    }

    public static void main(String[] args){

        List<Pizza> menu = Arrays.asList(
                new Pizza("boston", 7, 5, 10),
                new Pizza("hawaii", 8, 9, 12),
                new Pizza("newyorker", 8, 9, 13),
                new Pizza("philadelphia", 5, 10, 13)
        );

        List<OrderItem> order = Arrays.asList(
                new OrderItem("boston", "Small", 3),
                new OrderItem("hawaii", "Large", 3),
                new OrderItem("newyorker", "Large", 1),
                new OrderItem("boston", "Large", 2),
                new OrderItem("philadelphia", "Large", 2)
        );

        int total = solution(menu.toArray(new Pizza[0]), order.toArray(new OrderItem[0]));
        System.out.println("Final total after all discounts: " + total);

    }
    public static int solution(Pizza[] menu, OrderItem[] order) {
        // Implement your solution here
        Map<String, Pizza> pizzaMap = buildPizzaMap(List.of(menu));
        Map<String, Map<String, Integer>> quantityMap = buildQuantityMap(List.of(order));

        List<Integer> allPrices = new ArrayList<>();
        int total = 0;

        // Step 1: Apply size-based promotions
        total += applySizePromotions(quantityMap, pizzaMap, allPrices);

        // Step 2: Apply "Large ⇒ Small Free"
        total -= applyFreeSmallPromotion(quantityMap, pizzaMap, allPrices);

        // Step 3: Apply "Buy 3 get 1 free"
        total -= applyBuy3Get1Free(allPrices);

        return total;
    }

    private static Map<String, Pizza> buildPizzaMap(List<Pizza> menu) {
        Map<String, Pizza> map = new HashMap<>();
        for (Pizza p : menu) {
            map.put(p.name.toLowerCase(), p);
        }
        return map;
    }

    private static Map<String, Map<String, Integer>> buildQuantityMap(List<OrderItem> order) {
        Map<String, Map<String, Integer>> map = new HashMap<>();
        for (OrderItem item : order) {
            map.computeIfAbsent(item.name.toLowerCase(), k -> new HashMap<>())
                    .merge(item.size.toLowerCase(), item.quantity, Integer::sum);
        }
        return map;
    }

    private static int getUnitPrice(Pizza p, String size) {
        return switch (size) {
            case "small" -> p.price_S;
            case "medium" -> p.price_M;
            case "large" -> p.price_L;
            default -> 0;
        };
    }

    private static void addPrices(List<Integer> list, int price, int count) {
        for (int i = 0; i < count; i++) list.add(price);
    }

    private static void removePrices(List<Integer> list, int price, int count) {
        for (int i = 0; i < count; i++) list.remove(Integer.valueOf(price));
    }

    private static int applySizePromotions(Map<String, Map<String, Integer>> quantityMap,
                                           Map<String, Pizza> pizzaMap,
                                           List<Integer> allPrices) {
        int total = 0;

        for (var entry : quantityMap.entrySet()) {
            String pizzaName = entry.getKey();
            Pizza pizza = pizzaMap.get(pizzaName);

            for (var sizeEntry : entry.getValue().entrySet()) {
                String size = sizeEntry.getKey();
                int qty = sizeEntry.getValue();

                int unitPrice = getUnitPrice(pizza, size);

                // --- Promotion 1: Buy 3 Large Pay for 3 Medium
                if (size.equals("large") && qty >= 3) {
                    int discountCount = Math.min(3, qty);
                    int mediumPrice = pizza.price_M;

                    total += mediumPrice * discountCount;
                    addPrices(allPrices, mediumPrice, discountCount);

                    qty -= discountCount;
                    System.out.println("Applied 'Buy 3 Large Pay for 3 Medium' on " + pizzaName + " for " + discountCount + " pizzas");
                }

                // --- Promotion 2: Buy 5 for 100
                int groups = qty / 5;
                int remainder = qty % 5;

                for (int g = 0; g < groups; g++) {
                    total += 100;
                    addPrices(allPrices, 20, 5);
                }

                addPrices(allPrices, unitPrice, remainder);
                total += unitPrice * remainder;
            }
        }

        return total;
    }

    /** Apply "Large ⇒ Small free" promotion */
    private static int applyFreeSmallPromotion(Map<String, Map<String, Integer>> quantityMap,
                                               Map<String, Pizza> pizzaMap,
                                               List<Integer> allPrices) {
        int discount = 0;

        for (var entry : quantityMap.entrySet()) {
            String pizzaName = entry.getKey();
            Pizza pizza = pizzaMap.get(pizzaName);

            int largeQty = entry.getValue().getOrDefault("large", 0);
            int smallQty = entry.getValue().getOrDefault("small", 0);
            int freeCount = Math.min(largeQty, smallQty);

            if (freeCount > 0) {
                int smallPrice = pizza.price_S;
                discount += freeCount * smallPrice;

                removePrices(allPrices, smallPrice, freeCount);
                System.out.println("Free " + freeCount + " Small " + pizzaName + " pizzas (worth " + discount + ")");
            }
        }

        return discount;
    }

    /** Apply "Buy 3 get 1 free" promotion */
    private static int applyBuy3Get1Free(List<Integer> allPrices) {
        if (allPrices.size() < 4) return 0;

        Collections.sort(allPrices);
        int cheapest = allPrices.get(0);
        System.out.println("Discount applied! Cheapest item (" + cheapest + ") is free.");
        return cheapest;
    }

}
