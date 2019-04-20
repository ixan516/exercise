package cn.ixan.example.service;

import cn.ixan.example.domain.DictItem;
import cn.ixan.example.domain.DictType;

import java.util.List;

/**
 * @author stack_zhang@outlook.com
 * @date 2019年3月31日, 0031
 */
public interface DictService {
	String addType(DictType dictType);

	List<DictType> getDictTypeList();

	String updateType(DictType dictType);

	DictType getDictType(String code);

	String addItem(DictItem dictItem);

	List<DictItem> getItemByTypeId(String typeId);

	String updateItem(DictItem dictItem);
}
