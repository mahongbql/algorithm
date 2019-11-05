package com.algorithm.demo.leetCode;

/**
 * @author mahongbin
 * @date 2019/10/30 16:32
 * @Description
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2 。
 * 请找出这两个有序数组的中位数。要求算法的时间复杂度为 O(log (m+n)) 。
 * 示例 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 中位数是 2.0
 *
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 中位数是 (2 + 3)/2 = 2.5
 *
 * 1
 * 23456789
 *
 * 给点思路：
 *  A 短的数组 | B 长的数组
 *  i -> 相当于 短的中点
 *  halfLen -> 相当于 A + B 的中点
 *  j -> 相当于 A中点到A+B中点距离，类似于一个区间
 *  j这个区间随着 i增大（i向正半轴的右边移动，j也会向正半轴左边移动同样距离）
 */
public class SortArrayMedian {
    public static double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A;
            A = B;
            B = temp;
            int tmp = m;
            m = n;
            n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j - 1] > A[i]) {
                iMin = iMin + 1; // i is too small
            } else if (i > iMin && A[i - 1] > B[j]) {
                iMax = iMax - 1; // i is too big
            } else { // i is perfect
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = B[j - 1];
                } else if (j == 0) {
                    maxLeft = A[i - 1];
                } else {
                    //A数组中的和B数组中的一样大，取较大的
                    maxLeft = Math.max(A[i - 1], B[j - 1]);
                }

                //奇数直接返回
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }

                //A+B共有偶数个元素
                int minRight = 0;
                if (i == m) {
                    minRight = B[j];
                } else if (j == n) {
                    minRight = A[i];
                } else {
                    //A数组中的和B数组中的一样大，取较小的
                    minRight = Math.min(B[j], A[i]);
                }
                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
        int[] A = {1, 2};
        int[] B = {3, 4};
        System.out.println(findMedianSortedArrays(A, B));
    }
}
