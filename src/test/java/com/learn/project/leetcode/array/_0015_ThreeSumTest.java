package com.learn.project.leetcode.array;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

public class _0015_ThreeSumTest extends TestCase {

    private _0015_ThreeSum solution = new _0015_ThreeSum();

//    private int[] nums = {-1,0,1,2,-1,-4};
    private int[] nums = {0,0,0,0};
//    private int[] nums = {-1,1,0,0};

    public void testSortAndDoublePoint() {
        List<List<Integer>> result = solution.sortAndDoublePoint(nums);
        System.out.println(result);
    }
}