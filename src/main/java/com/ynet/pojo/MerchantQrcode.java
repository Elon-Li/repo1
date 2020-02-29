package com.ynet.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * 
 * <pre>
 * 二维码定义实体
 * </pre>
 *
 * @author guoch
 *
 */
@Comment("商户二维码定义表")
@Entity
@Table(name = "MCH_QRCODE")
public class MerchantQrcode  {
	/**
	 * 
	 */
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

//	/** 商户 */
//	@ManyToOne(fetch=FetchType.LAZY)
//	@JoinColumn(name = "MCH_ID", nullable = false, insertable = false, updatable = false)
//	private Merchant mch;

	@Comment("商户ID")
	@Column(name = "MCH_ID", columnDefinition = "INT(10)", nullable = false)
	private Long mchId;
	
	public enum Type{
		SIGNUP,   //助理注册
		BILLPUSH,  //帐单推送
		PREVIEW ,   //预览
		ACTIVITYVIEW,   //活动预览
		MSIGNUP,     //管理人员注册
		SWEEPPAY,     //付款码
		CREATED      //商户开通
		
	}
	
	@Comment("二维码类型：0助理注册, 1帐单推送")
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "TYPE",columnDefinition = "TINYINT", nullable = false)
	private MerchantQrcode.Type type;
	
	@Comment("二维码地址")
	@Column(name = "URL", length = 255)
	private String url;
	
	@Comment("类型参数")
	@Column(name = "ARGS", length = 255)
	private String args;
	
	@Comment("创建时间")
	@Column(name = "CREATE_AT")
	private Long createAt;
	
	@Comment("有效期，单位秒")
	@Column(name = "EXPIRE_SECONDS", nullable = false)
	private int expireSeconds;
	
	@Comment("到期时间")
	@Column(name = "EXPIRE_AT")
	private Long expireAt;
	
	@Comment("访问授权码, 15位长数字字符混合随机码")
	@Column(name = "ACCESS_TOKEN", length = 30, nullable = false)
	private String accessToken;


	
	
	

}
