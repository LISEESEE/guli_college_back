package com.lss.educms.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class Solution {
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (target - nums[i] == nums[j]){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 7, 11, 15};
        int[] twoSum = twoSum2(arr, 22);
        for (int ele: twoSum) {
            System.out.println(ele);
        }
    }

    private static int[] twoSum2(int[] nums, int target) {
        //map key  v
        //    2    0下标
                
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
           int theNum = target - nums[i];
           if (map.containsKey(theNum)){
                return new int[]{map.get(theNum),i};
           }
           map.put(nums[i],i);
        }
        return null;
    }
}
