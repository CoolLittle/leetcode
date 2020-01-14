package com.cool.code.question5;

import com.cool.common.PrintUtils;
import javafx.scene.transform.Scale;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @description:
 * @author: caozheng
 * @date: 2019/8/5 11:17
 */
public class SolutionTest {

	@Test
	public void longestPalindrome() {

		String res = Solution.longestPalindrome1("qssabbacf");

		String[] array = {"a","b","c",};
		List a = Stream.of(array).collect(Collectors.toList());

		PrintUtils.controlPrint(res);

	}
}