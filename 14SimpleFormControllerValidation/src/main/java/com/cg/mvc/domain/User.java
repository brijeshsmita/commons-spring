package com.cg.mvc.domain;

public class User {

	private String name;
	private String email;
	private String profession;
	private String country;
	private String feedback;
	private String[] frameworks;
	private Boolean mailingList;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public String[] getFrameworks() {
		return frameworks;
	}

	public void setFrameworks(String[] frameworks) {
		this.frameworks = frameworks;
	}

	public Boolean getMailingList() {
		return mailingList;
	}

	public void setMailingList(Boolean mailingList) {
		this.mailingList = mailingList;
	}
}
