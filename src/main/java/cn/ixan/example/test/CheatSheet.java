package cn.ixan.example.test;

import java.util.*;

/**
 * Java语法清单
 * @author stack_zhang@outlook.com
 * @date 2018/11/11
 */
public class CheatSheet {

	//if-else
	public static void test1(int income){
		double rate;
		if (income < 0) rate = 0.00;
		else if (income < 8925) rate = 0.10;
		else if (income < 36250) rate = 0.15;
		else if (income < 87850) rate = 0.23;
		else if (income < 183250) rate = 0.28;
		else if (income < 398350) rate = 0.33;
		else if (income < 400000) rate = 0.35;
		else rate = 0.396;
		System.out.println(rate);
	}

	//loops

	/**
	 * compute the largest
	 * power of 2
	 * less than or equal to n
	 */
	public static void test2(int n){
		int power = 1;
		while (power < n/2)
			power = 2 * power;
		System.out.println(power);
	}

	/**
	 * compute a finite sum
	 * (1+2+...+n)
	 */
	public static void test3(int n){
		int sum = 0;
		for(int i=0; i <= n; i++)
			sum += i;
		System.out.println(sum);
	}

	/**
	 * compute a finite product
	 * (n! = 1*2*...*n)
	 */
	public static void test4(int n){
		int product = 1;
		for(int i=1; i <= n; i++)
			product *= i;
		System.out.println(product);
	}

	/**
	 * print a table of
	 * function values
	 */
	public static void test5(int n){
		for(int i=0; i <= n; i++)
			System.out.println(i + " "+ 2*Math.PI*i/n);
	}

	/**
	 * compute the ruler function
	 */
	public static void test6(int n){
		StringBuilder ruler = new StringBuilder("1");
		for(int i=2; i <= n; i++)
			ruler.append(" ").append(i).append(" ").append(ruler);
		System.out.println(ruler);
	}

	//do-while
	public static void test7(){
		int count = 0;
		do {
			System.out.println("count is:"+ count);
			count++;
		}while (count<11);
	}

	//switch-case
	public static void test8(int day){
		switch(day){
			case 0: System.out.println("Sun");break;
			case 1: System.out.println("Mon");break;
			case 2: System.out.println("Tue");break;
			case 3: System.out.println("Wed");break;
			case 4: System.out.println("Thu");break;
			case 5: System.out.println("Fri");break;
			case 6: System.out.println("Sat");break;
		}
	}

	//字符串比较
	public static void test10(String str1, String str2){
		boolean result1 = str1.equals(str2);
		System.out.println(result1);
		boolean result2 = str1.equalsIgnoreCase(str2);
		System.out.println(result2);
	}

	//字符串反转
	public static void test11(){
		String str1 = "whatever string something";
		StringBuffer buffer = new StringBuffer(str1);
		String reverse = buffer.reverse().toString();
		System.out.println(reverse);
	}

	//按单词的字符串反转
	public static void test12(){
		String str1 = "reverse this string";
		Stack<Object> stack = new Stack<>();
		StringTokenizer tokenizer = new StringTokenizer(str1);
		while (tokenizer.hasMoreElements())
			stack.push(tokenizer.nextElement());
		StringBuffer buffer = new StringBuffer();
		while (!stack.isEmpty()){
			buffer.append(stack.pop());
			buffer.append(" ");
		}
		System.out.println(buffer);
	}
	//大小写转换
	public static void test13(String str1,String str2){
		String str1Upper = str1.toUpperCase();
		System.out.println(str1Upper);
		String strLower = str2.toLowerCase();
		System.out.println(strLower);
	}
	//首尾空格移除
	public static void test14(){
		String str1 = "    asdfdfdf     ";
		System.out.println(str1.trim());
	}

	//空格移除
	public static void test15(){
		String str1 = "zhang xian long     ";
		String replaceAll = str1.replaceAll(" ", "");
		System.out.println(replaceAll);
	}

	//字符串转化为数组
	public static void test16(){
		String str1 = "tim,kerry,timyy,camden";
		String[] split = str1.split(",");
		System.out.println(split);
	}

	//重置数组大小:
	public static void test17(){
		int[] myArray = new int[10];
		int[] temp = new int[myArray.length+10];
		System.arraycopy(myArray,0,temp,0,temp.length);
		myArray = temp;
	}

	//集合遍历
	public static void test18(){
		Map<String,Object> map = new HashMap<>();
		map.put("1","zhangsan");
		map.put("2","lisi");
		map.put("3","wangwu");
		for (Map.Entry<String, Object> next : map.entrySet()) {
			System.out.println(next.getKey() + ":" + next.getValue());
		}
	}

	//数组排序
	public static void test19(){
		int[] nums = {1,4,7,314,0,-4};
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));
	}

	//列表排序
	public static void test20(){
		List<String> unsort = new ArrayList<>();
		unsort.add("CCC");
		unsort.add("111");
		unsort.add("AAA");
		Collections.sort(unsort);
		System.out.println(unsort);
	}
	// hello,world!
	public static void main(String[] args) {
		System.out.println("Hello,World");
	}
}
