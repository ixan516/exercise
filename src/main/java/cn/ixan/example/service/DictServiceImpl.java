package cn.ixan.example.service;

import cn.ixan.example.domain.DictItem;
import cn.ixan.example.domain.DictType;
import cn.ixan.example.mapper.DictItemMapper;
import cn.ixan.example.mapper.DictTypeMapper;
import cn.ixan.example.web.exception.MyException;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author stack_zhang@outlook.com
 * @date 2019年3月31日, 0031
 */
@Service
@Slf4j
public class DictServiceImpl implements DictService {
	@Autowired
	private DictTypeMapper dictTypeMapper;
	@Autowired
	private DictItemMapper dictItemMapper;
	@Autowired
	private CacheManager cacheManager;

	@Override
	public String addType(DictType dictType) {
		dictTypeMapper.insert(dictType);
		return dictType.getId();
	}

	@Override
	public List<DictType> getDictTypeList() {
		List<DictType> dictTypeList = dictTypeMapper.selectAll();
		return dictTypeList;
	}

	@Override
	public String updateType(DictType dictType) {
		DictType select = dictTypeMapper.selectByPrimaryKey(dictType.getId());
		if (null == select) {
			throw new MyException("没有查询到字典分类记录");
		}
		select.setCode(dictType.getCode());
		select.setStatus(dictType.getStatus());
		select.setText(dictType.getText());
		dictTypeMapper.updateByPrimaryKey(select);
		return select.getId();
	}

	@Override
	public DictType getDictType(String code) {
		Example example = new Example(DictType.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("code", code);
		List<DictType> dictTypeList = dictTypeMapper.selectByExample(example);
		if (CollectionUtils.isEmpty(dictTypeList)) {
			throw new MyException("没有查询到指定编码的数据字典分类记录");
		}
		return dictTypeList.get(0);
	}

	@CacheEvict(cacheNames = "dictCache")
	@Override
	public String addItem(DictItem dictItem) {
		dictItemMapper.insert(dictItem);
		return dictItem.getId();
	}

	@Cacheable(cacheNames = "dictCache", key = "#typeId")
	@Override
	public List<DictItem> getItemByTypeId(String typeId) {
		Example example = new Example(DictItem.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("typeId", typeId);
		List<DictItem> dictItemList = dictItemMapper.selectByExample(example);
		if (CollectionUtils.isEmpty(dictItemList)) {
			dictItemList = Lists.newArrayList();
		}
		return dictItemList;
	}

	@CacheEvict(cacheNames = "dictCache")
	@Override
	public String updateItem(DictItem dictItem) {
		DictItem select = dictItemMapper.selectByPrimaryKey(dictItem.getId());
		if (null == select) {
			throw new MyException("没有查询到字典记录");
		}
		select.setSort(dictItem.getSort());
		select.setText(dictItem.getText());
		select.setValue(dictItem.getValue());
		dictItemMapper.updateByPrimaryKey(select);
		return select.getId();
	}
}
