package com.cg.mvc.model;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.cg.mvc.validator.Phone;

public class Customer {
	@SuppressWarnings("deprecation")
	public Customer(){
		birthday=new Date(1999, 11, 11);
	}

	@Size(min=2, max=30) 
    private String name;
     
    @NotEmpty @Email /*hibernate Validations*/
    private String email;
     
    @NotNull @Min(18) @Max(100)
    private Integer age;
     
    @NotNull
    private Gender gender;
     
    
    @NotNull @Past
    @DateTimeFormat(pattern="MM/dd/yyyy")
    private Date birthday;
    
    @Phone
    private String phone;
    
    public enum Gender {
		MALE, FEMALE
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}