package cn.ixan.example.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author stack_zhang@outlook.com
 * @date 2019年3月21日, 0021
 */
public class ForeachTest {
	public static void main(String[] args) {
		testIteratorRemove();
	}

	public static void testIteratorRemove(){
		List<String> list = new ArrayList<>();
		list.add("1");
		list.add("2");
		Iterator<String> iterator = list.iterator();
		do {
			if(!iterator.hasNext())
				break;
			String next = iterator.next();
			if("2".equals(next))
				list.remove(next);
		}while (true);
	}

	public static void testRemove(){
		List<String> list = new ArrayList<>();
		list.add("1");
		list.add("2");
		for(String string:list){
			if("2".equals(string)){
				list.remove(string);
			}
		}
	}
}
