package com.ynet.bean;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 
 * <pre>
 * 缴费活动帐单汇总信息封装实体
 * </pre>
 *
 * @author zhoujiagen
 *
 */
public class BillActivityBillSummary implements Serializable {
	private static final long serialVersionUID = 1L;

	/** 缴费活动ID */
	private Long billActivityId;
	/** 帐单总数 */
	private Long billTotalNumber;
	/** 帐单总金额 */
//	private int billTotalAmout;
	private BigDecimal billTotalAmout;
	/** 缴费总数 */
	private Long billPayCount;
	/** 缴费总额 */
	private BigDecimal billPayAmout;
	private Long orgId;
	private Long mchtId;
	
	private Long subItemId = 0l;
	
	private String orgFullName;
	private Integer orgSeqnum;
	private Integer orgLevel;
	
	private Long billNoPayCount;
	private BigDecimal billNoPayAmout;

	// =================getter/setter=================
	
	/**============================统计sql,开始====================================*/
	/**
	 * 正常账单统计使用
	 * @param billActivityId
	 * @param billPayCount
	 * @param billPayAmout
	 */
	public BillActivityBillSummary(Long orgId,Long billPayCount,BigDecimal billPayAmout) {
		this.orgId = orgId;
		this.billPayCount = billPayCount;
		this.billPayAmout = billPayAmout;
	}
	
	/**
	 * 正常账单统计使用
	 * @param billActivityId
	 * @param billPayCount
	 * @param billPayAmout
	 */
	public BillActivityBillSummary(Long orgId,Long billNoPayCount) {
		this.orgId = orgId;
		this.billNoPayCount = billNoPayCount;
	}
	
	
	/**
	 * 子项账单统计使用
	 * @param billActivityId
	 * @param billPayCount
	 * @param billPayAmout
	 */
	public BillActivityBillSummary(Long orgId,Long billPayCount,BigDecimal billPayAmout,Long subItemId) {
		this.orgId = orgId;
		this.billPayCount = billPayCount;
		this.billPayAmout = billPayAmout;
		this.subItemId = subItemId;
	}
	
	/**
	 * 子项账单统计使用
	 * @param billActivityId
	 * @param billPayCount
	 * @param billPayAmout
	 */
	public BillActivityBillSummary(Long orgId,Long billNoPayCount,Long subItemId) {
		this.orgId = orgId;
		this.billNoPayCount = billNoPayCount;
	}
	/**============================统计sql,结束====================================*/
	

	public Long getBillActivityId() {
		return billActivityId;
	}

	public void setBillActivityId(Long billActivityId) {
		this.billActivityId = billActivityId;
	}

	public Long getBillTotalNumber() {
		return billTotalNumber;
	}

	public void setBillTotalNumber(Long billTotalNumber) {
		this.billTotalNumber = billTotalNumber;
	}

	public BigDecimal getBillTotalAmout() {
		return billTotalAmout;
	}

	public void setBillTotalAmout(BigDecimal billTotalAmout) {
		this.billTotalAmout = billTotalAmout;
	}

	public Long getBillPayCount() {
		return billPayCount;
	}

	public void setBillPayCount(Long billPayCount) {
		this.billPayCount = billPayCount;
	}

	public BigDecimal getBillPayAmout() {
		return billPayAmout;
	}

	public void setBillPayAmout(BigDecimal billPayAmout) {
		this.billPayAmout = billPayAmout;
	}

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public Long getMchtId() {
		return mchtId;
	}

	public void setMchtId(Long mchtId) {
		this.mchtId = mchtId;
	}

	public String getOrgFullName() {
		return orgFullName;
	}

	public void setOrgFullName(String orgFullName) {
		this.orgFullName = orgFullName;
	}

	public Integer getOrgSeqnum() {
		return orgSeqnum;
	}

	public void setOrgSeqnum(Integer orgSeqnum) {
		this.orgSeqnum = orgSeqnum;
	}

	public Integer getOrgLevel() {
		return orgLevel;
	}

	public void setOrgLevel(Integer orgLevel) {
		this.orgLevel = orgLevel;
	}

	public Long getBillNoPayCount() {
		return billNoPayCount;
	}

	public void setBillNoPayCount(Long billNoPayCount) {
		this.billNoPayCount = billNoPayCount;
	}

	public BigDecimal getBillNoPayAmout() {
		return billNoPayAmout;
	}

	public void setBillNoPayAmout(BigDecimal billNoPayAmout) {
		this.billNoPayAmout = billNoPayAmout;
	}

	public Long getSubItemId() {
		return subItemId;
	}

	public void setSubItemId(Long subItemId) {
		this.subItemId = subItemId;
	}
	

}
