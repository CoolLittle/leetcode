package com.cool.code.question7;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * 7. 整数反转
 * @author: caozheng
 * @date: 2020/1/15
 */
public class Solution {


	/**
	 * 例如 123
	 * 对10取余获取最后一位数字  3
	 * 对10取整获取前置位        12
	 * @param x
	 * @return
	 */
	public static int reverse(int x) {

		int rev = 0;
		while (x != 0) {
			int pop = x % 10;
			x /= 10;
			// int类型的范围是 -2^31——2^31-1，即-2147483648——2147483647，
			// 代码中的if中有(rev == INT_MAX / 10 && pop > 7)和(rev == INT_MIN / 10 && pop < -8)判断，
			// 看似完全顾及到各种情况，但是仔细一想，会发现根本就不会有符合这个条件的32位int数值，
			// 假如符合，也应该是int范围最大值反转过来，然后最高位大于7，
			// 首先int范围最大值反转过来就没法当作int数值传递到这个方法的形参中，
			// 在编译期就会报错：Integer number too large，所以如果方法的形参不是int类型的话，
			// 可以加上这些判断，但是如果方法的形参是int的话，完全不用考虑这些判断，
			// 因为在传递这个值的时候，编译期就报错了
			// 即不可能出现 463847414(1) 因为int溢出编译报错
			if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
				return 0;
			}
			if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
				return 0;
			}
			rev = rev * 10 + pop;
		}
		return rev;
	}

}
