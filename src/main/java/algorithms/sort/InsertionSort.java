package algorithms.sort;

import java.util.Arrays;

/**
 * Created by leibnik on 16-10-20.
 */
public class InsertionSort {

    public static void sort(int[] arr){
        int i,j,target;
        int length = arr.length;
        for (i = 1; i < length; i++){
            j = i;
            target = arr[j];
            while (j > 0 && arr[j - 1] > target ){
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = target;
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{3, 5, 2, 7, 9, 2, 4, 1, 6};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
