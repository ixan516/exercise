package cn.ixan.test;

import cn.ixan.example.BootApplication;
import cn.ixan.example.configuration.BlogProperties;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author stack_zhang@outlook.com
 * @date 2019年3月30日, 0030
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = BootApplication.class)
public class ApplicationTest {

	@Autowired
	private BlogProperties blogProperties;

	@Test
	public void getHello(){
		Assert.assertEquals(blogProperties.getName(),"didi");
		Assert.assertEquals(blogProperties.getTitle(),"Spring Boot Learning");
	}

	@Test
	public void getRandom(){
		System.out.println("com.didispace.blog.value:"+blogProperties.getValue());
		System.out.println("com.didispace.blog.number:"+blogProperties.getNumber());
		System.out.println("com.didispace.blog.bignumber:"+blogProperties.getBignumber());
		System.out.println("com.didispace.blog.test1:"+blogProperties.getTest1());
		System.out.println("com.didispace.blog.test2:"+blogProperties.getTest2());
	}
}
