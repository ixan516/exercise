package cn.ixan.example.domain.vo;

import cn.ixan.example.domain.CheckLog;

/**
 * @author stack_zhang@outlook.com
 * @date 2019年3月22日, 0022
 */
public class CheckLogVO extends CheckLog{
	private String type;

	public String getType() {
		return this.getCheckType().getText();
	}

	public void setType(String type) {
		this.type = type;
	}
}
