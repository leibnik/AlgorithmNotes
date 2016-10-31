package algorithms.sort;

import java.util.Arrays;

/**
 * Created by leibnik on 16-10-21.
 */
public class MergeSort {

    public static void mergeSort(int[] a,int left, int right){
        int p = left;
        int r = right;
        if (p >= r) return;
        int q = (p + r) / 2;
        mergeSort(a, p,q);
        mergeSort(a, q+ 1, r);
        merge(a, p, q, r);
    }

    public static void merge(int[] b, int p, int q, int r){
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] leftArray = new int[n1 + 1];
        int[] rightArray = new int[n2 + 1];
        for (int i = 0; i < n1; i++){
            leftArray[i] = b[p + i];
        }
        for (int j = 0; j < n2; j++){
            rightArray[j] = b[q + j + 1];
        }

        leftArray[n1] = Integer.MAX_VALUE;
        rightArray[n2] = Integer.MAX_VALUE;

        for (int i = 0,j = 0, k = p; k <= r; k++){
            if (leftArray[i] <= rightArray[j]){
                b[k] = leftArray[i];
                i++;
            }else{
                b[k] = rightArray[j];
                j++;
            }
        }

    }

    public static void main(String[] args) {
        int[] array = {3, 5, 2, 7, 9, 2, 4, 1, 6};
        mergeSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }
}
