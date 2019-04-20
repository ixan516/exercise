package cn.ixan.example.domain;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @author stack_zhang@outlook.com
 * @date 2019年3月11日, 0011
 */
public enum Subject {
	MATH("数学"),
	ENGLISH("英语"),
	CHINESE("中文"),
	;
	private String subject;

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	Subject(String subject) {
		this.subject = subject;
	}

	/**
	 * 内容获取枚举
	 * @param message 内容
	 * @return Subject
	 */
	public static Subject getSubject(@NotBlank String message){
		for(Subject subject:Subject.values()){
			if(subject.getSubject().equals(message)){
				return subject;
			}
		}
		return null;
	}

	/**
	 * 序列值获取枚举
	 * @param ordinal 序列值
	 * @return Subject
	 */
	public static Subject getSubject(int ordinal){
		for(Subject subject:Subject.values()){
			if(subject.ordinal() == ordinal){
				return subject;
			}
		}
		return null;
	}
}
