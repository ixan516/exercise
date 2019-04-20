package cn.ixan.example.configuration;

import cn.ixan.example.domain.DictItem;
import cn.ixan.example.service.DictService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;

import java.util.List;

/**
 * @author stack_zhang@outlook.com
 * @date 2019年3月31日, 0031
 */
@Order(2)
@Slf4j
public class StartupRunner implements CommandLineRunner {
	@Autowired
	private DictService dictService;

	@Override
	public void run(String... strings) throws Exception {
		log.info("StartupRunner startup runner");
		List<DictItem> itemByTypeId = dictService.getItemByTypeId("47a7e853-b0e9-4798-9872-d831d1214258");
		for (DictItem dictItem : itemByTypeId) {
			log.info("开始遍历数据字典[{}]", dictItem);
		}
	}
}
