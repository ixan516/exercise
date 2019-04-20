package cn.ixan.example.domain.enums;

import java.util.HashMap;

/**
 * @author stack_zhang@outlook.com
 * @date 2019年3月21日, 0021
 */
public enum CheckType {
	NO_PASS(0,"未通过"),
	PASS(1,"通过"),
	;
	private int key;
	private String text;

	CheckType(int key, String text) {
		this.key = key;
		this.text = text;
	}

	public int getKey() {
		return key;
	}

	public String getText() {
		return text;
	}
	private static HashMap<Integer,CheckType> map = new HashMap<>();
	static {
		for(CheckType d:CheckType.values()){
			map.put(d.key,d);
		}
	}

	public static CheckType parse(Integer index){
		if(map.containsKey(index)){
			return map.get(index);
		}
		return null;
	}
}
