package cn.ixan.example.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author stack_zhang@outlook.com
 * @date 2019年3月30日, 0030
 */
@Component
public class BlogProperties {
	@Value("${com.didispace.blog.name}")
	private String name;

	@Value("${com.didispace.blog.title}")
	private String title;

	@Value("${com.didispace.blog.value}")
	private String value;
	@Value("${com.didispace.blog.number}")
	private String number;
	@Value("${com.didispace.blog.bignumber}")
	private String bignumber;
	@Value("${com.didispace.blog.test1}")
	private String test1;
	@Value("${com.didispace.blog.test2}")
	private String test2;

	public String getValue() {
		return value;
	}

	public String getNumber() {
		return number;
	}

	public String getBignumber() {
		return bignumber;
	}

	public String getTest1() {
		return test1;
	}

	public String getTest2() {
		return test2;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
