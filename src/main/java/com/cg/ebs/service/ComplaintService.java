package com.cg.ebs.service;

import java.util.List;

import com.cg.ebs.exception.ComplaintNotFoundException;
import com.cg.ebs.model.Complaint;
public interface ComplaintService {
//Complaint
	Complaint acceptComplaint(Complaint complaint);
	Complaint getComplaintDetails(int complaint_no) throws ComplaintNotFoundException;
	List<Complaint> getAllComplaints();
	boolean deleteComplaint(int complaint_no) throws ComplaintNotFoundException;

//Comment
	Complaint updateComment(int complaint_no,Complaint complaint) throws ComplaintNotFoundException;
	
//Get Status Of Complaint
//	Complaint updateStatus(int complaint_no) throws ComplaintNotFoundException;
	Complaint getStatusComplaint(int complaint_no) throws ComplaintNotFoundException;

}
