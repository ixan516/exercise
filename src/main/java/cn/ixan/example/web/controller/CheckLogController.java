package cn.ixan.example.web.controller;

import cn.ixan.example.domain.vo.CheckLogVO;
import cn.ixan.example.service.CheckLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author stack_zhang@outlook.com
 * @date 2019年3月22日, 0022
 */
@RestController
public class CheckLogController {
	@Autowired
	private CheckLogService checkLogService;

	@GetMapping("/list")
	public List<CheckLogVO> getList(){
		return checkLogService.getList();
	}
}
