package com.ynet.pojo;

import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.Data;


/**
 * 
 * <pre>
 * 收费项目实体定义
 * </pre>
 *
 * @author guoch
 *
 */
@Comment("收费类别")
@Entity
@Data
@Table(name = "BILL_TYPE")
public class BillType {
	private static final long serialVersionUID = 1L;

	/**
	 * 自动增长的ID
	 * 
	 * 支持MySQL，不支持Oracle
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "BIGINT(10)")
	protected Long id;
	@Comment("商户ID")
	@Column(name = "MCH_ID", columnDefinition = "INT(10)", nullable = false)
	private Long mchId;

	@Comment("类型名称")
	@Column(length = 30, nullable = false)
	private String name;

	@Comment("类型描述")
	@Column(name = "description", length = 255, nullable = false)
	private String describe;

	public enum State {
		/** 未启用 */
		NOTENABLED,
		/** 已启用 */
		ALREADYENABLED,
		/** 已停用 */
		DISABLE
	}

	@Comment("状态：0未启用, 1已启用, 2已停用")
	@Enumerated(EnumType.ORDINAL)
	@Column(columnDefinition = "TINYINT", nullable = false)
	private State state;

	@Comment("修改时间")
	@Column(name = "MODIFY_AT")//, nullable = false
	private Long modifyAt;

	@Comment("修改人帐号")
	@Column(name = "MODIFY_USER", length = 50)//, nullable = false
	private String modifyUser;

	@Comment("发布时间")
	@Column(name = "OPEN_AT")
	private Long openAt;

	@Comment("停用时间")
	@Column(name = "CLOSE_AT")
	private Long colseAt;

	@Comment("最高限额")
	@Column(name = "AMOUNT_LIMIT",  columnDefinition = "decimal(10,2)", scale=2,nullable = false)
	private BigDecimal amountLimit;

	@Comment("详细配置")
	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(columnDefinition = "TEXT", nullable = false)
	private String detailedConfig;
	
	@Comment("收费模式 :0：账单模式 1：订单模式")
	@Column(name = "PAY_MODE",columnDefinition = "TINYINT")
	private Integer payMode=0;

	// =================constructor=================

	public BillType() {}

	public BillType(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public BillType(Long id, String name,Integer payMode) {
		this.id = id;
		this.name = name;
		this.payMode = payMode;
	}
	
}
