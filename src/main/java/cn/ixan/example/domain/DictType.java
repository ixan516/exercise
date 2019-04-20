package cn.ixan.example.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 字典类型表
 * @author stack_zhang@outlook.com
 * @date 2019年3月31日, 0031
 */
@ApiModel(value = "字典类型表")
@Data
@Table(name = "dict_type")
public class DictType implements Serializable{
	/**
	 * 主键
	 */
	@ApiModelProperty(value = "主键",name = "主键")
	@Id
	private String id;
	/**
	 * 编码
	 */
	@Column(name = "code")
	@ApiModelProperty(value = "编码",name = "编码")
	private String code;
	/**
	 * 状态
	 */
	@Column(name = "status")
	@ApiModelProperty(value = "状态",name = "状态")
	private String status;
	/**
	 * 字典类型名称
	 */
	@Column(name = "text")
	@ApiModelProperty(value = "字典类型名称",name = "字典类型名称")
	private String text;
}
