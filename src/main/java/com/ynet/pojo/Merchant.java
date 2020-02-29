package com.ynet.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

/**
 * 
 * <pre>
 * 商户登记信息定义实体
 * </pre>
 *
 * @author zhoujiagen
 *
 */
@SuppressWarnings("serial")
@Comment("商户登记信息表")
@Entity
@Data
@Table(name = "MCH_MERCHANT")
public class Merchant{
	
	/**
	 * 自动增长的ID
	 * 
	 * 支持MySQL，不支持Oracle
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "BIGINT(10)")
	protected Long id;

	@Comment("商户名称")
	@Column(name = "NAME", length = 255, nullable = false)
	private String name;

	@Comment("商户简称")
	@Column(name = "SHORTNAME", length = 60, nullable = false)
	private String shortName;

	@Comment("行业编号，系统定义常量 0:特殊商户（系统留用），幼儿园：11;中小学：12;大学：  16;培训机构：17")
	@Column(name = "INDUSTRY", columnDefinition = "TINYINT", nullable = false)
	private Integer industry;
	
	@Comment("行业类型，系统定义常量 1:教育;2:物业;3:社保;4:企事业")
	@Column(name = "INDUSTRY_TYPE", columnDefinition = "TINYINT", nullable = false)
	private Integer industryType;

	@Comment("商户类型ID")
	@Column(name = "MCH_TYPE", columnDefinition = "INT(10)")
	private Long mchTypeId;

	public enum WxState {
		/** 未提交 */
		UNSUBMIT,
		/** 待审核 */
		NEED_AUDIT,
		/** 已通过 */
		PASSED,
		/** 已驳回 */
		REJECTED,
		//FIXME 由于传值为"" objectMapper 无法解析为 null，添加 NULL值
		NULL
	}

	@Comment("微信支付申请状态")
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "WX_STATE", columnDefinition = "TINYINT", nullable = false)
	private Merchant.WxState wxState = Merchant.WxState.UNSUBMIT;

	public enum BizState {
		/** 未提交 */
		UNSUBMIT,
		/** 已提交 */
		SUBMITED,
		/** 已通过 */
		PASSED,
		/** 已驳回 */
		REJECTED,
		/** 已开通 */
		OPENED,
		/** 已关闭 */
		CLOSED,
		NULL, //同上一个枚举
		//待审核
		NEED_AUDIT
		
	}

	@Comment("业务申请状态")
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "BIZ_STATE", columnDefinition = "TINYINT", nullable = false)
	private Merchant.BizState bizState = Merchant.BizState.UNSUBMIT;

	// ==================================================================DIFF

	/** 商户编号 */
	@Comment("商户编号")
	private String merchantNumber;
	
	@Comment("微信子商户号")
	@Column(name = "wx_mch_id", length = 10)
	private int xmMchId = 0;
	
	@Comment("最后修改时间")
	@Column(name = "last_update_time")
	@Temporal(value = TemporalType.TIMESTAMP)//格式时间
	private Date lastUpdateTime;
	
	@Comment("城市id，唯一")
	@Column(name = "CITY_ID", columnDefinition = "INT(10)")
	private Long cityId ;
	
	
	@Comment("城市名，唯一")
	@Column(name = "CITY",length = 30)
	private String city ;
	
	/** 隶属机构ID */
	@Comment("隶属机构ID")
	@Column(name = "ORG_ID", columnDefinition = "INT(10)")
	private Long orgId;
	
	/** 商户费率ID */
	@Comment("商户费率ID")
	@Column(name = "MCH_FEE_RATE_ID", columnDefinition = "INT(10)")
	private Long mchFeeRateId;
	
	/** 创建时间 */
	@Comment("创建时间")
	@Column(name = "CREAT_AT")
	private Long creatAt;
	
	/** 开通时间 */
	@Comment("开通时间")
	@Column(name = "OPEN_AT")
	private Long openAt;
	
	@Comment("活动审核任务ID")
	@Column(name = "TASK_ID", columnDefinition = "INT(10)")
	private Long taskId;
	
	@Comment("是否在微信端展示")
	@Column(name = "IS_SHOW")
	private Boolean show = true;
	
	@Comment("是否开通分笔支付。0：否（默认）   1：是")
	@Column(name = "ENABLE_SPLIT_PAY", columnDefinition = "TINYINT", nullable = false)
	private Integer enableSplitPay = 0;
	
	@Comment("是否支持代扣")
	@Column(name = "SUPPORT_WITHHOLD")
	private Boolean supportWithhold = false;
	
	@Comment("商户级别")
	@Column(name = "Mch_manage_level", columnDefinition = "TINYINT")
	private Integer mchManageLevel = 1;
	
	@Comment("地区ID")
	@Column(name = "district_id", columnDefinition = "INT(10)")
	private Long districtId;
	
	public enum AliState {
		/** 未提交 */
		UNSUBMIT,
		/** 待审核 */
		NEED_AUDIT,
		/** 已通过 */
		PASSED,
		/** 已驳回 */
		REJECTED,
		//FIXME 由于传值为"" objectMapper 无法解析为 null，添加 NULL值
		NULL
	}

	@Comment("微信支付申请状态")
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "ALI_STATE", columnDefinition = "TINYINT", nullable = false)
	private Merchant.AliState aliState = Merchant.AliState.UNSUBMIT;
	
	@Comment("是否支持退款。0：否（默认）   1：是")
	@Column(name = "enable_refund", columnDefinition = "TINYINT", nullable = false)
	private Integer enableRefund = 0;
	
	@Comment("是否支持充值。0：否（默认）   1：是")
	@Column(name = "enable_recharge", columnDefinition = "TINYINT", nullable = false)
	private Integer enableRecharge = 0;

	public Merchant() {}
	
	public Merchant(Long id,int xmMchId) {
		this.id = id;
		this.xmMchId = xmMchId;
	}

}
