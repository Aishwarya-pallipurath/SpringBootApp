package com.cg.ebs.model;



import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.OneToOne;



@Entity

public class Bill {
	
	//@EmbeddedId
    //private BillUnit billUnit;
	
//	 @OneToOne
//	private  Consumer consumer;
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	public Integer billId;
	
	//public String consumerType;
	
	public String billAmount;
	public long consumerNo;
	
	
	public String units;
	
	public String dueDate;
	
	//public String bu;
		public String billMonth;
		
		public Integer getBillId() {
			return billId;
		}
		public void setBillId(Integer billId) {
			this.billId = billId;
		}
	
	public String getBillAmount() {
		return billAmount;
	}
	public void setBillAmount(String billAmount) {
		this.billAmount = billAmount;
	}
	public String getUnits() {
		return units;
	}
	public void setUnits(String units) {
		this.units = units;
	}
	public long getConsumerNo() {
		return consumerNo;
	}
	public void setConsumerNo(long consumerNo) {
		this.consumerNo = consumerNo;
	}
	
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	public String getBillMonth() {
		return billMonth;
	}
	public void setBillMonth(String billMonth) {
		this.billMonth = billMonth;
	}
	
	
	
	

}
