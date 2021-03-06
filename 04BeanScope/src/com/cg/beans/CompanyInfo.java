package com.cg.beans;
import com.cg.services.InformationService;
public class CompanyInfo implements InformationService{
	private String coName;
	private String coAddress;
	public void getCompanyInfo() {
		System.out.println(this);		
	}	
	public CompanyInfo() {
		System.out.println("Company Info defalut Constructor....");
	}
	
	public CompanyInfo(String coName, String coAddress) {
		super();
		this.coName = coName;
		this.coAddress = coAddress;
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
	
	@Override
	public String toString() {
		return "CompanyInfo [coName=" + coName + ", coAddress=" + coAddress
				+ "]";
	}
}
