package com.learn.project.leetcode.array;

/**
 * 11. 盛最多水的容器
 * https://leetcode-cn.com/problems/container-with-most-water/
 * @author chenfuyuan
 * @date 2022/5/4 16:55
 */
public class _0011_containerWithMostWater {


    public static int maxArea(int[] height) {
        //与x轴组成的面积算法 area = min(height[i],height[j]) * (j - i)
        return doublePoint(height);
        //return force(height);
    }

    /**
     * 双指针
     * @param height
     * @return
     */
    public static int doublePoint(int[] height) {
        if (height == null || height.length == 1) {
            return 0;
        }
        if (height.length == 2) {
            return Math.min(height[0], height[1]);
        }
        int leftIndex = 0;
        int rightIndex = height.length - 1;
        int leftHeight = height[leftIndex];
        int rightHeight = height[rightIndex];
        int result = 0;
        while (leftIndex < rightIndex) {
            int area = calculateArea(height, leftIndex, rightIndex);
            if (area > result) {
                result = area;
            }
            if (leftHeight <= rightHeight) {
                while (leftIndex < rightIndex && height[leftIndex] <= leftHeight) {
                    leftIndex++;
                }
                leftHeight = height[leftIndex];
            } else {
                while (leftIndex < rightIndex && height[rightIndex] <= rightHeight) {
                    rightIndex--;
                }
                rightHeight = height[rightIndex];
            }
        }
        return result;
    }

    /**
     * 暴力穷举
     * 超出时间限制
     * @param height
     * @return
     */
    public static int force(int[] height) {
        if (height == null || height.length == 1) {
            return 0;
        }

        int area = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i; j < height.length; j++) {
                int curArea = calculateArea(height, i, j);
                if (curArea > area) {
                    area = curArea;
                }
            }
        }
        return area;
    }


    public static int calculateArea(int[] height, int leftIndex, int rightIndex) {
        return Math.min(height[leftIndex], height[rightIndex]) * (rightIndex - leftIndex);
    }
}
