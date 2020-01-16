package com.cool.code.question507;

/**
 * @description:
 * #507. 完美数
 * @author: caozheng
 * @date: 2020/1/15
 */
public class Solution {

	/**
	 * 标签：数学
	 * 首先由于完美数的定义，需要排除自身，所以数字 111 一定不是完美数
	 * 其次我们需要计算 num 除了它自身以外的所有正因子之和 sum，正因子必然是成对出现的，故而我们只需要遍历到 num 的平方根 sqrt 即可
	 *
	 *     以 363636 为例，它的非自身外正因子有，1、2、3、4、6、9、12、18，其中 1 和 6 单独计算，[2, 18]、[3, 12]、[4, 9]都是对应关系、
	 *     所以只需要遍历到 36 的平方根 6 就可以获取全部正因子
	 *     1 单独计算的原因是要排除自身，666 单独计算的原因是 6 * 6 = 36，两个值相同，故而只能计算一遍
	 *
	 * 时间复杂度：O(根号n)，n 为 num 的大小
	 *
	 * Tips：完美数只有 6, 28, 496, 8128, 33550336 这几个，可以通过判断该数字是否为以下几个来解决
	 *
	 * 作者：guanpengchn
	 * 链接：https://leetcode-cn.com/problems/perfect-number/solution/hua-jie-suan-fa-507-wan-mei-shu-by-guanpengchn/
	 * 来源：力扣（LeetCode）
	 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
	 * @param num
	 * @return
	 */
	public static boolean checkPerfectNumber(int num) {
		if (num == 1) {
			return false;
		}
		// 正整数一定会有一个1，同时不用考虑自身，所以单独处理
		int sum = 1;
		int i = 2;
		double sqrt = Math.sqrt(num);
		for (; i < sqrt; i++) {
			if (num % i == 0) {
				sum += i;
				sum += num / i;
			}
		}
		// 此处单独处理的原因在于只需要加1次i值，如果在循环中会加2次
		if (i * i == num) {
			sum += i;
		}
		return sum == num;
	}
}
