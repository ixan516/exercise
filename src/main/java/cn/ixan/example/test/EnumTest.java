package cn.ixan.example.test;

import cn.ixan.example.domain.Subject;

/**
 * @author stack_zhang@outlook.com
 * @date 2019年3月11日, 0011
 */
public class EnumTest {
	public static void main(String[] args) {
//		testEnumValuesMethod("数学11");
		int ordinal = Subject.CHINESE.ordinal();
		System.out.println(ordinal);
	}
	private static void testEnumValuesMethod(String subject) {
		Subject sub = Subject.getSubject(subject);
		switch (sub){
			case MATH:
				System.out.println("数学最棒!");
				break;
			case ENGLISH:
				System.out.println("英语最棒!");
				break;
			case CHINESE:
				System.out.println("中文最棒!");
				break;
			default:
				System.out.println(sub);
				System.out.println("非法!");
				break;
		}
	}

	private static void testEnumValueOfMethod() {
		String subject = "MATH";
		switch (Subject.valueOf(subject)){
			case MATH:
				System.out.println("数学!");
				break;
			case ENGLISH:
				System.out.println("英语!");
				break;
			case CHINESE:
				System.out.println("中文!");
				break;
			default:
				System.out.println("非法!");
				break;
		}
	}
}
