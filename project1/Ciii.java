import java.util.ArrayList;
import java.util.List;

public class Ciii {
    // Using different sizes of input datasets, study how to determine an optimal value of S for the best performance of this hybrid algorithm.
    public static void main(String[] args) {
        List<int[]> allArr = new ArrayList<>();
        for (int n = 1000; n <= Utilities.TEN_MIL; n *= 10) 
            allArr.add(Utilities.generateArray(n)); 
        for (int[] arr : allArr) {
            for (int S = 4; S <= 40; S+=2) {
                long startTime = System.nanoTime();
                Sort.hybrid(arr.clone(), 0, arr.length-1, S);
                long endTime = System.nanoTime();
                Utilities.keyComparisons(arr.length, S);
                System.out.println("Time taken: " + ((endTime-startTime)/1000) + " microseconds");
            }
            System.out.println();
        }
    }
}
