public class Ciii1e4 {
    public static void main(String[] args) {
        // Generate arrays
        int n = 10000;
        int[][] allArr = new int[5][n];
        for (int i = 0; i < 5; i++) 
            allArr[i] = Utilities.generateArray(n);
        // S values to use
        int[] valuesOfS = new int[]{1, 2, 3, 4, 7, 9, 14, 19, 29, 39, 59};
        
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
