package cn.ixan.example.domain;

import cn.ixan.example.domain.enums.CheckType;
import lombok.Data;

import java.io.Serializable;

/**
 * @author stack_zhang@outlook.com
 * @date 2019年3月21日, 0021
 */
@Data
public class CheckLog implements Serializable{
	private String id;
	private CheckType checkType;
}
