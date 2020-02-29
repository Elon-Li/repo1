package com.ynet.pojo;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.NamedQuery;

import lombok.Data;

/**
 * 【cloudbill】账单实体
 * 
 * @author shenhc
 *
 */
@Entity
@Comment("账单记录表")
@Table(name = "BILL")
@Data
public class Bill {
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
	@Column(name = "MCH_ID", columnDefinition = "INT", nullable = false)
	private Long mchId;

	@Comment("机构ID")
	@Column(name = "ORG_ID", columnDefinition = "INT", nullable = false)
	private Long orgId;

	@Comment("活动ID")
	@Column(name = "ACTIVITY_ID", columnDefinition = "INT", nullable = false)
	private Long activityId;

	@Comment("批次处理ID")
	@Column(name = "BATCH_ID", columnDefinition = "BIGINT") // , nullable =
															// false
	private Long batchId = 0L;

	@Comment("帐单标识项")
	@Column(name = "VERIFY_ID", length = 100, nullable = false)
	private String verifyId;

	@Comment("帐单标识项名称")
	@Column(name = "VERIFY_NAME", length = 100, nullable = true)
	private String verifyName;

	@Comment("验证项机构名称")
	@Column(name = "VERIFY_ORGNAME", length = 100)
	private String verifyOrgName;

	@Comment("帐单总额")
	@Column(name = "AMOUNT", columnDefinition = "decimal(10,2)", scale = 2, nullable = false)
	private BigDecimal amount;

	@Comment("退款金额")
	@Column(name = "REFUND_AMOUNT", columnDefinition = "decimal(10,2)", scale = 2, nullable = false)
	private BigDecimal refundAmount = BigDecimal.ZERO;

	@Comment("退款次数")
	@Column(name = "REFUND_COUNT", columnDefinition = "TINYINT", nullable = false)
	private Integer refundCount = 0;

	@Comment("退款序列号，默认0，用于生成商户退款单号")
	@Column(name = "REFUND_SEQ_NO", columnDefinition = "TINYINT", nullable = false)
	private Integer refundSeqNo = 0;

	@Comment("附加信息")
	@Column(name = "ADDITION_INFO", length = 255)
	private String additionInfo;

	public enum PayState {
		/** 支付中 */
		PAYING,
		/** 支付失败 */
		FAILURE,
		/** 支付成功 */
		SUCCESS,
		/** 未支付 */
		DEFAULT,
		/** 退款 */
		REFUND,
		/** 支付差错 */
		ERROR,
		/** 代扣中 */
		WITHHOLDING
	}

	@Comment("支付状态")
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "PAY_STATE", columnDefinition = "TINYINT", nullable = true)
	private Bill.PayState payState = Bill.PayState.DEFAULT;

	public enum RefundState {
		/** 未退款 */
		DEFAULT,
		/** 退款中 */
		PROCESSING,
		/** 部分退款成功 */
		PARTSUCCESS,
		/** 全额退款成功 */
		SUCCESS,
		/** 退款异常 */
		CHANGE
	}

	@Comment("退款状态")
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "REFUND_STATE", columnDefinition = "TINYINT", nullable = true)
	private Bill.RefundState refundState = Bill.RefundState.DEFAULT;

	@Comment("最后更新时间")
	@Column(name = "LAST_UPDATE", columnDefinition = "BIGINT", nullable = false)
	private Long lastUpdate;

	@Comment("退款时间")
	@Column(name = "REFUND_AT", columnDefinition = "BIGINT", nullable = false)
	private Long refundAt = 0L;

	// ==================================================================DIFF

	/** 缴费期 */
	@Comment("缴费期")
	@Column(name = "PAY_DURATION")
	private String payDuration;

	@Comment("账单编号")
	@Column(name = "BILL_NUMBER")
	private String billNumber;

	@Comment("手续费")
	@Column(name = "FEE", columnDefinition = "decimal(10,2)", scale = 2)
	private BigDecimal fee;

	/** 签入信息的分隔符号 */
	public static final String IDENTITY_SEP = "-";

	/**
	 * 发起支付时确立支付流水号 账单支付序列号 - 与支付密切相关 必须唯一，8-40位数字字母，不能含“-”或“_”，可以自行定制规则
	 */
	@Comment("支付流水号")
	private String paySerialNumber;

	@Comment("实际支付总额")
	@Column(name = "real_Pay_Amount", columnDefinition = "decimal(10,2)", scale = 2)
	private BigDecimal realPayAmount;

	/**
	 * 是否修改支付账单总额 false没有修改，true修改
	 */
	@Comment("是否修改支付账单总额")
	@Column(nullable = false)
	private Boolean isChangeAmount = false;

	// 缴费成功后要更新的数据

	@Comment("缴费时间")
	private Date paymentDate;

	@Comment("公众号openID")
	private String openid;

	@Comment("缴费openID")
	private String payerid;

	@Comment("机构信息eg:**小学， 一年级， 一年级1班")
	@Column(name = "ORG_FULL_NAME", columnDefinition = "CHAR(20)", nullable = true)
	private String orgFullname;
	// ==============================================
	@Comment("订单号, 对应微信支付out_trade_no，应用自己生成")
	@Column(name = "ORDER_NO", columnDefinition = "CHAR(20)", nullable = true)
	private String orderNo;

	@Comment("交易订单号，微信支付结果通知中的transaction_id")
	@Column(name = "TRX_ID", length = 40, nullable = true)
	private String trxId;

	/** 收费类型ID */
	@Comment("收费类型ID")
	@Column(name = "BILL_TYPE_ID")
	private Long billTypeId;

	@Comment("创建时间")
	@Column(name = "CREATE_AT", columnDefinition = "BIGINT", nullable = false)
	private Long createAt;

	public enum BillState {
		/** 未支付 */
		DEFAULT,
		/** 部分支付 */
		PAYING,
		/** 全部支付 */
		SUCCESS,
		/** 支付失败 */
		FAILURE

	}

	@Comment("订单状态")
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "BILL_STATE", columnDefinition = "TINYINT", nullable = true)
	private Bill.BillState billState = Bill.BillState.DEFAULT;

	/**
	 * 是否修改支付账单总额 false没有修改，true修改
	 */
	@Comment("是否删除标志")
	@Column(nullable = false)
	private Boolean isDeleteFlag = false;

	/**
	 * 机构序号
	 * 
	 */
	@Comment("机构序号")
	@Column(nullable = false)
	private int seqnum;

	/*
	 * 支付渠道
	 */
	@Comment("支付渠道")
	@Column(name = "pay_channel", columnDefinition = "varchar(5)", nullable = true)
	private String payChannel;

	@Comment("支付类型")
	@Column(name = "pay_way", columnDefinition = "varchar(5)", nullable = true)
	private String payWay;

	@Comment("终端")
	@Column(name = "term_type")
	private String termType;

	@Comment("接入渠道")
	@Column(name = "channel")
	private String channel;

	@Comment("交易日期, 格式为yyyymmdd")
	@Column(name = "time_end")
	private String timeEnd;

	@Comment("差错类型,1数据差错，2时间差错")
	@Column(name = "ERROR_TYPE", columnDefinition = "varchar(5)", nullable = true)
	private String errorType = "0";

	public enum ClearState {
		/**
		 * 未清分
		 */
		CLEAR_UNDONE,
		/**
		 * 已清分
		 */
		CLEAR_DONE

	}

	@Comment("清分状态")
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "CLEAR_STATE", columnDefinition = "TINYINT")
	private Bill.ClearState clearState = Bill.ClearState.CLEAR_UNDONE;

	@Comment("收费模式 :0：账单模式 1：订单模式")
	@Column(name = "PAY_MODE", columnDefinition = "TINYINT")
	private Integer payMode;

	@Comment("账单序号 :0：原始账单")
	@Column(name = "PAY_SEQ_NO", columnDefinition = "TINYINT")
	private Integer paySeqNo = 0;

	@Comment("已经支付金额")
	@Column(name = "payed_amount", columnDefinition = "decimal(10,2)")
	private BigDecimal payedAmount = BigDecimal.ZERO;

	@Comment("是否对账修改状态，0 未对账，1已对账,2自动改帐，9差错已修改")
	@Column(name = "VERIFY_STATE", columnDefinition = "TINYINT")
	private Integer verifyState = 0;

	@Comment("是否代扣")
	@Column(name = "IS_WITHHOLD")
	private Boolean isWithhold;

	@Comment("代扣批次号")
	@Column(name = "Withhold_batch_no", columnDefinition = "varchar(20)", nullable = true)
	private String withholdBatchNo;

	@Comment("代扣卡号")
	@Column(name = "Withhold_cardNo", columnDefinition = "varchar(30)", nullable = true)
	private String withholdCardNo;

	public enum REGISTERPAYSTATE {
		/**
		 * 未登记（默认）
		 */
		NOT_REGISTER,
		/**
		 * 登记
		 */
		REGISTER,
		/**
		 * 取消登记
		 */
		CANCEL_REGISTER

	}

	@Comment("登记状态")
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "REGISTER_PAY_STATE", columnDefinition = "TINYINT")
	private Bill.REGISTERPAYSTATE registerPayState = Bill.REGISTERPAYSTATE.NOT_REGISTER;

	@Comment("对账时间")
	@Column(name = "VERIFY_DATE")
	private Long verifyDate = 0L;

	@Comment("现金登记时间")
	@Column(name = "REGISTER_TIME")
	private Long registerTime = 0L;

	@Comment("分笔支付的最近一笔支付时间")
	@Column(name = "LAST_PAY_AT")
	private Long lastPayAt = 0L;

	// =================transient fields=================
	/** 商户机构ID */
	@Transient
	private Long merchantOrgId;
	@Transient
	private Object billItemInfos;// 账单明细项

	@Transient
	private String merchantName;// 商户名称
	@Transient
	private String activityName;// 缴费活动名称

	@Transient
	private String payOwn;// 自己支付

	@Transient
	private BigDecimal currentPayAmount;// 分笔支付总金额

	@Transient
	private Boolean isSplitPay;

	@Transient
	private Boolean enableRecharge;

	// =================constructor=================

	public Bill() {
	}

	public Bill(Long id, String verifyId) {
		this.id = id;
		this.verifyId = verifyId;
	}

	public Bill(Long id, String verifyId, Long createAt) {
		this.id = id;
		this.verifyId = verifyId;
		this.createAt = createAt;
	}

	public Bill(Long id, String verifyId, BigDecimal amount) {
		this.id = id;
		this.verifyId = verifyId;
		this.amount = amount;
	}

	public Bill(Long id, String verifyId, BigDecimal amount, PayState payState) {
		this.id = id;
		this.verifyId = verifyId;
		this.amount = amount;
		this.payState = payState;
	}

	public Bill(Long id, String verifyId, BigDecimal amount, PayState payState, Long actId) {
		this.id = id;
		this.verifyId = verifyId;
		this.amount = amount;
		this.payState = payState;
		this.activityId = actId;
	}

	/** 前端：活动页面的账单信息 */
	public Bill(Long id, String verifyId, BigDecimal amount, PayState payState, Long actId, String verifyOrgName,
			BigDecimal realPayAmount) {
		this.id = id;
		this.verifyId = verifyId;
		this.amount = amount;
		this.payState = payState;
		this.activityId = actId;
		this.verifyOrgName = verifyOrgName;
		this.realPayAmount = realPayAmount;
	}

	public Bill(Long id, String verifyId, BigDecimal amount, PayState payState, Long actId, String verifyOrgName,
			BigDecimal realPayAmount, String openid, String verifyName) {
		this.id = id;
		this.verifyId = verifyId;
		this.amount = amount;
		this.payState = payState;
		this.activityId = actId;
		this.verifyOrgName = verifyOrgName;
		this.realPayAmount = realPayAmount;
		this.openid = openid;
		this.verifyName = verifyName;
	}

	public Bill(String merchantName, String activityName) {
		super();
		this.merchantName = merchantName;
		this.activityName = activityName;
	}

	public Bill(Long id, String verifyId, BigDecimal refundAmount, PayState payState, String payDuration,
			Date paymentDate, String activityName, BigDecimal realPayAmount, Long billActId, Long mchId,
			String verifyOrgName, String verifyName) {
		super();
		this.setId(id);
		this.verifyId = verifyId;
		this.refundAmount = refundAmount;
		this.payState = payState;
		this.payDuration = payDuration;
		this.paymentDate = paymentDate;
		this.activityName = activityName;
		this.realPayAmount = realPayAmount;
		this.activityId = billActId;
		this.mchId = mchId;
		this.verifyOrgName = verifyOrgName;
		this.verifyName = verifyName;
	}

	public Bill(Long id, String verifyId, BigDecimal refundAmount, PayState payState, String payDuration,
			Date paymentDate, String activityName, BigDecimal realPayAmount, Long billActId, Long mchId,
			String verifyOrgName, String verifyName, Integer paySeqNo, Boolean isSplitPay, BigDecimal amount) {
		super();
		this.setId(id);
		this.verifyId = verifyId;
		this.refundAmount = refundAmount;
		this.payState = payState;
		this.payDuration = payDuration;
		this.paymentDate = paymentDate;
		this.activityName = activityName;
		this.realPayAmount = realPayAmount;
		this.activityId = billActId;
		this.mchId = mchId;
		this.verifyOrgName = verifyOrgName;
		this.verifyName = verifyName;
		this.paySeqNo = paySeqNo;
		this.isSplitPay = isSplitPay;
		this.amount = amount;
	}
	

}
