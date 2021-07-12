package com.cg.ebs.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cg.ebs.model.Bill;
import com.cg.ebs.model.Consumer;
import com.cg.ebs.service.BillService;

import com.cg.ebs.exception.ResourceNotFoundException;


/**
 * A rest controller which handles all the URL request given by the application for the various services.
 * @author apurva
 *
 */
@RestController
@CrossOrigin
public class BillController {
	private static final Logger LOGGER = LogManager.getLogger(BillController.class);

	
	@Autowired
	private BillService billService;
	/**
	 * this method creates bill in to database
	 * @return object of bill
	 *  
	 */
	@PostMapping("/createNewBill")
	public Bill createBill( @RequestBody Bill bill) {
		LOGGER.info("Entered inside create method in controller");
		return billService.createBill(bill);
	}

	/**
	 * this method returns list of the bill details
	 * @return list of bills
	 */	
	@GetMapping("/getAllBills")
	public Iterable<Bill> getAllBills(){
		LOGGER.info("Entered inside get all method in controller");
		return billService.getAllBills();
	}
	
	/**
     * this method shows the bill details with respective to id
     * @param id of bill
     * @return bill object 
     * @throws ResourceNotFoundException 
     */
	@GetMapping("/getBillById/{bill_id}")
	public Optional<Bill> getBillById(@PathVariable(value="bill_id") Integer billId) throws ResourceNotFoundException{
		LOGGER.info("Entered inside get method in controller");
		billService.getBillById(billId)
		.orElseThrow(()->new ResourceNotFoundException("Bill not found for this id :" + billId));
		
		return billService.getBillById(billId);
	}
	
	/**
	 * this method deletes bill from database
	 * @param id of bill
	 * @return String 
	 * @throws ResourceNotFoundExcepion
	 */
	
	@DeleteMapping("/deleteBillById/{bill_id}")
	public String deleteBillById( @PathVariable(value = "bill_id") Integer billId) throws ResourceNotFoundException{
		LOGGER.info("Entered inside delete method in controller");
		billService.getBillById(billId)
		.orElseThrow(()->new ResourceNotFoundException("Bill not found for this id :" + billId));
		return billService.deleteBillById(billId);
	}
	

	@PostMapping("/validateConsumer")
	public String manageConsumer(@RequestBody Bill bill)throws ResourceNotFoundException
	{
		return billService.validateConsumer(bill);
	}
	
	/**
	 * this method updates bill into database
	 * @param id of bill
	 * @param Bill object to be updated 
	 * @return string
	 * @throws ResourceNotFoundException
	 */

	@PutMapping("/update/{id}")
	public ResponseEntity<Bill> updateBill(@RequestBody Bill bill ,@PathVariable int id) throws ResourceNotFoundException {
		LOGGER.info("Entered inside update method in controller");
		Bill updatedBill=billService.updateBillById(bill, id);
		return new ResponseEntity<Bill>(updatedBill,HttpStatus.OK);
		
	}

	

}
