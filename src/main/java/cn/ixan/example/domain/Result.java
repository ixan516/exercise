package cn.ixan.example.domain;

import lombok.Data;

/**
 * @author stack_zhang@outlook.com
 * @date 2019年3月31日, 0031
 */
@Data
public class Result<T> {
	private String code;
	private String msg;
	private T data;
}
