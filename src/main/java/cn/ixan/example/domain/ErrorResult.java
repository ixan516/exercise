package cn.ixan.example.domain;

import lombok.Data;

/**
 * @author stack_zhang@outlook.com
 * @date 2019年3月30日, 0030
 */
@Data
public class ErrorResult<T> {
	public static final Integer OK = 0;
	public static final Integer ERROR = 100;
	private Integer code;
	private String message;
	private String url;
	private T data;
}
