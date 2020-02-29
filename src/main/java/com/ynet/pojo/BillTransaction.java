package com.ynet.pojo;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

/**
 * 
 * <pre>
 * 帐单交易记录定义实体
 * </pre>
 *
 * @author zhoujiagen
 *
 */
@Comment("账单支付交易记录表")
@Entity
@Data
@Table(name = "BILL_TRANSACTION")
public class BillTransaction {
	
	/**
	 * 自动增长的ID
	 * 
	 * 支持MySQL，不支持Oracle
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "BIGINT(10)")
	protected Long id;

	@Comment("帐单ID")
	@Column(name = "BILL_ID", columnDefinition = "BIGINT(10)", nullable = false)
	private Long billId;

	@Comment("商户ID")
	@Column(name = "MCH_ID", columnDefinition = "INT", nullable = false)
	private Long mchId;

	@Comment("公众号用户ID")
	@Column(name = "OPEN_ID", columnDefinition = "CHAR(40)", nullable = false)
	private String  openId;
	
	@Comment("交易用户ID")
	@Column(name = "PAYER_ID", columnDefinition = "CHAR(40)", nullable = false)
	private String  payerId;

	@Comment("订单号, 对应微信支付out_trade_no，应用自己生成")
	@Column(name = "ORDER_NO", columnDefinition = "CHAR(32)", nullable = false)//20
	private String orderNo;

	@Comment("交易订单号，微信支付结果通知中的transaction_id")
	@Column(name = "TRX_ID", length = 40)//, nullable = false
	private String trxId;

	@Comment("交易金额")
	@Column(name = "TRX_AMOUNT",  columnDefinition = "decimal(10,2)", scale=2, nullable = false)
	private BigDecimal trxAmount;
	
	@Comment("交易完成时间(微信支付返回)")
	@Column(name = "TIME_END", columnDefinition = "char(32)")
	private String timeEnd;
	
	public enum TrxType {
		ORDER, REFUND
	}

	@Comment("交易类型")
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "TRX_TYPE", columnDefinition = "TINYINT")
	private BillTransaction.TrxType trxType;

	public enum TradeType {
		JSAPI, NATIVE,APP,MICROPAY
	}

	@Comment("支付类型")
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "TRADE_TYPE", columnDefinition = "TINYINT")
	private BillTransaction.TradeType tradeType;

	@Comment("交易结果：0支付中, 1失败，2.成功，3未支付,4退款")
	@Column(name = "RESULT_CODE", columnDefinition = "SMALLINT")
	private int resultCode;

	@Comment("开始时间")
	@Column(name = "START_AT", columnDefinition = "BIGINT")
	private Long startAt;

	@Comment("结束时间")
	@Column(name = "END_AT", columnDefinition = "BIGINT")//nullable = false
	private Long endAt;
	
	@Comment("预支付id")
	@Column(name = "PRE_PAY_ID", columnDefinition = "CHAR(40)")//int改为插入
	private String prePayId;
	
	@Comment("下单用户ip")
	@Column(name = "IP",length =32 ,nullable = true)
	private String ip;
	
	@Comment("流水有效标识 同一个用户同一个订单，只有一笔流水有效 --0有效1无效")
	@Column(name = "VALID_FLAG",columnDefinition = "TINYINT" )
	private int validFlag=0;
	
	@Comment("对账状态，0待对账1对账成功2对账失败3非对账")
	@Column(name = "VERIFYSTATE",columnDefinition = "TINYINT")
	private int verifyState = 0;
	
	@Comment("商户退款订单号, 对应微信支付out_trade_no，应用自己生成")
	@Column(name = "REFUNDORDERNO", columnDefinition = "CHAR(40)")//20
	private String refundOrderNo;

	@Comment("微信退款交易订单号，微信支付结果通知中的transaction_id")
	@Column(name = "REFUNDTRXID", length = 40)//, nullable = false
	private String refundTrxId;
	
	@Comment("退款状态")
	@Column(name = "REFUNDSTATE", length = 10)//, nullable = false
	private String refundState;
	
	@Comment("退款金额")
	@Column(name = "REFUNDFEE", columnDefinition = "decimal(10,2)",scale=2)
	private BigDecimal refundFee = BigDecimal.ZERO;
	
	@Comment("代金券或立减优惠退款金额")
	@Column(name = "COUPONFEEREFUND",columnDefinition = "decimal(10,2)",scale=2)
	private BigDecimal couponFeeRefund = BigDecimal.ZERO;
	
	@Comment("退款类型")
	@Column(name = "REFUNDTYPE",columnDefinition = "CHAR(10)")
	private  String refundType; 
	
	@Comment("交易码")
	@Column(name = "RESPONSE_CODE", length = 16)//, nullable = false
	private String responseCode;
	
	/** 关联账单记录实体 */
	@Comment("账单记录")
    @ManyToOne
    @JoinColumn(name = "BILL_ID", nullable = false,insertable = false, updatable = false)// insertable = false, updatable = false
    private Bill bill; 
	
	/** 关联商户记录实体 */
	@Comment("商户记录实体")
    @ManyToOne
    @JoinColumn(name = "MCH_ID", nullable = false,insertable = false, updatable = false)
    private Merchant merchant;

	// =================constructor=================

	public BillTransaction() {}

	// =================getter/setter=================

	public String getPrePayId() {
		return prePayId;
	}

	public void setPrePayId(String prePayId) {
		this.prePayId = prePayId;
	}

	public Long getBillId() {
		return billId;
	}

	public void setBillId(Long billId) {
		this.billId = billId;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Long getMchId() {
		return mchId;
	}

	public void setMchId(Long mchId) {
		this.mchId = mchId;
	}



	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getTrxId() {
		return trxId;
	}

	public void setTrxId(String trxId) {
		this.trxId = trxId;
	}

	public BigDecimal getTrxAmount() {
		return trxAmount;
	}

	public void setTrxAmount(BigDecimal trxAmount) {
		this.trxAmount = trxAmount;
	}

	public BillTransaction.TrxType getTrxType() {
		return trxType;
	}

	public void setTrxType(BillTransaction.TrxType trxType) {
		this.trxType = trxType;
	}

	public BillTransaction.TradeType getTradeType() {
		return tradeType;
	}

	public void setTradeType(BillTransaction.TradeType tradeType) {
		this.tradeType = tradeType;
	}

	public int getResultCode() {
		return resultCode;
	}

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}

	public Long getStartAt() {
		return startAt;
	}

	public void setStartAt(Long startAt) {
		this.startAt = startAt;
	}

	public Long getEndAt() {
		return endAt;
	}

	public void setEndAt(Long endAt) {
		this.endAt = endAt;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public int getValidFlag() {
		return validFlag;
	}

	public void setValidFlag(int validFlag) {
		this.validFlag = validFlag;
	}

	public String getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(String timeEnd) {
		this.timeEnd = timeEnd;
	}

	public int getVerifyState() {
		return verifyState;
	}

	public void setVerifyState(int verifyState) {
		this.verifyState = verifyState;
	}

	public String getRefundOrderNo() {
		return refundOrderNo;
	}

	public void setRefundOrderNo(String refundOrderNo) {
		this.refundOrderNo = refundOrderNo;
	}

	public String getRefundTrxId() {
		return refundTrxId;
	}

	public void setRefundTrxId(String refundTrxId) {
		this.refundTrxId = refundTrxId;
	}

	public String getRefundState() {
		return refundState;
	}

	public void setRefundState(String refundState) {
		this.refundState = refundState;
	}

	public BigDecimal getRefundFee() {
		return refundFee;
	}

	public void setRefundFee(BigDecimal refundFee) {
		this.refundFee = refundFee;
	}

	public BigDecimal getCouponFeeRefund() {
		return couponFeeRefund;
	}

	public void setCouponFeeRefund(BigDecimal couponFeeRefund) {
		this.couponFeeRefund = couponFeeRefund;
	}

	public String getRefundType() {
		return refundType;
	}

	public void setRefundType(String refundType) {
		this.refundType = refundType;
	}

	public String getPayerId() {
		return payerId;
	}

	public void setPayerId(String payerId) {
		this.payerId = payerId;
	}

	public Merchant getMerchant() {
		return merchant;
	}

	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}
}
