package cn.ixan.example.web.controller;

import cn.ixan.example.domain.DictItem;
import cn.ixan.example.domain.DictType;
import cn.ixan.example.domain.Result;
import cn.ixan.example.service.DictService;
import cn.ixan.example.utils.ResultGenerate;
import cn.ixan.example.utils.UUIDUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author stack_zhang@outlook.com
 * @date 2019年3月31日, 0031
 */
@Api(value = "数据字典")
@RestController
@RequestMapping(value = "/dict")
public class DictController {
	@Autowired
	private DictService dictService;
	@Autowired
	private CacheManager cacheManager;

	@ApiOperation(value = "添加字典分类")
	@PostMapping("/type")
	public Result<String> addType(@RequestBody DictType dictType){
		dictType.setId(UUIDUtils.uuid());
		String type = dictService.addType(dictType);
		return ResultGenerate.generateSuccess(type);
	}

	@ApiOperation(value = "获取所有字典分类")
	@GetMapping("/type")
	public Result<List<DictType>> getDictTypeList(){
		List<DictType> dictTypeList = dictService.getDictTypeList();
		return ResultGenerate.generateSuccess(dictTypeList);
	}

	@ApiOperation(value = "获取字典分类根据编码")
	@GetMapping("/type/{code}")
	public Result<DictType> getDictType(@PathVariable("code") String code){
		DictType dictType = dictService.getDictType(code);
		return ResultGenerate.generateSuccess(dictType);
	}

	@ApiOperation(value = "修改字典分类")
	@PutMapping("/type")
	public Result<String> updateType(@RequestBody DictType dictType){
		String type = dictService.updateType(dictType);
		return ResultGenerate.generateSuccess(type);
	}

	@ApiOperation("添加字段记录")
	@PostMapping("/item")
	public Result<String> addItem(@RequestBody DictItem dictItem){
		dictItem.setId(UUIDUtils.uuid());
		String type = dictService.addItem(dictItem);
		return ResultGenerate.generateSuccess(type);
	}

	@ApiOperation("修改字段记录")
	@PutMapping("/item")
	public Result<String> updateItem(@RequestBody DictItem dictItem){
		String type = dictService.updateItem(dictItem);
		return ResultGenerate.generateSuccess(type);
	}

	@ApiOperation("获取某一分类下的字段记录")
	@GetMapping("/item/{typeId}")
	public Result<List<DictItem>> getItemByTypeId(@PathVariable("typeId") String typeId){
		List<DictItem> dictItemList = dictService.getItemByTypeId(typeId);
		return ResultGenerate.generateSuccess(dictItemList);
	}
}
