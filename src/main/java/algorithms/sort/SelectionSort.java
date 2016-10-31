package algorithms.sort;

import java.util.Arrays;

/**
 * Created by leibnik on 16-10-20.
 */
public class SelectionSort {

    public static void sort(int[] arr){
        int i,j,min;
        for(i = 0; i < arr.length; i++){
            min = i;
            for (j = i + 1; j < arr.length; j++){
                if (arr[j] < arr[min])
                    min = j;
            }
            int tmp = arr[i];
            arr[i] = arr[min];
            arr[min] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] a = {3, 5, 2, 7, 9, 2, 4, 1, 6};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
