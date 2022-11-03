package project3;

public class Project3 {
    public static void main(String[] args) {
        int[] w1 = new int[]{4, 6, 8};
        int[] w2 = new int[]{5, 6, 8};
        int[] p = new int[]{7, 6, 9};
        System.out.println(knapsack(w1, p, 14));
        System.out.println(knapsack(w2, p, 14));
    }
    
    private static int knapsack(int[] w, int[] p, int C) {
        int n = w.length;
        int[] profit = new int[C+1];
        for (int c = 1; c <= C; c++) {
            for (int i = 0; i < n; i++) {
                if (w[i] <= c)
                    profit[c] = Math.max(profit[c], profit[c-w[i]] + p[i]);
            }
        }
        return profit[C];
    }
}
