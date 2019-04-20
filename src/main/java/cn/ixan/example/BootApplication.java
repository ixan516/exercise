package cn.ixan.example;

import cn.ixan.example.configuration.StartupRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

/**
 * @author stack_zhang@outlook.com
 * @date 2019年3月10日, 0010
 */
@tk.mybatis.spring.annotation.MapperScan(basePackages = "cn.ixan.example.mapper")
@SpringBootApplication
@EnableCaching
public class BootApplication {

	public static void main(String[] args) {
		//屏蔽命令行属性的设置
		SpringApplication springApplication = new SpringApplication(BootApplication.class);
		springApplication.setAddCommandLineProperties(false);
		springApplication.run(args);
	}

	@Bean
	public StartupRunner startupRunner(){
		return new StartupRunner();
	}

}
