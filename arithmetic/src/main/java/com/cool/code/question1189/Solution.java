package com.cool.code.question1189;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * 1189. “气球” 的最大数量
 * @author: caozheng
 * @date: 2020/1/15
 */
public class Solution {


	/**
	 * 构造Map集合用于记录指定字符出现得次数
	 * 然后遍历查找最小出现次数
	 * @param text
	 * @return
	 */
	public static int maxNumberOfBalloons(String text) {
		Map<Character,Integer> map = new HashMap<>();
		map.put('b',0);
		map.put('a',0);
		map.put('l',0);
		map.put('o',0);
		map.put('n',0);

		for(char c : text.toCharArray()){
			if(map.containsKey(c)){
				map.put(c,map.get(c)+1);
			}
		}
		// 字符最大长度
		int res = 100000;
		map.put('l',map.get('l')/2);
		map.put('0',map.get('0')/2);
		for (Map.Entry<Character,Integer> entry:map.entrySet()) {
			int a = entry.getValue();
			if(res>a){
				res = a;
			}
		}

		return res;
	}

	/**
	 * 利用位图法计算
	 * 	因为a-z 为97-122 所以ch-97将a映射到数组0位置
	 * @param text
	 * @return
	 */
	public static int maxNumberOfBalloons1(String text) {
		int[] letters = new int[26];
		for(char ch :text.toCharArray()){
			letters[ch - 97] ++;
		}
		// 单独处理俩次出现的("l","o"),
		letters['l' - 97] /= 2;
		letters['o' - 97] /= 2;
		// 查找最小气球数量
		int min = Integer.MAX_VALUE;
		for(char ch : "balon".toCharArray()){
			if(letters[ch - 97] < min){
				min = letters[ch - 97];
			}
		}
		return min;
	}

}
