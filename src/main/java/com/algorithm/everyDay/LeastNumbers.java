package com.algorithm.everyDay;

import java.util.Arrays;

/**
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 *
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *
 *
 * 限制：
 *
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i] <= 10000
 */
public class LeastNumbers {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int k = 2;

        System.out.println(getLeastNumbers(arr, k));
    }

    public static int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // 最后一个参数表示我们要找的是下标为k-1的数
        return quickSearch(arr, 0, arr.length - 1, k - 1);
    }

    /**
     * 找到那个合适的 j，使得左边数字都比 j 小，右边数字都比 j 大
     * 当 j 和 k 一致时表示此函数任务完成，不然进行递归查找
     * @param nums
     * @param lo
     * @param hi
     * @param k
     * @return
     */
    private static int[] quickSearch(int[] nums, int lo, int hi, int k) {
        // 每快排切分1次，找到排序后下标为j的元素，如果j恰好等于k就返回j以及j左边所有的数；
        int j = partition(nums, lo, hi);
        if (j == k) {
            return Arrays.copyOf(nums, j + 1);
        }
        // 否则根据下标j与k的大小关系来决定继续切分左段还是右段。
        return j > k? quickSearch(nums, lo, j - 1, k): quickSearch(nums, j + 1, hi, k);
    }

    /**
     * j > k 说明 j 在 k 的左边，所以为了找到 k，就在 lo ~ j-1 之间
     * 否则在右，说明 j 在 k 的右边，所以为了找到 k，就在 j+1 ~ hi 之间
     * @param nums
     * @param lo
     * @param hi
     * @return
     */
    // 快排切分，返回下标j，使得比nums[j]小的数都在j的左边，比nums[j]大的数都在j的右边。
    private static int partition(int[] nums, int lo, int hi) {
        int v = nums[lo];
        int i = lo, j = hi + 1;

        //这个循环用 [1, 0, 2] 去想
        while (true) {
            while (++i <= hi && nums[i] < v);
            while (--j >= lo && nums[j] > v);
            if (i >= j) {
                break;
            }
            int t = nums[j];
            nums[j] = nums[i];
            nums[i] = t;
        }


        //下面交换之后变成了 [2, 1, 0]
        //找到中间的那个数字，返回数字下标
        nums[lo] = nums[j];
        nums[j] = v;

        //返回下标 1
        return j;
    }

    public static int[] myGetLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] res = new int[k];
        for(int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }
}
