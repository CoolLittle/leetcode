package com.cool.code.question2;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @description:
 * @author: cz
 * @date: 2019/7/29 13:47
 */
public class SolutionTest {

	@Test
	public void addTwoNumbers() {

		// 构造第一个列表
		ListNode listNode1 = new ListNode(9);
		listNode1.next = new ListNode(4);
		listNode1.next.next = new ListNode(2);
		// 构造第二个列表
		ListNode listNode2 = new ListNode(4);
		listNode2.next = new ListNode(6);
		listNode2.next.next = new ListNode(5);

		ListNode listNode  = Solution.addTwoNumbers(listNode1,listNode2);
		Solution.print(listNode);
	}
	@Test
	public void addTwoNumbers1() {

		// 构造第一个列表
		ListNode listNode1 = new ListNode(9);
		listNode1.next = new ListNode(4);
		listNode1.next.next = new ListNode(2);
		// 构造第二个列表
		ListNode listNode2 = new ListNode(4);
		listNode2.next = new ListNode(6);
		listNode2.next.next = new ListNode(5);

		ListNode listNode  = Solution.addTwoNumbers1(listNode1,listNode2);
		Solution.print(listNode);
	}
}