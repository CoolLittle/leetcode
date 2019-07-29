package com.cool.code.question2;

import com.cool.code.common.PrintUtils;

/**
 * @description:
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * @author: cz
 * @date: 2019/7/29 13:42
 */
public class Solution {

	/**
	 * 递归方式解决俩个数字相加
	 * @param l1
	 * @param l2
	 * @return
	 */
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		int value = l1.val + l2.val;
		ListNode res;
		// 先计算当前值是或否大于10
		if(value>=10){
			res =  new ListNode(value - 10);
			// 如果l1为空则进位补充为0，然后+1
			if(l1.next == null){
				l1.next = new ListNode(0);
			}
			l1.next.val += 1;
		}else {
			// 否则填入当前值
			res =  new ListNode(value);
		}
		// 如果俩个链表的下一个节点都为空
		if(l1.next == null && l2.next == null ){
			// 并且相加后值大于10，则补0进位
			if(value>=10){
				if(l1.next == null){
					l1.next = new ListNode(0);
				}
				if(l2.next == null) {
					l2.next = new ListNode(0);
				}
				l1.next.val += 1;
				res.next = addTwoNumbers(l1.next,l2.next);
			}else {
				return res;
			}
		}
		if(l1.next == null){
			l1.next = new ListNode(0);
		}
		if(l2.next == null) {
			l2.next = new ListNode(0);
		}

		res.next = addTwoNumbers(l1.next,l2.next);
		return res;
	}

	public static void print(ListNode node){
		ListNode t = node.next;
		PrintUtils.controlPrint(node.val);
		if (t != null){
			print(node.next);
		}
		return;
	}
}
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}
