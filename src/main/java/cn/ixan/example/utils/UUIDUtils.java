package cn.ixan.example.utils;

import java.util.UUID;

/**
 * @author stack_zhang@outlook.com
 * @date 2019年3月21日, 0021
 */
public class UUIDUtils {
	private UUIDUtils() {
	}

	public static String uuid(){
		return UUID.randomUUID().toString().toLowerCase();
	}

	public static void main(String[] args) {
		System.out.println(uuid());
	}
}
