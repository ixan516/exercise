package cn.ixan.example.web.controller;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author stack_zhang@outlook.com
 * @date 2019年3月30日, 0030
 */
@Api("首页")
@Controller
public class IndexController {
	@RequestMapping("/")
	public String index(ModelMap modelMap){
		modelMap.addAttribute("host","127.0.0.1");
		return "hello";
	}
}
