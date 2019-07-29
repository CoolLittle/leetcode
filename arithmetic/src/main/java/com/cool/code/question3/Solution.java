package com.cool.code.question3;

import com.cool.common.PrintUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @description:
 * @author: caozheng
 * @date: 2019/7/29 14:39
 */
public class Solution {

	/**
	 * 使用 HashSet 存储不重复字串，记录其出现的最大size即为最大不重复字串长度
	 * @param s
	 * @return
	 */
	public static int lengthOfLongestSubstring(String s) {

		int res = 0, left = 0, right = 0;
		Map<Character,Integer> t = new HashMap<>();

		while (right < s.length()) {
			if (!t.containsKey(s.charAt(right))) {
				t.put(s.charAt(right),right);
				right++;
				res = Math.max(res, t.size());
			} else {
				t.remove(s.charAt(left));
				left++;
			}
		}
		return res;
	}
}
