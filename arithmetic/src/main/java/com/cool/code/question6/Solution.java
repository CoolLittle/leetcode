package com.cool.code.question6;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: caozheng
 * @date: 2020/1/15
 */
public class Solution {


	public static String convert(String s, int numRows) {

		if(numRows<2){
			return s;
		}

		List<StringBuffer> rows = new ArrayList<>();
		for (int i = 0; i < numRows; i++) {
			rows.add(new StringBuffer());
		}
		int i = 0;
		int flag = -1;
		for (char c:s.toCharArray()) {
			rows.get(i).append(c);
			if(i == numRows-1 ||  i==0){
				flag = -flag;
			}
			i+=flag;
		}
		StringBuilder str = new StringBuilder();
		for (i = 0; i < numRows; i++) {
			str.append(rows.get(i));
		}
		return str.toString();
	}

}
