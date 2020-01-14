package com.cool.code.question5;
import java.util.Arrays;

/**
 * @description:
 * @author: caozheng
 * @date: 2019/8/5 11:16
 */
public class Solution {


	/**
	 * 中心扩散法处理
	 * 	例如：
	 *   字符串下标：0  1  2  3  4  5  6  7  8  9  10  11
	 * 	 原始字符串：c  b  b  d  e  f  a  a  f  e  s   d
	 * @param s
	 * @return
	 */
	public static String longestPalindrome1(String s){
		if (s == null || s.length() < 1) return "";
		// start 重复子串开始位置  end  结束位置
		int start = 0,end = 0;
		for (int i = 0; i < s.length(); i++) {

			// 用于处理奇数
			int len1 = expandAroundCenter(s, i, i);
			// 用于处理偶数
			int len2 = expandAroundCenter(s, i, i + 1);
			// 最大长度 如果为奇数说明是以i为中心扩展，例如 aba ,如果为偶数说明以i,i+1为中心进行扩展例如 abba
			int len = Math.max(len1, len2);
			// 判断len 返回的长度是否大于目前找到的最大长度
			if (len > end - start) {
				// 如果len=1：则开始位置为 i,结束位置为 i 说明无匹配
				// 如果len=2：则开始位置为 i,结束位置为 i+1
				// 如果len=3：则开始位置为 i-,结束位置为 i+1
				start = i - (len-1)  / 2;
				end = i + len / 2;
			}
		}
		return s.substring(start, end + 1);
	}

	/**
	 * 以left,right中心为基准向俩边扩展，查找最大长度
	 * @param s			原始字符串
	 * @param left		（左指针）左边开始查找的下标
	 * @param right		（右指针）右边下标
	 * @return 返回扩展长度
	 */
	private static int expandAroundCenter(String s, int left, int right) {
		int L = left, R = right;
		while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
			L--;
			R++;
		}
		return R - L - 1;
	}

}
