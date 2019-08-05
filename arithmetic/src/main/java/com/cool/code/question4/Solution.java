package com.cool.code.question4;

import java.util.*;

/**
 * @description:
 * @author: caozheng
 * @date: 2019/8/1 16:07
 */
public class Solution {

	public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {

		int m = nums1.length;
		int n = nums2.length;

		//如果数组A的长度大于等于数组B，则交换数组
		if (m > n) {
			int[] temp = nums1;
			nums1 = nums2;
			nums2 = temp;
			int tmp = m;
			m = n;
			n = tmp;
		}

		int start = 0;
		int end = m;
		int mid = (m + n + 1) / 2;

		while (start <= end) {

			int i = (start + end) / 2;
			int j = mid - i;
			if (i < end && nums2[j-1] > nums1[i]){
				//i偏小了，需要右移
				start = i + 1;
			}
			else if (i > start && nums1[i-1] > nums2[j]) {
				//i偏大了，需要左移
				end = i - 1;
			}
			else {
				//i刚好合适
				int maxLeft;
				if (i == 0) {
					//数组A的元素都大于数组B的情况
					maxLeft = nums2[j-1];
				} else if (j == 0) {
					//数组A的元素都小于数组B的情况
					maxLeft = nums1[i-1];
				} else {
					maxLeft = Math.max(nums1[i-1], nums2[j-1]);
				}
				if ( (m + n) % 2 == 1 ) {
					//如果大数组的长度是奇数，中位数就是左半部分的最大值
					return maxLeft;
				}
				int minRight;
				if (i == m) {
					minRight = nums2[j];
				} else if (j == n) {
					minRight = nums1[i];
				} else {
					minRight = Math.min(nums2[j], nums1[i]);
				}
				//如果大数组的长度是偶数，取左侧最大值和右侧最小值的平均
				return (maxLeft + minRight) / 2.0;
			}
		}
		return 0.0;
	}


	/**
	 *	待完善
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {

		int m = nums1.length;
		int n = nums2.length;
		int count = n+m;
		//
		boolean odd = false;
		//如果数组A的长度大于等于数组B，则交换数组
		if (count<=1) {
			if(nums1.length==0 && nums2.length==0){
				return 0.0;
			}else if(nums1.length==0 && nums2.length==1){
				return nums2[0]+0.0;
			}else if(nums1.length==1 && nums2.length==0){
				return nums1[0]+0.0;
			}
		}else{
			if(count%2 == 1){
				odd= true;
				count = (count+1)/2;
			}else{
				odd = false;
				count = (count-1)/2;
			}

		}
		int index = 0;
		int i = 0;
		int j = 0;
		do{
			int num1C = 0;
			int num2C = 0;
			if(nums1.length>i){
				num1C = nums1[i];
			}
			if(nums2.length>j){
				num2C = nums2[j];
			}
			if(num1C < num2C && m != 0){
				i++;
				if(index+1>count){
					i++;
				}
			}else if(num1C > num2C && n != 0){
				j++;
				if(index+1>count){
					j++;
				}
			} else if(num1C == num2C){
				if(m>n){
					i++;
				}else if(m<n){
					j++;
				}else{
					i++;
				}
			}else if(num1C == 0){
				j++;
			}else if(num2C == 0){
				i++;
			}
			index++;
			if(m<=(i-1)){
				i = m-1;
				j++;
			}
			if(n<=(j-1)){
				j = n-1;
				i++;
			}
		}while (index < count);

		if(m<=i){
			i = m-1;
		}else if(0>i-1){
			i = 0;
		} else {
			//i--;
		}
		if(n<=j){
			j = n-1;
		}else if(0>j-1){
			j = 0;
		}else {
			//j--;
		}

		if(odd){
			if(i>j){
				return nums1[i];
			}else if(i==j){
				return nums1[i] > nums2[j]?nums1[i]:nums2[j];
			}else {
				return nums2[j];
			}
		}else {
			if(m == 0){
				return (nums2[j-1] + nums2[j]+0.0) / 2;
			}else if(n == 0){
				return (nums1[i-1] + nums1[i]+0.0) / 2;
			}else {
				return (nums1[i] + nums2[j]+0.0) / 2;
			}
		}
	}


	/**
	 *
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

		if(nums1.length==0 && nums2.length==0){
			return 0;
		}else if(nums1.length==0 && nums2.length==1){
			return nums2[0]+0.0;
		}else if(nums1.length==1 && nums2.length==0){
			return nums1[0]+0.0;
		}
		int[] values = new int[nums1.length+nums2.length];
		int index = 0;
		for (int i = 0; i < nums1.length; i++) {
			values[index] = nums1[i];
			index ++;
		}

		for (int i = 0; i < nums2.length; i++) {
			int _index = i+index;
			values[_index] = nums2[i];
		}
		Arrays.sort(values);
		int flag = 0;
		int len = values.length;
		if(len%2 == 1){
			flag = len/2 +1;
			return values[flag-1];
		}else{
			flag = len/2;
			return (values[flag]+values[flag-1]+0.0) /2;
		}

	}

}
