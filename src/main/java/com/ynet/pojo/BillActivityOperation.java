package com.ynet.pojo;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


/**
 * 【cloudbill】账单实体
 * 
 * @author guoch
 *
 */
@SuppressWarnings("serial")
@Comment("收费活动账单操作记录表")
@Entity
@Data
@Table(name = "BillActivityOperation")
public class BillActivityOperation {
	
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
	@Column(name = "MCH_ID", columnDefinition = "BIGINT", nullable = false)
	private Long mchId;

	@Comment("活动ID")
	@Column(name = "ACTIVITY_ID", columnDefinition = "BIGINT", nullable = false)
	private Long activityId;
	
	@Comment("开始时间")
	@Column(name = "BEGIN_AT", columnDefinition = "BIGINT", nullable = false)
	private Long beginAt;
	
	public enum OperType{
		IMPORT, //导入
		COPY,  //复制
		EDIT   //编辑
	}
	@Comment("操作类型")
	@Column(name = "OPER_TYPE", nullable = false)
	private BillActivityOperation.OperType operType;
	
	@Comment("操作对象")
	@Column(name = "OPER_OBJ")
	private String operObj;
	
	@Comment("新增数")
	@Column(name = "ADD_NUM", columnDefinition = "INT")
	private int addNum;
	
	@Comment("修改数")
	@Column(name = "UPDATE_NUM", columnDefinition = "INT")
	private int updateNum;
	
	@Comment("删除数")
	@Column(name = "DELETE_NUM", columnDefinition = "INT")
	private int deleteNum;
	
	@Comment("总数")
	@Column(name = "TOTAL_NUM", columnDefinition = "INT")
	private int totalNum;
	
	@Comment("总金额")
	@Column(name = "TOTAL_AMOUNT")
	private BigDecimal totalAmount;
	
	@Comment("最后统计时间")
	@Column(name = "LAST_COUNT_AT", columnDefinition = "BIGINT", nullable = false)
	private Long lastCountAt;

	
	
	
	
}
