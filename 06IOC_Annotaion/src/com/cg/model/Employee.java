/**
 * 
 */
package com.cg.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.cg.services.CompanyInfo;
@Component("employee")
public class Employee {
	
	private CompanyInfo companyInfo;
	
	public Employee(){System.out.println("Employee No_arg Contsr");}
	@Autowired
	public Employee(CompanyInfo companyInfo) {
		super();
		this.companyInfo = companyInfo;
	}

	@Override
	public String toString() {
		return "Employee [coInfo=" + companyInfo + "]";
	}

	public CompanyInfo getCompanyInfo() {
		return companyInfo;
	}
	/*@Autowired
	@Qualifier("companyInfo")*/
	public void setCompanyInfo(CompanyInfo companyInfo) {
		this.companyInfo = companyInfo;
	}
}
