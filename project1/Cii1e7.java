public class Cii1e7 {
    public static void main(String[] args) {
        // Generate arrays
        int n = 10000000;
        int[][] allArr = new int[5][n];
        for (int i = 0; i < 5; i++) 
            allArr[i] = Utilities.generateArray(n);
        // S values to use
        int[] valuesOfS = new int[]{1, 2, 3, 4, 7, 9, 14, 19, 29, 38, 57, 76, 114, 152};
        
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
