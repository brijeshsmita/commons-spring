/**
 * 
 */
package com.cg.spring.di;

/**
 * @author BrijeshSmita
 *
 */
public class CompanyInfo implements InformationService{
	private String coName;
	private String coAddress;
	//default constr
	public CompanyInfo(){
		
	}
	//overloaded constr
	public CompanyInfo(String coName, String coAddress) {
		super();
		this.coName = coName;
		this.coAddress = coAddress;
	}

	@Override
	public String toString() {
		return "CompanyInfo [coName=" + coName + ", coAddress=" + coAddress
				+ "]";
	}
	public String getCoName() {
		return coName;
	}
	public void setCoName(String coName) {
		this.coName = coName;
	}
	public String getCoAddress() {
		return coAddress;
	}
	public void setCoAddress(String coAddress) {
		this.coAddress = coAddress;
	}
	public void getCompanyInfo() {
		System.out.println(this);		
	}	
}
