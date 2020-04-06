package com.algorithm.test;

/**
 * 归并排序
 */
public class MergeTwoArray {

    public static void main(String[] args) {
        int[] a = {1,3,5,7,9};
        int[] b = {2,4,6,8};

        int[] c = merge(a, b);
        for(int i : c) {
            System.out.println(i);
        }
    }

    private static int[] merge(int[] a, int[] b) {
        int aLength = a.length;
        int bLength = b.length;
        int[] c = new int[aLength + bLength];

        int i = 0, j = 0, k = 0;
        while(i < aLength && j < bLength) {
            if(a[i] < b[j]) {
                c[k++] = a[i++];
            } else {
                c[k++] = b[j++];
            }
        }

        while(i < aLength) {
            c[k++] = a[i++];
        }

        while(j < bLength) {
            c[k++] = b[j++];
        }

        return c;
    }


}
