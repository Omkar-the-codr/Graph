package in.dp;

public class BestTimeToBuyAndSellStock121 {
    public int maxProfit(int[] prices) {
        int[] start = new int[prices.length];
        int[] end = new int[prices.length];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<prices.length;i++){
            min = Math.min(min, prices[i]);
            start[i] = min;
            max = Math.max(max, prices[prices.length-i-1]);
            end[prices.length-i-1] = max;
        }
        int maxProfit = Integer.MIN_VALUE;
        for(int i=0;i<prices.length;i++){
            maxProfit = Math.max(maxProfit, end[i]-start[i]);
        }
        return maxProfit;
    }
}
