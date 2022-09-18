import java.util.Arrays;

public class Sort {
    public static void merge(int[] arr, int lo, int hi) {
        if (hi - lo == 0)
            return;
        int mid = lo + (hi - lo)/2;
        merge(arr, lo, mid);
        merge(arr, mid+1, hi);
        mergeHelper(arr, lo, hi);
    }

    public static void hybrid(int[] arr, int lo, int hi, int S) {
        // switch to insertion sort when sublist <= S 
        if (hi - lo < S) {  
            insertion(arr, lo, hi);
            return;
        }
        int mid = lo + (hi - lo)/2;
        hybrid(arr, lo, mid, S);
        hybrid(arr, mid+1, hi, S);
        mergeHelper(arr, lo, hi);
    }

    private static void mergeHelper(int[] arr, int lo, int hi) {
        int mid = lo + (hi - lo)/2;
        // auxiliary arrays to store both sorted lists
        int[] arr1 = Arrays.copyOfRange(arr, lo, mid+1);
        int[] arr2 = Arrays.copyOfRange(arr, mid+1, hi+1);
        int i = 0, j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] > arr2[j])
                arr[lo++] = arr2[j++];
            else
                arr[lo++] = arr1[i++];
            Utilities.comparisons++;
        }
        // right sublist is empty
        while (i < arr1.length) 
            arr[lo++] = arr1[i++];
        // left sublist is empty
        while (j < arr2.length) 
            arr[lo++] = arr2[j++]; 
    }

    private static void insertion(int[] arr, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            for (int j = i; j > lo; j--) {
                Utilities.comparisons++;
                if (arr[j] < arr[j-1])
                    swap(arr, j, j-1);
                else
                    break;
            }
        }
    }

    private static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
