package com.ynet.pojo;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;





/**
 * 
 * <pre>
 * 缴费活动实体定义
 * </pre>
 *
 * @author zhoujiagen
 *
 */
@Comment("收费活动记录表")
@SuppressWarnings("serial")
@Entity
@Data
@Table(name = "BILL_ACTIVITY")
public class BillActivity {
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

	@Comment("活动名称")
	@Column(length = 50, nullable = false)
	private String actName;

	@Comment("缴费类型")
	@ManyToOne
	@JoinColumn(name = "BILL_TYPE", nullable = false, insertable = false, updatable = false)
	private BillType billType;

	@Comment("缴费类型ID")
	@Column(name = "BILL_TYPE", columnDefinition = "INT(10)", nullable = false)
	private Long billTypeId;

	@Comment("缴费帐期")
	@Column(name = "BILL_CYCLE", length = 8, nullable = false)
	private String billCycle;

	@Comment("创建时间")
	@Column(name = "CREATE_AT", columnDefinition = "BIGINT(10)")
	private Long createAt;

	@Comment("提交时间")
	@Column(name = "SUBMIT_AT", columnDefinition = "BIGINT(10)")
	private Long submitAt;

	@Comment("发布时间")
	@Column(name = "OPEN_AT", columnDefinition = "BIGINT(10)")
	private Long openAt;

	@Comment("关闭时间")
	@Column(name = "CLOSE_AT", columnDefinition = "BIGINT(10)")
	private Long closeAt;
	
	@Comment("批次处理开始时间")
	@Column(name = "BATCH_LOCK_AT", columnDefinition = "BIGINT(10)")
	private Long batchLockAt;
	
	public enum State {
		/** 创建中 */
		CREATING,
		/** 待发布 */
		SUMBITTED,
		/** 待审核 */
		NEED_APPROVAL,
		/** 已拒绝*/
		REFUSED,
		/** 进行中 */
		OPENED,
		/** 已暂停*/
		SUSPENDED,
		/** 已关闭 */
		CLOSED,
		/** 已到期*/
		EXPIRED,
//		/** 已完成*/
//		COMPLETED
	}

	@Comment("实体状态")
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "STATE", columnDefinition = "TINYINT")
	private BillActivity.State state;

	@Comment("二维码ID")
	@Column(name = "QRCODE_ID",columnDefinition = "INT(10)", nullable = true)
	private Long qrcodeId;
	
//	由于@OneToOne 二维码表为null 导致 findOne（actId） 查到为null
	@Transient
	@Column(name = "QRCODE")
	private MerchantQrcode qrcode;
	
	@Comment("最后操作时间")
	@Column(name = "LAST_OPER_AT",columnDefinition = "BIGINT(10)")
	private Long lastOperAt;
	
	@Comment("最后操作类型")
	@Column(name = "LAST_OPER_TYPE")
	private BillActivityOperation.OperType lastOperType;
	
	@Comment("商户ID")
	@Column(name = "MCH_ID", columnDefinition = "INT(10)")
	private Long mchId;
	
	@Comment("活动审核任务ID")
	@Column(name = "TASK_ID", columnDefinition = "INT(10)")
	private Long taskId;
	
	@Comment("结束时间")
	@Column(name = "END_AT",columnDefinition = "BIGINT(10)")
	private Long endAt;
	
	@Comment("结束时间下拉标志")
	@Column(name = "END_AT_Falg",columnDefinition = "INT(10)")
	private int endAtFalg;
	
	@Comment("活动图标")
	@Column(name = "ICON_ID", length = 100, nullable = false)
	private String iconId;
	
	@Comment("提醒缴费次数")
	@Column(name = "NOTIFY_NO",columnDefinition = "INT(10)")
	private Integer notifyNo=0;
	
	@Comment("完成时间")
	@Column(name = "COMPLETE_TIME",columnDefinition = "BIGINT(10)")
	private Long completeTime;
	
	@Comment("是否为分笔支付")
	@Column(name = "is_split_pay",columnDefinition = "TINYINT")
	private Boolean isSplitPay;
	
	/** 隶属商户机构ID */
	@Column(name = "MCH_ORG_ID", columnDefinition = "INT(10)")
	private Long mchOrgId;
	
	@Comment("缴费子项")
	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(columnDefinition = "TEXT", nullable = true)
	private String subItem;
	
	@Comment("关闭时间")
	@Column(name = "STOP_AT", columnDefinition = "BIGINT(10)")
	private Long stopAt;
	
	// =================临时属性 Transient====================
	@Transient
	private Object billItemInfos;
	@Transient
	private List<Bill> bills;
	/**收费模式 :0：账单模式 1：订单模式*/
	@Transient
	private Integer payMode;
//	@Transient
//	private BillActivityOrder  billActOreder;
//	@Transient
//	private List<BillActivityOrg>  billActOrgs;
//	@Transient
//	private BillActivityRule billActivityRule;
	
	@Transient
	private Long firstEndAt;
	
	@Transient
	private Boolean subItemFlag = false;
	
	@Transient
	private Boolean rechargeWay = false;
	// =================constructor=================

	public BillActivity() {}

	public BillActivity(Long id, String actName, Long billTypeId, BillType billType) {
		this.id = id;
		this.billTypeId = billTypeId;
		this.actName = actName;
		this.billType = billType;
	}

	public BillActivity(Long id, String actName) {
		this.id = id;
		this.actName = actName;
	}
	
	public BillActivity(Long id, String actName,String billCycle) {
		this.id = id;
		this.actName = actName;
		this.billCycle = billCycle;
	}
	
	//根据商户Id查询所有的 已开通的 缴费活动
	public BillActivity(Long id, String actName, Long billTypeId, String billCycle, BillActivity.State state, Long qrcodeId,String iconId) {
		this.id = id;
		this.actName = actName;
		this.billTypeId = billTypeId;
		this.billCycle = billCycle;
		this.state = state;
		this.qrcodeId = qrcodeId;
		this.iconId = iconId;
	}
	
	public BillActivity(Long id, String actName, Long billTypeId, String billCycle, BillActivity.State state, MerchantQrcode qrcodeId) {
		this.id = id;
		this.actName = actName;
		this.billTypeId = billTypeId;
		this.billCycle = billCycle;
		this.state = state;
		this.qrcode = qrcodeId;
	}
	
	
}
