package com.cool.code.question4;

import com.cool.common.PrintUtils;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @description:
 * @author: caozheng
 * @date: 2019/8/1 16:16
 */
public class SolutionTest {

	@Test
	public void findMedianSortedArrays() {
		int[] num1 = {1,4,5,7,8,9,10};
		int[] num2 = {2,5,6};
		Double aDouble=  Solution.findMedianSortedArrays2(num1,num2);

		PrintUtils.controlPrint(aDouble);
	}
}