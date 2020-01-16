package com.cool.common;

import java.util.Collection;
import java.util.Iterator;

/**
 * @description: 打印工具类
 * @author: cz
 * @date: 2019/7/29 13:38
 */
public class PrintUtils {

	public static void controlPrint(int[] args){
		for (int i = 0,len = args.length; i < len ;i++){
			System.out.print(args[i]+" ");
		}
		System.out.println();
	}
	public static void controlPrint(Collection args){
		Iterator iterator = args.iterator();
		while (iterator.hasNext()){
			System.out.print(iterator.next());
		}
		System.out.println();
	}
	public static void controlPrint(byte[] args){
		for (int i = 0,len = args.length; i < len ;i++){
			System.out.print(args[i]);
		}
		System.out.println();
	}
	public static void controlPrint(int args){
			System.out.println(args);
	}
	public static void controlPrint(String args){
			System.out.println(args);
	}
	public static void controlPrint(double args){
			System.out.println(args);
	}
	public static void controlPrint(boolean args){
			System.out.println(args);
	}

}
