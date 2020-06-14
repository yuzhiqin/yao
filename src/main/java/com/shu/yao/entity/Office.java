package com.shu.yao.entity;

import java.util.Date;

public class Office {
	private static final long serialVersionUID = 1L;
	private String id;
	
	private String code; 	// 机构编码
 	private String officeName; 	// 机构名称
 	private Integer sort;		// 排序
 	private String areaId; 	// 归属区域
	private String officType; 	// 机构类型（1：公司；2：部门；3：小组）
	private String address; // 联系地址
	private String master; 	// 负责人
	private String phone; 	// 电话
	private String email; 	// 邮箱
	
	private Date createDate;	// 创建日期
	private String createBy;// 创建人
	protected String delFlag; 	// 删除标记（0：正常；1：删除；2：审核）
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getOfficeName() {
		return officeName;
	}
	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public String getAreaId() {
		return areaId;
	}
	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}
	public String getOfficType() {
		return officType;
	}
	public void setOfficType(String officType) {
		this.officType = officType;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMaster() {
		return master;
	}
	public void setMaster(String master) {
		this.master = master;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public String getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
	

}
