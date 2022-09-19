import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Utilities {
    public static int comparisons = 0;
    static final int TEN_MIL = 10000000;

    public static int[] generateArray(int size) { 
        int[] arr = new int[size];
        Random rd = new Random();
        for (int i = 0; i < size; i++)  
            arr[i] = rd.nextInt(size); 
        return arr;
    }

    public static void keyComparisons(int n, int S) {
        System.out.println("Key comparisons for array of size " + n + " and S = " + S + ": " + comparisons);
        comparisons = 0;
    }
}
