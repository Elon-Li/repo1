package com.ynet.pojo;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * <p>Title: ReconciliationInfo</p>
 * <p>Description: 账单对账明细表</p>
 * @author	zhonghy
 * @date	2016年8月19日
 * @version 1.0
 */
@Comment("微信账单对账明细表")
@Entity
@Data
@Table(name = "RECONCILIATION_INFO")
public class ReconciliationInfo{
	
	/**
	 * 自动增长的ID
	 * 
	 * 支持MySQL，不支持Oracle
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "BIGINT(10)")
	protected Long id;

	/**
	 * 交易时间
	 */
	@Comment("交易时间")
	@Column(name = "TRADE_TIME", columnDefinition = "CHAR(20)")
	private String tradeTime;
	
	/**
	 * 公众账号ID
	 */
	@Comment("公众账号ID")
	@Column(name = "APP_ID", columnDefinition = "CHAR(32)")
	private String  appid;
	
	/**
	 * 微信子商户号（对应微信账单商户号）
	 */
	@Comment("微信子商户号")
	@Column(name = "WX_MCH_ID", columnDefinition = "CHAR(32)")
	private String  xmMchId;
	
	/**
	 * 特约商户号
	 */
	@Comment("特约商户号")
	@Column(name = "CONTRIBUTORS_NUM", columnDefinition = "CHAR(32)")
	private String contributorsNum;
	
	/**
	 * 设备号
	 */
	@Comment("设备号")
	@Column(name = "DEVICE_NO", columnDefinition = "CHAR(32)")
	private String deviceNo;
	
	/**
	 * 微信订单号
	 */
	@Comment("微信订单号")
	@Column(name = "TRX_ID", columnDefinition = "CHAR(40)")
	private String trxId;
	
	/**
	 * 商户订单号
	 */
	@Comment("商户订单号")
	@Column(name = "ORDER_NO", columnDefinition = "CHAR(32)")
	private String orderNo;
	
	/**
	 * 用户标识
	 */
	@Comment("用户标识")
	@Column(name = "OPEN_ID", columnDefinition = "CHAR(40)")
	private String  openId;
	
	/**
	 * 交易类型
	 */
	@Comment("交易类型,JSAPI--公众号支付、NATIVE--原生扫码支付、APP--app支付,MICROPAY--刷卡支付")
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "TRADE_TYPE", columnDefinition = "INT")
	private BillTransaction.TradeType tradeType;
	
	public enum TradeState {
		/** 用户支付中*/
		USERPAYING,
		/** 支付失败*/
		SYSTEMERROR,
		/** 支付成功*/
		SUCCESS,
		/** 未支付*/
		NOTPAY,
		/** 转入退款*/
		REFUND,
		/** 已关闭*/
		CLOSED,
		/** 已撤销(刷卡支付)*/
		REVOKED
	}

	/**
	 * 交易状态
	 */
	@Comment("交易状态 ：SUCCESS成功，REFUND退款，NOTPAY未支付，CLOSED已关闭，REVOKED已撤销(刷卡支付)，USERPAYING用户支付中，SYSTEMERROR支付失败")
	@Column(name = "TRADE_STATE",  columnDefinition = "INT")
	private ReconciliationInfo.TradeState tradeState;

	/**
	 * 付款银行
	 */
	@Comment("付款银行")
	@Column(name = "BANK_TYPE", columnDefinition = "CHAR(32)")
	private String bankType;
	
	/**
	 * 交易币种
	 */
	@Comment("交易币种 ：CNY人民币")
	@Column(name = "CURR_TYPE",columnDefinition = "CHAR(5)")
	private String currType;
	
	/**
	 * 应结订单金额
	 */
	@Comment("应结订单金额,该笔订单的应结算金额（=订单金额-用户使用的免充值券金额），如果该行数据为退款或撤销则展示0.00，单位元，保留到小数点后2位")
	@Column(name = "REAL_SETTLE_AMOUNT", columnDefinition = "decimal(15,2)", scale=2)
	private BigDecimal realSettleAmount;

	/**
	 * 订单金额
	 */
	@Comment("订单金额")
	@Column(name = "TOTAL_AMOUNT", columnDefinition = "decimal(15,2)", scale=2)
	private BigDecimal totalAmount = BigDecimal.ZERO;
	
	/**
	 * 代金券金额 
	 */
	@Comment("代金券金额")
	@Column(name = "COUPON_FEE",columnDefinition = "decimal(10,2)", scale=2)
	private BigDecimal couponFee = BigDecimal.ZERO;
	
	/**
	 * 微信退款单号
	 */
	@Comment("微信退款单号")
	@Column(name = "WX_REFUND_ID", columnDefinition = "CHAR(32)")
	private String  wxRefundId;
	
	/**
	 * 商户退款单号
	 */
	@Comment("商户退款单号")
	@Column(name = "REFUND_NO", columnDefinition = "CHAR(21)")
	private String  refundNo;
	
	/**
	 * 退款金额
	 */
	@Comment("退款金额")
	@Column(name = "REFUND_FEE", columnDefinition = "decimal(10,2)", scale=2)
	private BigDecimal refundFee = BigDecimal.ZERO;
	
	/**
	 * 充值券退款金额
	 */
	@Comment("充值券退款金额")
	@Column(name = "COUPON_FEE_REFUND",columnDefinition = "decimal(10,2)", scale=2)
	private BigDecimal couponFeeRefund = BigDecimal.ZERO;
	
	/**
	 * 退款类型
	 */
	@Comment("退款类型:ORIGINAL原路退款,BALANCE退回到余额,OTHER_BALANCE原账户异常退到其他余额账户,OTHER_BANKCARD原银行卡异常退到其他银行卡")
	@Column(name = "REFUND_TYPE",columnDefinition = "CHAR(20)")
	private  String refundType;

	/**
	 * 退款状态
	 */
	@Comment("退款状态 :SUCCESS—退款成功,REFUNDCLOSE—退款关闭,PROCESSING—退款处理中,CHANGE—退款异常")
	@Column(name = "REFUND_STATUS", columnDefinition = "CHAR(20)")
	private String refundStatus;
	
	/**
	 * 商品名称
	 */
	@Comment("商品名称")
	@Column(name = "PRODUCT_NAME", columnDefinition = "CHAR(50)")
	private String productName;
	
	/**
	 * 商品数据包
	 */
	@Comment("商品名称")
	@Column(name = "PRODUCT_DATA", columnDefinition = "CHAR(50)")
	private String productData;
	
	/**
	 * 交易手续费
	 */
	@Comment("交易手续费")
	@Column(name = "TRANS_FEE", columnDefinition = "decimal(10,5)", scale=5)
	private BigDecimal transFee = BigDecimal.ZERO;
	
	/**
	 * 费率
	 */
	@Comment("费率")
	@Column(name = "RATE", columnDefinition = "decimal(10,4)", scale=4)
	private BigDecimal rate = BigDecimal.ZERO;
	
	/**
	 * 申请退款金额
	 */
	@Comment("申请退款金额")
	@Column(name = "APPLY_REFUND", columnDefinition = "decimal(15,2)", scale=5)
	private BigDecimal applyRefund;
	
	/**
	 * 费率备注
	 */
	@Comment("费率备注")
	@Column(name = "RATE_REMARK", columnDefinition = "CHAR(200)")
	private String rateRemark;
	
	/**
	 * 是否已对账
	 */
	@Comment("是否已对账,0未对账，1已对账")
	@Column(name = "IS_RECONCILATION")
	private Boolean isReconcilation = false;
	
	/**
	 * 对账文件日期
	 */
	@Comment("对账文件日期")
	@Column(name = "RECON_DATE", columnDefinition = "CHAR(10)")
	private String reconDate;
	
	public ReconciliationInfo() {

	}

}