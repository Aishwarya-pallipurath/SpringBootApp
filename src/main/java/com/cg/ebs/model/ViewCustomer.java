package com.cg.ebs.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;

@Entity
public class ViewCustomer {

	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "customer_id")
	private Integer id;

	@Column(name = "phone_no", nullable = false)
	private String phoneNo;
	@Id
	@Column(name = "email", nullable = false)
	private String email;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public ViewCustomer(Integer id, String phoneNo, String email) {
		super();
		this.id = id;
		this.phoneNo = phoneNo;
		this.email = email;
	}

	public ViewCustomer() {
		super();

	}

	@Override
	public String toString() {
		return "Customer [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
