package com.learn.project.leetcode.array;


import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 * https://leetcode-cn.com/problems/two-sum/
 * @author chenfuyuan
 * @date 2022/5/3 16:25
 */
public class _0001_TwoSum {

    /**
     * 找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
     * @param nums 整数数组
     * @param target 整数目标值
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        return leastTime(nums, target);
//        return hashMap(nums, target);
//        return force(nums, target);
    }

    /**
     * 用时最少
     * @param nums
     * @param target
     * @return
     */
    public static int[] leastTime(int[] nums,int target) {
        int[] result = {0, 1};
        if (nums.length <= 2) {
            return result;
        }
        Map<Integer, Integer> valueToIndex = new HashMap<>();
        for (int i = 0, j = nums.length - 1; i <= j; i++, j--) {
            if (nums[i] + nums[j] == target) {
                // So lucky
                result[0] = i;
                result[1] = j;
                break;
            }
            if (valueToIndex.containsKey(target - nums[i])) {
                result[0] = i;
                result[1] = valueToIndex.get(target - nums[i]);
                break;
            }
            if (valueToIndex.containsKey(target - nums[j])) {
                result[0] = j;
                result[1] = valueToIndex.get(target - nums[j]);
                break;
            }

            valueToIndex.put(nums[i], i);
            valueToIndex.put(nums[j], j);
        }

        return result;
    }

    /**
     * 使用hashMap
     * @param nums
     * @param target
     * @return
     */
    public static int[] hashMap(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])){
                result[0] = map.get(target - nums[i]);
                result[1] = i;
                break;
            }
            map.put(nums[i], i);
        }
        return result;
    }

    /**
     * 暴力破解
     * @param nums
     * @param target
     * @return
     */
    private static int[] force(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (target - nums[i] == nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

}
