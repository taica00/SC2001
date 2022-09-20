public class Ciii1e5 {
    public static void main(String[] args) {
        // Generate arrays
        int n = 100000;
        int[][] allArr = new int[5][n];
        for (int i = 0; i < 5; i++) 
            allArr[i] = Utilities.generateArray(n);
        // S values to use
        int[] valuesOfS = new int[]{1, 2, 3, 5, 6, 9, 12, 18, 24, 36, 48, 49, 72};
        
        for (int S : valuesOfS) {
            long totalTime = 0;
            for (int[] arr : allArr) {
                int[] curArr = arr.clone();
                long startTime = System.nanoTime();
                Sort.hybrid(curArr, 0, n-1, S);
                long endTime = System.nanoTime();
                totalTime += endTime - startTime;
            }
            System.out.println(totalTime/1000);
        }
    }
}
