package com.ynet.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * 
 * <pre>
 * 商户类型定义实体
 * </pre>
 *
 * @author zhoujiagen
 *
 */
@SuppressWarnings("serial")
@Comment("商户类型定义表")
@Entity
@Data
@Table(name = "MCH_TYPE")
public class MerchantType{
	
	/**
	 * 自动增长的ID
	 * 
	 * 支持MySQL，不支持Oracle
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "BIGINT(10)")
	protected Long id;

	@Comment("类型名称")
	@Column(name = "NAME", length = 30, nullable = false)
	private String name;

	@Comment("备注")
	@Column(name = "COMMENT", length = 255)
	private String comment;
	
	@Comment("行业类型，系统定义常量 1:教育;2:物业;3:社保;4:企事业")
	@Column(name = "INDUSTRY_TYPE_ID", columnDefinition = "TINYINT", nullable = false)
	private Integer industryTypeId;
	
	@Comment("类型名称")
	@Column(name = "INDUSTRY_TYPE_NAME", length = 30, nullable = false)
	private String industryTypeName;
	
	@Comment("行业")
	@Column(name = "TRADE", length = 255)
	private Integer trade;

	public MerchantType() {}

}
