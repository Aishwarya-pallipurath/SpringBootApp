package com.cg.ebs.model;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
//@Embeddable
@Entity
public class BillUnit {
	

	@Id
	@Column(name = "meter_reading")
	private int billUnit;
	@Column(name = "date", nullable = false)
	private String date;
	@Column(name = "time", nullable = false)
	private String time;
	@Column(name = "email", nullable = false)
	private String email;
	
	public BillUnit() {
		super();
	}
	
	public BillUnit(String email, int billUnit, String date, String time) {
		super();
		this.email = email;
		this.billUnit = billUnit;
		this.date = date;
		this.time = time;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getBillUnit() {
		return billUnit;
	}

	public void setBillUnit(int billUnit) {
		this.billUnit = billUnit;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	@Override
	public String toString() {
		return "BillUnit [ email ="+ email +", date =" + date + ",time =" + time + "]";
	}


	
	
	

}
