package com.cool.code.question1;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * 两数之和
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

	/**
	 * 将元素与下标放置于Map中
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int[] twoSum2(int[] nums, int target) {
		Map<Integer,Integer> map = new HashMap<>();
		int[] reVal = new int[2];
		for (int i = 0,len = nums.length;i<len;i++){
			int temp = target - nums[i];
			if(map.containsKey(temp)){
				reVal[0] = i;
				reVal[1] = map.get(temp);
				return reVal;
			}else {
				map.put(nums[i],i);
			}
		}
		return null;
	}
}
