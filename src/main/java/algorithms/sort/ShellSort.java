package algorithms.sort;

import java.util.Arrays;

/**
 * Created by leibnik on 16-10-28.
 */
public class ShellSort {

    public static void sort(int[] a) {
        int N = a.length;
        int h = 1;
        while (h < N / 3) h = h * 3 + 1;
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && a[j] <= a[j - h]; j -= h) {
                    int tmp = a[j];
                    a[j] = a[j - h];
                    a[j - h] = tmp;
                }
            }
            h /= 3;
        }
    }

    public static void main(String[] args) {
        int[] a = {3, 6, 1, 9, 10, 4, 2, 8, 23, 7, 39, 23, 16, 17, 18, 19};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
