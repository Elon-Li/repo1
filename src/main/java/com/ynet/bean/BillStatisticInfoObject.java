package com.ynet.bean;

public class BillStatisticInfoObject {
	
	private  Integer activityId;
	private Integer orgId;
	private String orgFullname;
	private int billCount;
	private String actName;
	public Integer getActivityId() {
		return activityId;
	}
	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}
	public Integer getOrgId() {
		return orgId;
	}
	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}
	public String getOrgFullname() {
		return orgFullname;
	}
	public void setOrgFullname(String orgFullname) {
		this.orgFullname = orgFullname;
	}
	public int getBillCount() {
		return billCount;
	}
	public void setBillCount(int billCount) {
		this.billCount = billCount;
	}
	public String getActName() {
		return actName;
	}
	public void setActName(String actName) {
		this.actName = actName;
	}
	
	

}
