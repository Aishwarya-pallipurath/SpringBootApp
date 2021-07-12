package com.cg.ebs.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Complaint {

	    @Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
	    private int complaint_no;
		private String complaint;
		private String comment;
		private String status;
		private long consumer_no;
		//@ManyToOne
		//private  Consumer consumer;
		
		
		public Complaint() {
			super();
		}
		
		public int getComplaint_no() {
			return complaint_no;
		}
		public void setComplaint_no(int complaint_no) {
			this.complaint_no = complaint_no;
		}
		public String getComplaint() {
			return complaint;
		}
		public void setComplaint(String complaint) {
			this.complaint = complaint;
		}
		public String getComment() {
			return comment;
		}
		public void setComment(String comment) {
			this.comment = comment;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}

		public long getConsumer_no() {
			return consumer_no;
		}

		public void setConsumer_no(long consumer_no) {
			this.consumer_no = consumer_no;
		}

		public Complaint(int complaint_no, String complaint, String comment, String status, long consumer_no) {
			super();
			this.complaint_no = complaint_no;
			this.complaint = complaint;
			this.comment = comment;
			this.status = status;
			this.consumer_no = consumer_no;
		}
		

	   
}
