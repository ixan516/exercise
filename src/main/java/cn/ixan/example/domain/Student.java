package cn.ixan.example.domain;

import lombok.Data;

import java.util.List;

/**
 * @author stack_zhang@outlook.com
 * @date 2019年3月11日, 0011
 */
@Data
public class Student {
	private String userName;
	private List<Score> scoreList;
}
