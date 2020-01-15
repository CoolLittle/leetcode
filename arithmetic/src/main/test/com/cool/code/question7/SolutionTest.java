package com.cool.code.question7;

import com.cool.common.PrintUtils;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @description:
 * @author: caozheng
 * @date: 2020/1/15 16:50
 */
public class SolutionTest {

	@Test
	public void reverse() {
		//2147483647
		PrintUtils.controlPrint(Solution.reverse(463847414));
	}
}