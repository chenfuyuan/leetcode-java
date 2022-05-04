package com.learn.project.leetcode.array;

import junit.framework.TestCase;

/**
 * TODO(这里用一句话描述这个类的作用)
 *
 * @author chenfuyuan
 * @date 2022/5/4 17:05
 */
public class _0011_containerWithMostWaterTest extends TestCase {

//    private int[] input = new int[]{1,8,6,2,5,4,8,3,7};
    private int[] input = new int[]{1,2,4,3};


    public void testForceSolution() {
        int result = _0011_containerWithMostWater.force(input);
        System.out.println(result);
    }

    public void testDoublePoint() {
        int result = _0011_containerWithMostWater.doublePoint(input);
        System.out.println(result);
    }
}