package com.ynet.pojo;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;


/**
 * 
 * <pre>
 * 机构账单分项统计表
 * 
 * 商户均存在一个对应于商户名称的机构作为父机构
 * </pre>
 *
 * @author zhoujiagen
 *
 */
@SuppressWarnings("serial")
@Comment("收费活动机构账单分项统计表")
@Entity
@Data
@Table(name = "BILL_ACTIVITY_STATISTICS")
public class BillActivityStatistics {

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
	
	@Comment("机构ID")
	@Column(name = "ORG_ID", columnDefinition = "INT")
	private Long orgId;

	@Comment("商户ID")
	@Column(name = "MCH_ID")
	private Long mchtId;
	
	@Comment("缴费活动")
    @ManyToOne
    @JoinColumn(name = "ACTIVITY_ID", nullable = true, insertable = false, updatable = false)
    private BillActivity billActivity; 
	
	@Comment("活动ID")
	@Column(name = "ACTIVITY_ID", columnDefinition = "INT")
	private Long activityId;
	
	@Comment("帐单总数")
	@Column(name = "BILL_COUNT", nullable = false)
	private int billCount;

	@Comment("帐单总额")
	@Column(name = "BILL_TOTAL", columnDefinition = "decimal(15,2)", scale=2, nullable = false)
	private BigDecimal billTotal=BigDecimal.ZERO;

	@Comment("缴费总数")
	@Column(name = "PAY_COUNT", nullable = false)
	private int payCount;

	@Comment("缴费总额")
	@Column(name = "PAY_TOTAL", columnDefinition = "decimal(15,2)", scale=2, nullable = false)
	private BigDecimal payTotal=BigDecimal.ZERO;

	@Comment("1活动发布前：帐单最后更新时间; 2活动发布后：最后交易时间")
	@Column(name = "LAST_UPDATE_AT", columnDefinition = "BIGINT", nullable = false)
	private Long lastUpdateAt;
	
	@Comment("保存对应的机构全称，如“一年级2班”，即上级机构名称+本级机构名称")
	private String orgFullname;
	
	@Comment("机构序列号") 
	private Integer  orgSeqnum;
	
	@Comment("机构层级")
	private Integer orgLevel;
	
	@Comment("未缴总数")
	private int noPayCount=0;
	
	@Comment("未缴总额")
	@Column(name = "NO_PAY_TOTAL", columnDefinition = "decimal(15,2)", scale=2, nullable = false)
	private BigDecimal noPayTotal=BigDecimal.ZERO;
	
	@Comment("账单支付类型 : 0-线上支付，1-补登支付")
	@Column(name = "pay_state_type", columnDefinition = "tinyint",  nullable = false)
	private Integer payStateType=0;
	
	@Comment("子项ID")
	@Column(name = "SUBITEM_ID", columnDefinition = "INT(10)", nullable = false)
	private Long subitemId=0L;
	
	@Comment("退款总数")
	private int refundCount=0;
	
	@Comment("退款总额")
	@Column(name = "refund_amount", columnDefinition = "decimal(15,2)", scale=2, nullable = false)
	private BigDecimal refundAmount=BigDecimal.ZERO;
	
	@Comment("手续费总额")
	@Column(name = "fee_amount", columnDefinition = "decimal(15,2)", scale=2, nullable = false)
	private BigDecimal feeAmount=BigDecimal.ZERO;
	
	

	// =================transient fields=================
	/** 机构名称 */
	@Transient
	private String orgName;

	// =================constructor=================

	public BillActivityStatistics() {}

	public BillActivityStatistics(Long orgId, Long mchtId, Long activityId, int billCount, BigDecimal billTotal, int payCount,
			BigDecimal payTotal, Long lastUpdateAt, String orgName) {
		this.orgId = orgId;
		this.mchtId = mchtId;
		this.activityId = activityId;
		this.billCount = billCount;
		this.billTotal = billTotal;
		this.payCount = payCount;
		this.payTotal = payTotal;
		this.lastUpdateAt = lastUpdateAt;
		this.orgName = orgName;
	}

	public BillActivityStatistics(Long id, Long orgId, Long mchtId, Long activityId, int billCount, BigDecimal billTotal, int payCount,
			BigDecimal payTotal, Long lastUpdateAt, String orgFullname,Integer  orgSeqnum,Integer orgLevel) {
		this.id = id;
		this.orgId = orgId;
		this.mchtId = mchtId;
		this.activityId = activityId;
		this.billCount = billCount;
		this.billTotal = billTotal;
		this.payCount = payCount;
		this.payTotal = payTotal;
		this.lastUpdateAt = lastUpdateAt;
		this.orgFullname = orgFullname;
		this.orgSeqnum = orgSeqnum;
		this.orgLevel = orgLevel;
	}
	
	public BillActivityStatistics(Long activityId, int billCount, BigDecimal billTotal){
		this.activityId = activityId;
		this.billCount = billCount;
		this.billTotal = billTotal;
	}
	
	public BillActivityStatistics(Long mchId,Long orgId, int billCount, BigDecimal billTotal){
		this.mchtId = mchId;
		this.orgId = orgId;
		this.billCount = billCount;
		this.billTotal = billTotal;
	}

	
	
	
}
