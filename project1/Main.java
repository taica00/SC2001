import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    static int S;
    public static int comparisons = 0;
    static int[] cur_arr;
    static final int TEN_MIL = 10000000;
    
    public static void main(String[] args) { 
        // Generate input data
        List<int[]> all_arr = new ArrayList<>();
        int n = 1000;
        while (n <= TEN_MIL) {
            all_arr.add(generateArray(n));
            n *= 10;
        }

        // Analyze time complexity
        // Value of S fixed at 10
        S = 10;
        for (int[] arr : all_arr) {
            cur_arr = arr.clone();
            Sort.hybrid(cur_arr, 0, arr.length-1, 10);
            keyComparisons();
        }
        System.out.println();
        
        // Input size n fixed at 100000
        for (int i = 3; i <= 30; i+=3) {
            S = i;
            cur_arr = all_arr.get(2).clone();
            Sort.hybrid(cur_arr, 0, 99999, S);
            keyComparisons();
        }
        System.out.println();

        // Compare with original Mergesort
        System.out.println("Hybrid algorithm:");
        S = 20;
        cur_arr = all_arr.get(4).clone();
        long startTime = System.currentTimeMillis();
        Sort.hybrid(cur_arr, 0, TEN_MIL-1, S);
        long endTime = System.currentTimeMillis();
        keyComparisons();
        System.out.println("Time taken: " + (endTime - startTime) + " ms\n");

        System.out.println("Mergesort algorithm:");
        cur_arr = all_arr.get(4).clone();
        startTime = System.currentTimeMillis();
        Sort.merge(cur_arr, 0, TEN_MIL-1);
        endTime = System.currentTimeMillis();
        keyComparisons();
        System.out.println("Time taken: " + (endTime - startTime) + " ms\n");
    }

    static int[] generateArray(int size) { 
        int[] arr = new int[size];
        Random rd = new Random();
        for (int i = 0; i < size; i++)  
            arr[i] = rd.nextInt(size-1); 
        return arr;
    }

    static void keyComparisons() {
        System.out.println("Key comparisons for array of size " + cur_arr.length + " and S = " + S + ": " + comparisons);
        comparisons = 0;
    }
}
