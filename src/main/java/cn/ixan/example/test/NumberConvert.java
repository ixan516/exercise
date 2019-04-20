package cn.ixan.example.test;

/**
 * @author stack_zhang@outlook.com
 * @date 2019年3月18日, 0018
 */
public class NumberConvert {
	public static void main(String[] args) {
		convertStringNumber();
		toHexString();
	}


	/**
	 * <p>2.如何将数字转换为十六进制字符串</p>
	 */
	public static void toHexString(){
		int number = 100;
		System.out.println(Integer.toHexString(number));
	}

	/**
	 * <p>1.如何将字符串转换为数字</p>
	 * <p>使用数字的对应包装类</p>
	 */
	public static void convertStringNumber(){
		String number = "123.456";
		System.out.println(Double.parseDouble(number));
	}
}
