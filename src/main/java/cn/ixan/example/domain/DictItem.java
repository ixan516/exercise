package cn.ixan.example.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 字典类型条目表
 * @author stack_zhang@outlook.com
 * @date 2019年3月31日, 0031
 */
@ApiModel(value = "字典类型条目表")
@Data
@Table(name = "dict_item")
@ToString
public class DictItem implements Serializable {
	/**
	 * 主键
	 */
	@Id
	@ApiModelProperty(value = "主键",name = "主键")
	private String id;
	/**
	 * 序号
	 */
	@Column(name = "sort")
	@ApiModelProperty(value = "主键",name = "主键")
	private String sort;
	/**
	 * 字典内容
	 */
	@Column(name = "text")
	@ApiModelProperty(value = "字典内容",name = "字典内容")
	private String text;
	/**
	 * 值
	 */
	@Column(name = "value")
	@ApiModelProperty(value = "值",name = "值")
	private String value;
	/**
	 * 类型Id
	 */
	@Column(name = "type_id")
	@ApiModelProperty(value = "类型Id",name = "类型Id")
	private String typeId;

}
