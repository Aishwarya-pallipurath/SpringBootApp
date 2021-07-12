package com.cg.ebs.service;

import java.util.List;

import com.cg.ebs.controller.ComplaintController;
import com.cg.ebs.exception.ComplaintNotFoundException;
import com.cg.ebs.model.Complaint;
import com.cg.ebs.repository.ComplaintRepository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
/**
 * A rest controller which handles all the URL request given by the application for the various services.
 * @author Mayuri
 *
 */
@Service
@Transactional
public class ComplaintServiceImpl implements ComplaintService {

	private static final Logger logger = LogManager.getLogger(ComplaintController.class);

	@Autowired
	private ComplaintRepository  complaintRepository;
	
	@Override
	public Complaint acceptComplaint(Complaint complaint) {
		logger.info("accept complaint");
		return complaintRepository.save(complaint);
	}

	@Override
	public Complaint getComplaintDetails(int complaint_no) throws ComplaintNotFoundException {
		logger.info("getComplaintDetails");
		return complaintRepository.findById(complaint_no).orElseThrow(()->new ComplaintNotFoundException("Complaint NOT FOUND !!!"));
	}

	@Override
	public List<Complaint> getAllComplaints() {
		logger.info("getAllComplaints");
		return (List<Complaint>) complaintRepository.findAll();
	}

	@Override
	public boolean deleteComplaint(@PathVariable int complaint_no) throws ComplaintNotFoundException {
	Complaint complaint = complaintRepository.findById(complaint_no).orElseThrow(()->new  ComplaintNotFoundException("Complaint Number : "+complaint_no+"NOT Available!!!"));
	complaintRepository.delete(complaint);
	logger.info("deleteComplaint");
	return true;
	}

	@Override
	public Complaint updateComment(@PathVariable int complaint_no,@RequestBody Complaint complaint) throws ComplaintNotFoundException
   {
	   Complaint complaintFound = complaintRepository.findById(complaint_no).orElseThrow(()->new ComplaintNotFoundException("Unable to get details of Complaint Number : " +complaint_no));		
	  
		  complaintFound.setComment(complaint.getComment());
		  complaintFound.setStatus(complaint.getStatus());
			logger.info("updateComment");
		return complaintRepository.save(complaintFound);
	 

}
/*
 * @Override public Complaint getStatusComplaint(int complaint_no) throws
 * ComplaintNotFoundException { return
 * complaintRepository.findById(complaint_no).orElseThrow(()->new
 * ComplaintNotFoundException("Complaint NOT FOUND !!!")); }
 */

	@Override
	public Complaint getStatusComplaint(int complaint_no) throws ComplaintNotFoundException {
		return null;
	}


}
