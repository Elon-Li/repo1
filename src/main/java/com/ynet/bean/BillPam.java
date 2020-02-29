package com.ynet.bean;

public class BillPam {
	
	private Long billId;
	private Long mchId;
	
	public BillPam() {
	}
	public BillPam(Long billId, Long mchId) {
		this.billId = billId;
		this.mchId = mchId;
	}
	public Long getBillId() {
		return billId;
	}
	public void setBillId(Long billId) {
		this.billId = billId;
	}
	public Long getMchId() {
		return mchId;
	}
	public void setMchId(Long mchId) {
		this.mchId = mchId;
	}

}
