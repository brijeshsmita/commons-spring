package com.cg.beans;

import org.springframework.context.annotation.Scope;

@Scope(value="prototype")
public class Employee {
	private CompanyInfo companyInfo;
	private String name;
	public Employee() {
		System.out.println("Employee 's default contructor....");
	}	
	public Employee(CompanyInfo companyInfo) {
		super();
		this.companyInfo = companyInfo;
	}
	public Employee(CompanyInfo companyInfo, String name) {
		super();
		this.companyInfo = companyInfo;
		this.name = name;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Employee [companyInfo=" + companyInfo + ", name=" + name + "]";
	}
	public CompanyInfo getCompanyInfo() {
		return companyInfo;
	}

	public void setCompanyInfo(CompanyInfo companyInfo) {
		this.companyInfo = companyInfo;
	}
}
