public class Ciii1e6 {
    public static void main(String[] args) {
        // Generate arrays
        int n = 1000000;
        int[][] allArr = new int[5][n];
        for (int i = 0; i < 5; i++) 
            allArr[i] = Utilities.generateArray(n);
        // S values to use
        int[] valuesOfS = new int[]{1, 2, 3, 5, 7, 12, 15, 23, 30, 46, 61, 92};
        
        for (int S : valuesOfS) {
            long totalTime = 0;
            for (int[] arr : allArr) {
                int[] curArr = arr.clone();
                long startTime = System.currentTimeMillis();
                Sort.hybrid(curArr, 0, n-1, S);
                long endTime = System.currentTimeMillis();
                totalTime += endTime - startTime;
            }
            System.out.println(totalTime);
        }
    }
}
