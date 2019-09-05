package com.cool.code.question5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: caozheng
 * @date: 2019/8/5 11:16
 */
public class Solution {


	public static String longestPalindrome(String s) {

		byte[] args = s.getBytes();
		byte[] res = null;
		int j ;
		int a ;
		boolean flag ;
		for (int i = 0,len = args.length;i<len;i++){
			a = i;
			j = 0;
			flag = false;
			byte[] t = null;
			while (j<i){
				if(args[j] == args[a]){
					j++;
					a--;
				}else {
					j++;
				}

				 if(j == i){
					 t = Arrays.copyOf(args,i+1);
					 flag = true;
				 }
				 j++;
				 a--;
				 if(a <0){
				 	break;
				 }
			}
			if(flag){
				if( res==null || t == null || t.length>res.length){
					res = t;
				}
			}
		}
		return new String(res);
	}

	public static String longestPalindrome1(String s){
		if (s == null || s.length() < 1) return "";
		int start = 0, end = 0;
		for (int i = 0; i < s.length(); i++) {
			int len1 = expandAroundCenter(s, i, i);
			int len2 = expandAroundCenter(s, i, i + 1);
			int len = Math.max(len1, len2);
			if (len > end - start) {
				start = i - (len - 1) / 2;
				end = i + len / 2;
			}
		}
		return s.substring(start, end + 1);
	}

	private static int expandAroundCenter(String s, int left, int right) {
		int L = left, R = right;
		while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
			L--;
			R++;
		}
		return R - L - 1;
	}

}
