package com.cool.code.question2;

import com.cool.common.PrintUtils;

/**
 * @description:
 * 2、两数相加
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
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

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


	/**
	 * 非递归解法
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode addTwoNumbers1(ListNode l1, ListNode l2){

		// 进位标识
		int flag = 0;
		// 值
		int value ;
		// 定义俩个引用指向同一列表
		ListNode listNode = new ListNode(0);
		ListNode res = listNode;
		// 如果l1,l2不为空，则循环
		while (l1 != null || l2 != null){
			value = flag;
			if(l1 != null){
				value += l1.val;
				l1 = l1.next;
			}
			if(l2 != null){
				value += l2.val;
				l2 = l2.next;
			}
			// 当相加值大于10时，产生进位
			if(value >=10){
				flag=1;
				value -=10;
			}else{
				flag = 0;
			}
			res.next = new ListNode(value);
			res = res.next;
		}
		// 如果进位标识不为0，则说明最后会产生进位，例如 5 + 5
		if(flag!=0){
			res.next=new ListNode(1);
		}
		return listNode.next;
	}


	/**
	 * 	链表节点
 	 */
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

	/**
	 * 打印工具类
	 * @param node
	 */
	public static void print(ListNode node){
		if(node == null){
			return;
		}
		ListNode t = node;
		while (t !=null){
			PrintUtils.controlPrint(t.val);
			t = t.next;
		}
		return;
	}
}

