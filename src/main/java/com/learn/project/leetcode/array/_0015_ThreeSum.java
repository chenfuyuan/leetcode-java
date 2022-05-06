package com.learn.project.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 15. 三数之和
 * https://leetcode-cn.com/problems/3sum/
 * @author chenfuyuan
 * @date 2022/5/6 9:27
 */
public class _0015_ThreeSum {


    public List<List<Integer>> sortAndDoublePoint(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();//arraylist里面的每个元素都是一个arraylist
        if(nums == null || nums.length < 3){
            return result;
        }
        Arrays.sort(nums);
        int len = nums.length;
        for(int i = 0;i < len;i++){
            //若当前最小元素>0，则跳出循环
            if(nums[i] > 0){
                return result;
            }
            //若当前元素与前一个元素相同，则进行下一次循环
            if(i > 0 && nums[i-1] == nums[i]){
                continue;
            }
            int num = nums[i];
            int leftIndex = i + 1;
            int rightIndex = len - 1;
            while(leftIndex < rightIndex){
                int sum = num + nums[leftIndex] + nums[rightIndex];
                if(sum == 0){
                    List<Integer> resultItem = new LinkedList<>();
                    resultItem.add(num);
                    resultItem.add(nums[leftIndex]);
                    resultItem.add(nums[rightIndex]);
                    result.add(resultItem);
                    //若当前l指针所指元素与前一个元素相同，则l++
                    while(leftIndex < rightIndex && nums[leftIndex] == nums[leftIndex+1]){
                        leftIndex++;
                    }
                    //若当前r指针所指元素与前一个元素相同，则r--
                    while(leftIndex < rightIndex && nums[rightIndex] == nums[rightIndex-1]){
                        rightIndex--;
                    }
                    leftIndex++;
                    rightIndex--;
                }else if(sum < 0){
                    leftIndex++;
                }else{
                    rightIndex--;
                }
            }
        }
        return result;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        return sortAndDoublePoint(nums);
    }
}
