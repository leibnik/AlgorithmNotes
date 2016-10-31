package algorithms.sort;

import java.util.Arrays;

/**
 * Created by leibnik on 16-10-20.
 */
public class BubbleSort {

    public static void sort(int[] arr){
        int i,j;
        int length = arr.length;
        for (i = 1; i < length; i++){
            for (j = 0; j < length - i; j++){
                if (arr[j] > arr[j + 1]){
                    int tmp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = tmp;
                }
            }
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{3, 5, 2, 7, 9, 10, 4, 1, 6};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
