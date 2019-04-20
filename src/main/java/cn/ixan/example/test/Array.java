package cn.ixan.example.test;

import java.util.Arrays;

/**
 * @author stack_zhang@outlook.com
 * @date 2019年3月4日, 0004
 */
public class Array {
	public static void main(String[] args) {
		print();
		sort();
	}

	//1.如何创建空数组？
	private static void print() {
		int[] ints = new int[]{};
		System.out.println(Arrays.toString(ints));
	}

	//2.如何对数组进行排序？
	private static void sort() {
		int[] ints = new int[]{0, 5, 6, 4, 12, 3, 7, 9, 3, 2};
		Arrays.sort(ints);
		System.out.println(Arrays.toString(ints));
	}

}
