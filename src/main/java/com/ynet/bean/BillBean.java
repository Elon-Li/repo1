package com.ynet.bean;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;

import com.ynet.pojo.Bill;

import lombok.Data;

/**
 * 【cloudbill】账单实体
 * 
 * @author shenhc
 *
 */
@Data
public class BillBean {

	private Long id;

	private Long mchId;

	private Long orgId;

	private Long activityId;

	// false
	private Long batchId = 0L;

	private String verifyId;

	private String verifyName;

	@Column(name = "VERIFY_ORGNAME", length = 100)
	private String verifyOrgName;

	@Column(name = "AMOUNT", columnDefinition = "decimal(10,2)", scale = 2, nullable = false)
	private BigDecimal amount;

	@Column(name = "REFUND_AMOUNT", columnDefinition = "decimal(10,2)", scale = 2, nullable = false)
	private BigDecimal refundAmount = BigDecimal.ZERO;

	@Column(name = "REFUND_COUNT", columnDefinition = "TINYINT", nullable = false)
	private Integer refundCount = 0;

	@Column(name = "REFUND_SEQ_NO", columnDefinition = "TINYINT", nullable = false)
	private Integer refundSeqNo = 0;

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

	private Bill.RefundState refundState = Bill.RefundState.DEFAULT;

	private Long lastUpdate;

	private Long refundAt = 0L;

	// ==================================================================DIFF

	/** 缴费期 */
	private String payDuration;

	private String billNumber;

	private BigDecimal fee;

	/** 签入信息的分隔符号 */
	public static final String IDENTITY_SEP = "-";

	/**
	 * 发起支付时确立支付流水号 账单支付序列号 - 与支付密切相关 必须唯一，8-40位数字字母，不能含“-”或“_”，可以自行定制规则
	 */
	private String paySerialNumber;

	private BigDecimal realPayAmount;

	/**
	 * 是否修改支付账单总额 false没有修改，true修改
	 */
	private Boolean isChangeAmount = false;

	// 缴费成功后要更新的数据

	private Date paymentDate;

	private String openid;

	private String payerid;

	private String orgFullname;
	// ==============================================
	private String orderNo;

	private String trxId;

	/** 收费类型ID */
	private Long billTypeId;

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

	private Bill.BillState billState = Bill.BillState.DEFAULT;

	/**
	 * 是否修改支付账单总额 false没有修改，true修改
	 */
	private Boolean isDeleteFlag = false;

	/**
	 * 机构序号
	 * 
	 */
	private int seqnum;

	/*
	 * 支付渠道
	 */
	private String payChannel;

	private String payWay;

	private String termType;

	private String channel;

	private String timeEnd;

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

	private Bill.ClearState clearState = Bill.ClearState.CLEAR_UNDONE;

	private Integer payMode;

	private Integer paySeqNo = 0;

	private BigDecimal payedAmount = BigDecimal.ZERO;

	private Integer verifyState = 0;

	private Boolean isWithhold;

	private String withholdBatchNo;

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

	private Bill.REGISTERPAYSTATE registerPayState = Bill.REGISTERPAYSTATE.NOT_REGISTER;

	private Long verifyDate = 0L;

	private Long registerTime = 0L;

	private Long lastPayAt = 0L;

	public BillBean(Long id, Long mchId, Long orgId, Long activityId, Long batchId, String verifyId, String verifyName,
			String verifyOrgName, BigDecimal amount, BigDecimal refundAmount, Integer refundCount, Integer refundSeqNo,
			String additionInfo, com.ynet.pojo.Bill.PayState payState, com.ynet.pojo.Bill.RefundState refundState,
			Long lastUpdate, Long refundAt, String payDuration, String billNumber, BigDecimal fee,
			String paySerialNumber, BigDecimal realPayAmount, Boolean isChangeAmount, Date paymentDate, String openid,
			String payerid, String orgFullname, String orderNo, String trxId, Long billTypeId, Long createAt,
			com.ynet.pojo.Bill.BillState billState, Boolean isDeleteFlag, int seqnum, String payChannel, String payWay,
			String termType, String channel, String timeEnd, String errorType, com.ynet.pojo.Bill.ClearState clearState,
			Integer payMode, Integer paySeqNo, BigDecimal payedAmount, Integer verifyState, Boolean isWithhold,
			String withholdBatchNo, String withholdCardNo, com.ynet.pojo.Bill.REGISTERPAYSTATE registerPayState,
			Long verifyDate, Long registerTime, Long lastPayAt) {
		super();
		this.id = id;
		this.mchId = mchId;
		this.orgId = orgId;
		this.activityId = activityId;
		this.batchId = batchId;
		this.verifyId = verifyId;
		this.verifyName = verifyName;
		this.verifyOrgName = verifyOrgName;
		this.amount = amount;
		this.refundAmount = refundAmount;
		this.refundCount = refundCount;
		this.refundSeqNo = refundSeqNo;
		this.additionInfo = additionInfo;
		this.payState = payState;
		this.refundState = refundState;
		this.lastUpdate = lastUpdate;
		this.refundAt = refundAt;
		this.payDuration = payDuration;
		this.billNumber = billNumber;
		this.fee = fee;
		this.paySerialNumber = paySerialNumber;
		this.realPayAmount = realPayAmount;
		this.isChangeAmount = isChangeAmount;
		this.paymentDate = paymentDate;
		this.openid = openid;
		this.payerid = payerid;
		this.orgFullname = orgFullname;
		this.orderNo = orderNo;
		this.trxId = trxId;
		this.billTypeId = billTypeId;
		this.createAt = createAt;
		this.billState = billState;
		this.isDeleteFlag = isDeleteFlag;
		this.seqnum = seqnum;
		this.payChannel = payChannel;
		this.payWay = payWay;
		this.termType = termType;
		this.channel = channel;
		this.timeEnd = timeEnd;
		this.errorType = errorType;
		this.clearState = clearState;
		this.payMode = payMode;
		this.paySeqNo = paySeqNo;
		this.payedAmount = payedAmount;
		this.verifyState = verifyState;
		this.isWithhold = isWithhold;
		this.withholdBatchNo = withholdBatchNo;
		this.withholdCardNo = withholdCardNo;
		this.registerPayState = registerPayState;
		this.verifyDate = verifyDate;
		this.registerTime = registerTime;
		this.lastPayAt = lastPayAt;
	}

	// =================constructor=================

}
