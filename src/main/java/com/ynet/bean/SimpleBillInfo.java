package com.ynet.bean;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * @author shenhc
 *
 */
public class SimpleBillInfo {
	//微信头像url
	private  String touXiang;
	
	//账单的ID
	private Long billId;
	
	// 签入信息
	private String verifyId;
	
	// 签入信息
	private String verifyName;
	
	// 支付方式
	private String payWay;
	
	
	private String openid;
	
	// 金额（可能为实付金额，或账单金额）
	private BigDecimal payAmount;

	private Date paymentDate;
	
	private String verifyOrgName;//
	
	private String termType;
	
	private Integer paySeqNo;
	
	//手续费
	private BigDecimal payFee;

	public SimpleBillInfo(Long billId, String verifyId,
			BigDecimal payAmount,String verifyName,BigDecimal payedAmount) {
		this.billId = billId;
		this.verifyId = verifyId;
		if(payedAmount==null){
			payedAmount = BigDecimal.ZERO;
		}
		this.payAmount = payAmount.subtract(payedAmount);
		this.verifyName = verifyName;
	}
	
	public SimpleBillInfo(Long billId, String verifyId,
			BigDecimal payAmount,String verifyName,BigDecimal payedAmount,Integer paySeqNo) {
		this.billId = billId;
		this.verifyId = verifyId;
		if(payedAmount==null){
			payedAmount = BigDecimal.ZERO;
		}
		this.payAmount = payAmount.subtract(payedAmount);
		this.verifyName = verifyName;
		this.paySeqNo = paySeqNo;
	}
	
	public SimpleBillInfo(Long billId, String verifyId,
			BigDecimal payAmount,String verifyName) {
		this.billId = billId;
		this.verifyId = verifyId;
		this.payAmount = payAmount;
		this.verifyName = verifyName;
	}
	
	/**
	 * 用于 封装 已交的账单信息
	 * @param touXiang
	 * @param billId
	 * @param verifyId
	 * @param payAmount
	 * @param paymentDate
	 */
	public SimpleBillInfo(Long billId, String verifyId,
			BigDecimal payAmount, Date paymentDate,String verifyName,String payWay,String openid,String termType) {
		this.billId = billId;
		this.verifyId = verifyId;
		this.payAmount = payAmount;
		this.paymentDate = paymentDate;
		this.verifyName = verifyName;
		this.payWay = payWay;
		this.openid = openid;
		this.termType = termType;
	}
	/**
	 * 用于 封装 已交的账单信息(带有手续费)
	 * @param touXiang
	 * @param billId
	 * @param verifyId
	 * @param payAmount
	 * @param paymentDate
	 */
	public SimpleBillInfo(Long billId, String verifyId,
			BigDecimal payAmount, Date paymentDate,String verifyName,String payWay,String openid,String termType,BigDecimal payFee) {
		this.billId = billId;
		this.verifyId = verifyId;
		this.payAmount = payAmount;
		this.paymentDate = paymentDate;
		this.verifyName = verifyName;
		this.payWay = payWay;
		this.openid = openid;
		this.termType = termType;
		this.payFee = payFee;
	}
	
	public SimpleBillInfo(Long billId, String verifyId,
			BigDecimal payAmount, Date paymentDate,String verifyName,String payWay,String openid) {
		this.billId = billId;
		this.verifyId = verifyId;
		this.payAmount = payAmount;
		this.paymentDate = paymentDate;
		this.verifyName = verifyName;
		this.payWay = payWay;
		this.openid = openid;
	}
	
	public SimpleBillInfo(Long billId, String verifyId,
			BigDecimal payAmount, Date paymentDate,String verifyName,String payWay,String openid,BigDecimal payFee) {
		this.billId = billId;
		this.verifyId = verifyId;
		this.payAmount = payAmount;
		this.paymentDate = paymentDate;
		this.verifyName = verifyName;
		this.payWay = payWay;
		this.openid = openid;
		this.payFee = payFee;
	}

	public String getTouXiang() {
		return touXiang;
	}

	public void setTouXiang(String touXiang) {
		this.touXiang = touXiang;
	}

	public Long getBillId() {
		return billId;
	}

	public void setBillId(Long billId) {
		this.billId = billId;
	}

	public String getVerifyId() {
		return verifyId;
	}

	public void setVerifyId(String verifyId) {
		this.verifyId = verifyId;
	}

	public BigDecimal getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(BigDecimal payAmount) {
		this.payAmount = payAmount;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getVerifyOrgName() {
		return verifyOrgName;
	}

	public void setVerifyOrgName(String verifyOrgName) {
		this.verifyOrgName = verifyOrgName;
	}

	public String getVerifyName() {
		return verifyName;
	}

	public void setVerifyName(String verifyName) {
		this.verifyName = verifyName;
	}

	public String getPayWay() {
		return payWay;
	}

	public void setPayWay(String payWay) {
		this.payWay = payWay;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getTermType() {
		return termType;
	}

	public void setTermType(String termType) {
		this.termType = termType;
	}

	public Integer getPaySeqNo() {
		return paySeqNo;
	}

	public void setPaySeqNo(Integer paySeqNo) {
		this.paySeqNo = paySeqNo;
	}

	public BigDecimal getPayFee() {
		return payFee;
	}

	public void setPayFee(BigDecimal payFee) {
		this.payFee = payFee;
	}
}
