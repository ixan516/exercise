package cn.ixan.example.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author stack_zhang@outlook.com
 * @date 2019年3月31日, 0031
 */
@Data
public class User implements Serializable{
	private Long id;
	private String name;
	private Integer age;
}
