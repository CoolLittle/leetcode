package com.cool.code.common;

/**
 * @description: 打印工具类
 * @author: cz
 * @date: 2019/7/29 13:38
 */
public class PrintUtils {

	public static void controlPrint(int[] args){
		for (int i = 0,len = args.length; i < len ;i++){
			System.out.println(args[i]);
		}
	}
	public static void controlPrint(int args){
			System.out.println(args);
	}

}
