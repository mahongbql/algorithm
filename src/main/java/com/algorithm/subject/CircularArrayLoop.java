package com.algorithm.subject;

/**
 * @Auther: mahongbin
 * @Date: 2021-08-10 21:58
 * @Description: 457. 环形数组是否存在循环
 *
 * 存在一个不含 0 的 环形 数组 nums ，每个 nums[i] 都表示位于下标 i 的角色应该向前或向后移动的下标个数：
 *
 * 如果 nums[i] 是正数，向前（下标递增方向）移动 |nums[i]| 步
 * 如果 nums[i] 是负数，向后（下标递减方向）移动 |nums[i]| 步
 * 因为数组是 环形 的，所以可以假设从最后一个元素向前移动一步会到达第一个元素，而第一个元素向后移动一步会到达最后一个元素。
 *
 * 数组中的 循环 由长度为 k 的下标序列 seq 标识：
 *
 * 遵循上述移动规则将导致一组重复下标序列 seq[0] -> seq[1] -> ... -> seq[k - 1] -> seq[0] -> ...
 * 所有 nums[seq[j]] 应当不是 全正 就是 全负
 * k > 1
 * 如果 nums 中存在循环，返回 true ；否则，返回 false 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [2,-1,1,2,2]
 * 输出：true
 * 解释：存在循环，按下标 0 -> 2 -> 3 -> 0 。循环长度为 3 。
 * 示例 2：
 *
 * 输入：nums = [-1,2]
 * 输出：false
 * 解释：按下标 1 -> 1 -> 1 ... 的运动无法构成循环，因为循环的长度为 1 。根据定义，循环的长度必须大于 1 。
 * 示例 3:
 *
 * 输入：nums = [-2,1,-1,-2,-2]
 * 输出：false
 * 解释：按下标 1 -> 2 -> 1 -> ... 的运动无法构成循环，因为 nums[1] 是正数，而 nums[2] 是负数。
 * 所有 nums[seq[j]] 应当不是全正就是全负。
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 5000
 * -1000 <= nums[i] <= 1000
 * nums[i] != 0
 *
 */
public class CircularArrayLoop {

    public static void main(String[] args) {
        int[] nums = {2,-1,1,2,2};
        System.out.println(circularArrayLoop(nums));
    }

    public static boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++) {
            if(visited[i]) continue;
            int slow = i;
            int fast = nextIndex(n, nums, i);
            while(checkNum(nums[i], nums[fast]) && checkNum(nums[i], nums[nextIndex(n ,nums, fast)])) {
                if(slow == fast) {
                    if(fast != nextIndex(n ,nums, fast)) {
                        return true;
                    } else {
                        break;
                    }
                }
                slow = nextIndex(n, nums, slow);
                fast = nextIndex(n, nums, nextIndex(n, nums, fast));
            }
            int j = i;
            while (checkNum(nums[i], nums[j])) {//将访问过的元素值置为0
                int nextJ = nextIndex(n, nums, j);
                nums[j] = 0;
                j = nextJ;
            }
        }
        return false;
    }

    public static int nextIndex(int n, int[] nums, int index) {
        return ((index + nums[index]) % n + n) % n;
    }

    public static boolean checkNum(int a, int b) {
        return (a > 0 && b > 0) || (a < 0 && b < 0);
    }
}
