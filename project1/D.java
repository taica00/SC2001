public class D {
    public static void main(String[] args) {
        int n = 10000000;
        int S = 29;
        // Generate arrays
        int[][] allArr = new int[5][n];
        for (int i = 0; i < 5; i++) 
            allArr[i] = Utilities.generateArray(n);
        int totalTime = 0;

        // Hybrid sort
        System.out.println("Hybrid Sort:");
        for (int[] arr : allArr) {
            int[] curArr = arr.clone();
            long startTime = System.currentTimeMillis();
            Sort.hybrid(curArr, 0, n-1, S);
            long endTime = System.currentTimeMillis();
            totalTime += endTime - startTime;
        }
        System.out.println((totalTime/5) + " " + (Utilities.comparisons/5));
        totalTime = 0;
        Utilities.comparisons = 0;

        // Merge sort
        System.out.println("Merge Sort:");
        for (int[] arr : allArr) {
            int[] curArr = arr.clone();
            long startTime = System.currentTimeMillis();
            Sort.merge(curArr, 0, n-1);
            long endTime = System.currentTimeMillis();
            totalTime += endTime - startTime;
        }
        System.out.println((totalTime/5) + " " + (Utilities.comparisons/5));
    }
}
