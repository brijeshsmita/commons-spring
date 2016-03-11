/**
 * 
 */
package com.cg.spring.di;
/**
 * @author BrijeshSmita
 *
 */
public class Employee {
	private CompanyInfo companyInfo;

	@Override
	public String toString() {
		return "Employee [coInfo=" + companyInfo + "]";
	}

	public CompanyInfo getCompanyInfo() {
		return companyInfo;
	}

	public void setCompanyInfo(CompanyInfo companyInfo) {
		this.companyInfo = companyInfo;
	}
}
