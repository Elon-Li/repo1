package com.ynet.bean;

import java.math.BigDecimal;


public interface BillStatisticInfoPro {

	public Long getActivityId();
	public Long getOrgId();
	public String getOrgFullname();
	public Long getBillCount();
	public String getActName();
	public BigDecimal getBillTotal();
//	public BigDecimal getBillAvg(); 
//	public Long getPayCount();
//	public BigDecimal getPayTotal(); 
//	public Long getSubitemId();
//	public Long getRefundCount();
//	public BigDecimal getRefundTotal();
}
