/*
* 121. Best Time to Buy and Sell Stock
* You are given an array prices where prices[i] is the price of a given stock on the ith day.
* You want to maximize your profit by choosing a single day to buy one stock
* and choosing a different day in the future to sell that stock.
* Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
* */
public class BuySellStock {

    public static void main(String args[]) {
        BuySellStock bss = new BuySellStock();
        int[] arr = {7, 1, 5, 3, 6, 4};
        int res = bss.maxProfit(arr);
        System.out.println("Maximum Profit is " + res);
    }

    public int maxProfit(int[] arr) {

        int profit = 0;
        int buyPrice = arr[0];

        for (int i = 1; i < arr.length; i++) {
            buyPrice = Math.min(arr[i], buyPrice);
            profit = Math.max((arr[i] - buyPrice), profit);
        }
        return profit;
    }
}
