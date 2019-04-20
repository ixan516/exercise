package cn.ixan.example.domain;

/**
 * @author stack_zhang@outlook.com
 * @date 2019年3月11日, 0011
 */

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Score {
	private String subject;
	private Integer score;
}
