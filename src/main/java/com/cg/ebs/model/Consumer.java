package com.cg.ebs.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "manage_consumer")
public class Consumer {

	@Id
	private long consumer_id;
	private String state;
	private String board;
	private String address;
//	@OneToOne(mappedBy = "consumer")
  //   private Bill bill;
	//@OneToMany(mappedBy = "consumer")
//	private List<Complaint> complaints;    
	//@OneToOne(mappedBy = "consumer")
	//private Payment payment;    

	public Consumer()
	{
			
	}
	
	public Consumer(long  consumer_id, String state, String board,String address) {
		this.consumer_id = consumer_id;
		this.state = state;
		this.board = board;
		this.address = address;
	}

	public long getConsumerId() {
		return consumer_id;
	}

	public void setConsumerId(long consumer_id) {
		this.consumer_id = consumer_id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getBoard() {
		return board;
	}

	public void setBoard(String board) {
		this.board = board;
	}
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
}