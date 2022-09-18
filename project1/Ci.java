import java.util.ArrayList;
import java.util.List;

public class Ci {
    // With the value of S fixed, plot the number of key comparisons over different sizes of the input list n. 
    // Compare your empirical results with your theoretical analysis of the time complexity.
    public static void main(String[] args) {
        List<int[]> allArr = new ArrayList<>();
        for (int n = 500000; n <= Utilities.TEN_MIL; n += 500000) 
            allArr.add(Utilities.generateArray(n));  
        // Value of S fixed at 10
        int S = 10;
        for (int[] arr : allArr) {
            int[] curArr = arr.clone();
            Sort.hybrid(curArr, 0, arr.length-1, S);
            Utilities.keyComparisons(arr.length, S);
        }
    }
}
