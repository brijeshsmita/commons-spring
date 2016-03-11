package com.cg.jshcart.model.contactus;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="ContactUs", schema="jshcart")
public class ContactUs  implements Serializable{

private static final long serialVersionUID = -141578284094202155L;
@Id
@Column(name="id")
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
private String name;
private String email;
private String phoneNo;

public ContactUs() {
	// TODO Auto-generated constructor stub
}

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

public String getPhoneNo() {
	return phoneNo;
}

public void setPhoneNo(String phoneNo) {
	this.phoneNo = phoneNo;
}

@Override
public String toString() {
	return "ContactUs [name=" + name + ", email=" + email + ", phoneNo="
			+ phoneNo + "]";
}


}
