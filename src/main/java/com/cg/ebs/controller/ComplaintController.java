package com.cg.ebs.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.ebs.exception.ComplaintNotFoundException;
import com.cg.ebs.model.Complaint;
import com.cg.ebs.service.ComplaintService;

@RestController
@RequestMapping("/Complaint")
@CrossOrigin
public class ComplaintController {
	private static final Logger logger = LogManager.getLogger(ComplaintController.class);

	@Autowired
	private ComplaintService complaintService;
	
	@PostMapping("/InsertComplaint")
	public Complaint addComplaint(@RequestBody Complaint complaint)
	{
		logger.info(" Complaint is added successfully...!");
		return complaintService.acceptComplaint(complaint);
	}
	
	@PutMapping("/Comment/{id}")
	public Complaint updateComment(@PathVariable(value="id") int complaint_no,@RequestBody Complaint complaint)throws ComplaintNotFoundException
	{
		logger.info(" Comment is added successfully...!");
		return complaintService.updateComment(complaint_no, complaint);
	}
	
	@DeleteMapping("/DeleteComplaint/{id}")
	public ResponseEntity<String> deleteComplaint(@PathVariable(value="id") int complaint_no)throws ComplaintNotFoundException
	{
		 String result= "Complaint with Id : "+complaint_no+"NOT FOUND!";

		Complaint complaint =  complaintService.getComplaintDetails(complaint_no);
		if(complaint .toString()!= "Complaint NOT FOUND !!!")
		{
			complaintService.deleteComplaint(complaint_no);
			  result= "Complaint with Id : "+complaint_no+" Deleted Successfully!";
				logger.info(" DeleteComplaint   successfully...!");
		        return ResponseEntity.ok(result);
		}
		else {
			logger.info("NOT DELETED...!");
					return ResponseEntity.ok(result);
				}
	}
	
	@GetMapping("/Complaints")
	public List<Complaint> getAllComplaintss() 
	{
		logger.info(" getAllComplaintss...!");
		return complaintService.getAllComplaints();
	}
	
	@GetMapping("/GetComplaint/{id}")
	public Complaint GetComplaint(@PathVariable(value="id") int complaint_no) throws ComplaintNotFoundException 
	{
		logger.info("GetComplaints successfully...!");
		return complaintService.getComplaintDetails(complaint_no);
	}

	
}
