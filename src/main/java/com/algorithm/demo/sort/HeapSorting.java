package com.algorithm.demo.sort;

/**
 * @author mahongbin
 * @date 2019/4/12 10:44
 */
public class HeapSorting {

    public static void sort(int []arr){

        for(int num = 0; num < arr.length; num++) {
            System.out.print(arr[num] + " ");
        }

        System.out.println();
        System.out.println("第 1 个非叶子节点：" + arr[arr.length/2-1] + " ，下标为：" + (arr.length/2-1));

        //1.构建大顶堆
        for(int i=arr.length/2-1;i>=0;i--){
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr,i,arr.length);
        }

        //2.调整堆结构+交换堆顶元素与末尾元素
        for(int j=arr.length-1;j>0;j--){
            //将堆顶元素与末尾元素进行交换
            swap(arr,0,j);

            //重新对堆进行调整
            adjustHeap(arr,0,j);

            for(int num = 0; num < arr.length; num++) {
                System.out.print(arr[num] + " ");
            }
            System.out.println();
        }

    }

    /**
     * 调整大顶堆（仅是调整过程，建立在大顶堆已构建的基础上）
     * @param arr
     * @param i
     * @param length
     */
    public static void adjustHeap(int []arr,int i,int length){

        //先取出当前元素i
        int temp = arr[i];

        //从i结点的左子结点开始，也就是2i+1处开始
        for(int k=i*2+1;k<length;k=k*2+1){

            //如果左子结点小于右子结点，k指向右子结点
            if(k+1<length && arr[k]<arr[k+1]){
                k++;
            }

            //如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
            if(arr[k] >temp){
                arr[i] = arr[k];
                i = k;
            }else{
                break;
            }
        }

        //将temp值放到最终的位置
        arr[i] = temp;
    }

    /**
     * 交换元素
     * @param arr
     * @param a
     * @param b
     */
    public static void swap(int []arr,int a ,int b){
        int temp=arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
