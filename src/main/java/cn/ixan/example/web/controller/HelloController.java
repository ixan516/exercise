package cn.ixan.example.web.controller;

import cn.ixan.example.web.exception.MyException;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author stack_zhang@outlook.com
 * @date 2019年3月28日, 0028
 */
@Api(value = "测试")
@Controller
public class HelloController {

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/")
	public String system() {
		return "index";
	}

	@GetMapping("/hello")
	public String toHello() {
		return "hello";
	}

	@GetMapping("/test")
	@ResponseBody
	public String hello() {
		return "hello,World!";
	}

	@GetMapping("/init")
	@ResponseBody
	public String init() {
		throw new MyException("Not Found!");
	}
}
