package com.cool.code.question6;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: caozheng
 * @date: 2020/1/15
 */
public class Solution {


	/**
	 * 设置标识符flag用于正向或者逆向获取行
	 * @param s
	 * @param numRows
	 * @return
	 */
	public static String convert(String s, int numRows) {

		if(numRows<2){
			return s;
		}

		List<StringBuffer> rows = new ArrayList<>();
		for (int i = 0; i < numRows; i++) {
			rows.add(new StringBuffer());
		}
		int i = 0;
		boolean flag = true;
		for (char c:s.toCharArray()) {
			rows.get(i).append(c);
			// 如果i为0、或者i为行数-1下标 则进行逆转方向获取行数
			if(i == numRows-1 ||  i==0){
				flag = !flag;
			}
			if(flag){
				i++;
			}else{
				i--;
			}
		}
		StringBuilder str = new StringBuilder();
		for (i = 0; i < numRows; i++) {
			str.append(rows.get(i));
		}
		return str.toString();
	}

}
