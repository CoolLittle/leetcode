package com.cool.code.question1;

/**
 * @description:
 * @author: cz
 * @date: 2019/7/29 13:34
 */
public class Solution {
	public static int[] twoSum(int[] nums, int target) {
		int[] reVal = new int[2];
		for (int i = 0,len = nums.length;i<len-1;i++){
			for (int j = i+1;j<len;j++){
				if(nums[i]+ nums[j] == target){
					reVal[0] = i;
					reVal[1] = j;
					return reVal;
				}
			}
		}
		return null;
	}
}
