package com.learn.project.leetcode.array;

import junit.framework.TestCase;

import java.util.Arrays;

/**
 * TODO(这里用一句话描述这个类的作用)
 *
 * @author chenfuyuan
 * @date 2022/5/3 16:39
 */
public class _0001_TwoSumTest extends TestCase {

    private static int[] nums_test = new int[]{3,2,3};
    private static int target = 6;

    public void testForceSolution() {
        int[] result = _0001_TwoSum.twoSum(nums_test, target);
        System.out.println(Arrays.toString(result));
    }

}