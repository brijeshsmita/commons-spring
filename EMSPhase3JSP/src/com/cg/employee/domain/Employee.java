package com.cg.employee.domain;

import java.io.Serializable;
import java.util.Date;

public class Employee implements Serializable
{
	private static final long serialVersionUID = 5882662063971531582L;
	private int empId;
	private String empName;
	private String kinId;
	private String emailId;
	private String phoneNo;
	private Date dob;
	private Date doj;
	private String address;
	private int deptId;
	private int projectId;
	private int roleId;
	
	private static int kinRId;
	
	static
	{
		kinRId=100;
	}
	
	{
		kinId="KIN"+(int)(kinRId++ +(Math.random()*111.11));
		
	}
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	
	public Employee(int empId, String empName, String kinId, String emailId,
			String phoneNo, Date dob, Date doj, String address, int deptId,
			int projectId, int roleId) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.kinId = kinId;
		this.emailId = emailId;
		this.phoneNo = phoneNo;
		this.dob = dob;
		this.doj = doj;
		this.address = address;
		this.deptId = deptId;
		this.projectId = projectId;
		this.roleId = roleId;
	}

	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getKinId() {
		return kinId;
	}
	public void setKinId(String kinId) {
		this.kinId = kinId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", kinId="
				+ kinId + ", emailId=" + emailId + ", phoneNo=" + phoneNo
				+ ", dob=" + dob + ", doj=" + doj + ", address=" + address
				+ ", deptId=" + deptId + ", projectId=" + projectId
				+ ", roleId=" + roleId + "]";
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return this.hashCode()==obj.hashCode();
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return empId;
	}
}//end of class
