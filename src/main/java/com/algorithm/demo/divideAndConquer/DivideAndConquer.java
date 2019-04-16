package com.algorithm.demo.divideAndConquer;

import java.util.Arrays;

/**
 * @author mahongbin
 * @date 2019/4/16 9:43
 * @Description 分治算法
 */
public class DivideAndConquer {

    public static void merge(int[]a,int low,int mid,int high){
        int []temp = new int[high-low+1];
        int i = low;
        int j = mid+1;
        int k = 0;
        while(i<=mid&&j<=high){
            if(a[i]<a[j]){
                temp[k++] = a[i++];
            }else {
                temp[k++] = a[j++];
            }
        }
        while(i <= mid){
            temp[k++] = a[i++];
        }
        while(j <= high){
            temp[k++] = a[j++];
        }
        for(int k2 = 0;k2<temp.length;k2++){
            /**
             * temp 为 a[low ----- temp.length] 区间交换后的只值
             */
            a[k2+low] = temp[k2];
        }
    }

    public static void mergeSort(int[]a,int low,int high){
        int mid = (low + high)/2;
        if(low < high){
            /**
             * 这里发生递归调用
             */
            mergeSort(a, low, mid);
            mergeSort(a, mid+1, high);

            /**
             * 例如分解到很小，此时只有两个元素，low为0，mid为0，high为1
             */
            merge(a, low, mid, high);
            System.out.println(Arrays.toString(a));
        }
    }

    public static void main(String[] args) {
        // TODO 自动生成的方法存根
        int a[] = {52,45,77,33,4,5,22,77,43};
        mergeSort(a, 0, a.length-1);
        System.out.println("排序的结果"+Arrays.toString(a));

    }
}
