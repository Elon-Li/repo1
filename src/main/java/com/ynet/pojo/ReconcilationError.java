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
 * <p>Title: ReconcilationError</p>
 * <p>Description: 对账差错明细表</p>
 * @author	zhonghy
 * @date	2016年8月19日
 * @version 1.0
 */
@Comment("微信对账差错明细表")
@Entity
@Data
@Table(name = "RECONCILATION_ERROR")
public class ReconcilationError{
	
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
	 * 商户订单号
	 */
	@Comment("商户订单号")
	@Column(name = "ORDER_NO", columnDefinition = "CHAR(32)")
	private String orderNo;
	
	/**
	 * 微信订单号
	 */
	@Comment("微信订单号")
	@Column(name = "TRX_ID", length = 40)
	private String trxId;

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
	
	/**
	 * 本地交易状态
	 */
	@Comment("交易结果：0支付中, 1失败，2.成功，3未支付,4退款")
	@Column(name = "TRADE_STATE_LOCAL", columnDefinition = "SMALLINT")
	private Integer tradeStateLocal;
	
	/**
	 * 微信交易状态
	 */
	@Comment("交易状态 ：0支付中, 1失败,2成功，3未支付，4退款，5已关闭，6已撤销")
	@Column(name = "TRADE_STATE_WX", columnDefinition = "SMALLINT")
	private ReconciliationInfo.TradeState tradeStateWx;

	/**
	 * 交易币种
	 */
	@Comment("交易币种 ：CNY人民币")
	@Column(name = "CURR_TYPE",columnDefinition = "CHAR(5)")
	private String currType;
	
	/**
	 * 付款银行
	 */
	@Column(name = "BANK_TYPE", columnDefinition = "CHAR(32)")
	@Comment("付款银行")
	private String bankType;

	/**
	 * 本地交易金额
	 */
	@Comment("本地交易金额")
	@Column(name = "TRADE_AMOUNT_LOCAL", columnDefinition = "decimal(10,2)", scale=2)
	private BigDecimal tradeAmountLocal = BigDecimal.ZERO;
	
	/**
	 * 微信账单交易金额
	 */
	@Comment("微信账单交易金额")
	@Column(name = "TRADE_AMOUNT_WX", columnDefinition = "decimal(10,2)", scale=2)
	private BigDecimal tradeAmountWx = BigDecimal.ZERO;
	
	/**
	 * 差错类型
	 */
	@Comment("差错类型:1金额不匹配，数据异常，2多记录，数据异常,3无本地交易，数据异常,"
			+ "4支付中修改为支付成功，5未支付修改为支付成功，6支付失败修改为支付成功，7重复支付，"
			+ "8支付成功修改为支付失败")
	@Column(name = "ERROR_TYPE", columnDefinition = "INT")
	private int errorType = 0;
	
	/**
	 * 差错描述
	 */
	@Comment("差错描述")
	@Column(name = "ERROR_DESC",columnDefinition = "CHAR(200)")
	private String errorDesc;
	
	/**
	 * 商户号
	 */
	@Comment("商户号")
	@Column(name = "MCH_NUM", length = 10)
	private String mchNum;
	
	/**
	 * 活动名称
	 */
	@Comment("活动名称")
	@Column(name = "ACT_NAME",columnDefinition = "CHAR(50)")
	private String activityName;
	
	/**
	 * 机构id
	 */
	@Comment("机构ID")
	@Column(name = "ORG_ID", columnDefinition = "INT", nullable = false)
	private Long orgId;
	
	/**
	 * 账单id
	 */
	@Comment("账单ID")
	@Column(name = "bill_id", columnDefinition = "BIGINT(10)")
	private Long billId;
	
	/**
	 * 账单编号
	 */
	@Comment("账单编号")
	@Column(name = "BILL_NUMBER", columnDefinition = "VARCHAR(255)")
	private String billNumber;
	
	/**
	 * 对账时间
	 */
	@Comment("对账时间")
	@Column(name = "VERIFY_DATE", columnDefinition = "CHAR(10)")
	private String verifyDate;
	
	/**
	 * 特约商户号
	 */
	@Comment("特约商户号")
	@Column(name = "CONTRIBUTORS_NUM", columnDefinition = "CHAR(32)")
	private String contributorsNum;

}
