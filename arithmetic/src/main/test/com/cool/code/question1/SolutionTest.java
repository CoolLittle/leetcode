package com.cool.code.question1;

import com.cool.code.common.PrintUtils;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @description:
 * @author: cz
 * @date: 2019/7/29 13:35
 */
public class SolutionTest {

	@Test
	public void twoSum() {
		int[] nums = new int[]{2, 7, 11, 15};
		int[] res = Solution.twoSum(nums,9);
		PrintUtils.controlPrint(res);
	}
}