package cn.ixan.example.service;

import cn.ixan.example.domain.CheckLog;
import cn.ixan.example.domain.vo.CheckLogVO;
import cn.ixan.example.mapper.CheckLogMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author stack_zhang@outlook.com
 * @date 2019年3月22日, 0022
 */
@Service
@Slf4j
public class CheckLogServiceImpl implements CheckLogService {
	@Autowired
	private CheckLogMapper checkLogMapper;

	@Override
	public List<CheckLogVO> getList() {
		List<CheckLogVO> list = new ArrayList<>();
		List<CheckLog> checkLogs = checkLogMapper.selectAll();
		if (!CollectionUtils.isEmpty(checkLogs)) {
			for (CheckLog checkLog : checkLogs) {
				CheckLogVO checkLogVO = new CheckLogVO();
				BeanUtils.copyProperties(checkLog, checkLogVO);
				list.add(checkLogVO);
			}
		}
		return list;
	}
}
