package recursion1;

public class IsSortedArray2 {
    public static boolean isSortedBetter(int a[], int si) {
        if (si == a.length - 1) {
            return true;
        }
        if (a[si] > a[si + 1]) {
            return false;
        }
        boolean isSmallArraySorted = isSortedBetter(a, si + 1);
        return isSmallArraySorted;
    }

    public static void main(String[] args) {
        int arr1[] = {1, 2, 3, 4, 5};
        int arr2[] = {1, 2, 4, 3, 5};
        int arr3[] = {};
        System.out.println(isSortedBetter(arr1, 0));
        System.out.println(isSortedBetter(arr2, 0));
        //System.out.println(isSortedBetter(arr3,0));

    }

}
