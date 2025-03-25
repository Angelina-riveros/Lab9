import java.util.Random;

public class Lab9 {

    // Returns the `k`th smallest item in `a`. 
    // Ex: `kthSmallest({4, 5, 6, 7}, 2) == 5`
    public static int kthSmallest(int[] a, int k) {
        //TODO: Implement this method
        return quickSelect(a, 0, a.length - 1, k - 1);
    }
    public static int quickSelect(int[] a, int leftSide, int rightSide, int k){
        if(leftSide == rightSide){
            return a[leftSide];
        }
        int pivot = partition(a, leftSide, rightSide);
        if(k == pivot){
            return a[k];
        }
        else if(k < pivot){ 
            return quickSelect(a, leftSide, pivot - 1, k);
        }else{ 
            return quickSelect(a, pivot + 1, rightSide, k);
        }
    }

    public static int partition(int[] a, int leftSide, int rightSide){
        Random rand = new Random();
        int randPivot = rand.nextInt(rightSide - leftSide +1) + leftSide;
        swap(a, randPivot, rightSide);
        int pivotValue = a[rightSide];
        int i = leftSide - 1;
        for(int j = leftSide; j <= rightSide; j++){
            if(a[j] <= pivotValue){
                i++;
                swap(a, i, j);
            }
        }
        swap(a, i + 1, rightSide);
        return i + 1;
    }

    public static void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static int[] makeArray(int n) {
        Random rng = new Random();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = rng.nextInt(10000);
        }
        return a;
    }

    public static void main(String[] args) {
        int k = 100;
        long start = System.currentTimeMillis();
        int n = 10000;
        System.out.println(kthSmallest(makeArray(n), k));
        System.out.println("kthSmallest on an array of size " + n + " took " + (System.currentTimeMillis() - start) + "ms");
        n *= 10;
        start = System.currentTimeMillis();
        System.out.println(kthSmallest(makeArray(n), k));
        System.out.println("kthSmallest on an array of size " + n + " took " + (System.currentTimeMillis() - start) + "ms");
        n *= 10;
        start = System.currentTimeMillis();
        System.out.println(kthSmallest(makeArray(n), k));
        System.out.println("kthSmallest on an array of size " + n + " took " + (System.currentTimeMillis() - start) + "ms");
    }
}
