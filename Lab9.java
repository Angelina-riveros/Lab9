import java.util.Random;

public class Lab9 {

    // Returns the `k`th smallest item in `a`. 
    // Ex: `kthSmallest({4, 5, 6, 7}, 2) == 5`
    public static int kthSmallest(int[] a, int k) {
        //TODO: Implement this method
        return quickSelect(a, 0, a.length - 1, k - 1);
    }
    public static int quickSelect(int[] a, int leftSide, int rightSide, int k){
        Random rand = new Random();
        while(leftSide <= rightSide){
        int pivot = partition(a, leftSide, rightSide);
            if(k == pivot){
                return a[k];
            }else if(k < pivot){ 
                return rightSide = pivot - 1;
            }else{ 
                return leftSide = pivot + 1;
            }
        }
        return -1;
    }

    public static int partition(int[] a, int leftSide, int rightSide){
        Random ran = new Random();
        int pivotPlace = medianOfThree(a, leftSide, rightSide);
        swap(a, pivotPlace, rightSide);
        int pivotValue = a[rightSide];
        int i = leftSide;
        for(int j = leftSide; j <= rightSide; j++){
            if(a[j] <= pivotValue){
                swap(a, i, j);
                i++;
            }
        }
        swap(a, i, rightSide);
        return i;
    }

    public static void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static int medianOfThree(int[] a, int leftSide, int rightSide){
        int mid = leftSide+(rightSide - leftSide ) / 2;
        if(a[leftSide] > a[mid]){
            swap(a, leftSide, mid);
        }
        if(a[leftSide] > a[rightSide]){
            swap(a, leftSide, rightSide);
        }
        if(a[mid] > a[rightSide]){
            swap(a, mid, rightSide);
        }
        return a[mid];
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
