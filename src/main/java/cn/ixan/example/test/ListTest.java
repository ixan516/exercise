package cn.ixan.example.test;

import java.util.*;

/**
 * @author stack_zhang@outlook.com
 * @date 2019年3月18日, 0018
 */
public class ListTest {
	public static void main(String[] args) {
		shuffle();
	}

	/**
	 * <p>将List乱序</p>
	 */
	public static void shuffle(){
		List<String> list = new ArrayList<>();
		list.add("zhangsan1");
		list.add("zhangsan2");
		list.add("zhangsan3");
		list.add("zhangsan4");
		System.out.println("乱序前:"+list);
		Collections.shuffle(list,new Random(10));
		System.out.println("乱序后:"+list);
	}

	/**
	 * <p>如何将List反转</p>
	 */
	public static void reverse(){
		List<String> list = new ArrayList<>();
		list.add("zhangsan1");
		list.add("zhangsan2");
		list.add("zhangsan3");
		list.add("zhangsan4");
		System.out.println("反转前:"+list);
		Collections.reverse(list);
		System.out.println("反转后:"+list);
	}

	public static void insertIndex(){
		List<String> list = new ArrayList<>();
		list.add("zhangsan1");
		list.add("zhangsan2");
		list.add(1,"lisi");
		System.out.println(list);
	}
	/**
	 * <p>如何将List转换为数组</p>
	 */
	public static void toArray(){
		List<String> list = new ArrayList<>();
		list.add("zhangsan1");
		list.add("zhangsan2");
		list.add("zhangsan3");
		list.add("zhangsan4");
		String[] strings = new String[list.size()];
		String[] array = list.toArray(strings);
		Arrays.stream(array).forEach(System.out::println);
	}

	/**
	 * <p>如何将数组转换为List</p>
	 */
	public static void toList(){
		String[] array = new String[]{"zhangsan","lisi","wangwu","zhaoliu"};
		System.out.println(array);
		List<String> list = Arrays.asList(array);
		System.out.println(list);
	}
}
