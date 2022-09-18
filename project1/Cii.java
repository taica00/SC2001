public class Cii {
    // With the input size n fixed, plot the number of key comparisons over different values of S. 
    // Compare your empirical results with your theoretical analysis of the time complexity.
    public static void main(String[] args) {
        int n = 100000;
        int[] arr = Utilities.generateArray(n);
        for (int S = 3; S < 50; S+=2) {
            Sort.hybrid(arr.clone(), 0, n-1, S);
            Utilities.keyComparisons(n, S);
        }
        
    }
}
