package com.cg.ebs.service;

import java.util.Optional;

import javax.transaction.Transactional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.ebs.controller.BillController;
import com.cg.ebs.model.Bill;
import com.cg.ebs.model.Consumer;
import com.cg.ebs.repository.BillRepository;
import com.cg.ebs.exception.ResourceNotFoundException;
/**
 * Class which provide all the services related to bill.
 * @author apurva
 *
 */
@Service
@Transactional
public class BillService {
	private static final Logger LOGGER = LogManager.getLogger(BillService.class);
	
	@Autowired
	private BillRepository billRepository;
	/**
	 * Stores the bill related data in the database.
	 * @param bill
	 * @return the saved instance of the bill if successfully saved else throw suitable exception.
	 */
	public Bill createBill(Bill bill) {
		LOGGER.info("Entered inside create method in service");
		return billRepository.save(bill);
		
	}
	
	
	/**
     * this method shows the bill details with respective to id
     * @param id of bill
     * @return bill object 
     * @throws ResourceNotFoundException 
     */
	public Optional<Bill> getBillById(Integer billId) {
		LOGGER.info("Entered inside get method in service");
		return billRepository.findById(billId);
	}
	
	/**
	 * Deletes the bill related data in the database.
	 * @param billId
	 * @return string message 
	 * @throws ResourceNotFoundException
	 */
	public String deleteBillById(Integer billId) {
		LOGGER.info("Entered inside delete method in service");
		Bill bill=billRepository.findById(billId).get();
		if(bill == null)
			return "Bill for id" + billId + "does not exists";
		billRepository.deleteById(billId);
		return "Bill for id" + billId + "deleted successfully";
	}
	
	/**
	 * this method returns list of the bill details
	 * @return list of bills
	 */	
	public Iterable<Bill> getAllBills(){
		LOGGER.info("Entered inside get all method in controller");
		return billRepository.findAll();
	}
	/**
	 * updates the bill related data in the database.
	 * @param object of Bill
	 * @param billId
	 * @return object of Bill
	 * @throws ResourceNotFoundException
	 */
	public Bill updateBillById(Bill bill,Integer billId) throws com.cg.ebs.exception.ResourceNotFoundException {
		LOGGER.info("Entered inside update method in controller");
		Bill bill1=billRepository.findById(billId).get();
		if(bill1!=null) {
		bill1.setBillAmount(bill.getBillAmount());
		//bill1.setConsumerType(bill.getConsumerType());
		//bill1.setConsumerNumber(bill.getConsumerNumber());
		//bill1.setBu(bill.getBu());
		bill1.setUnits(bill.getUnits());
		bill1.setDueDate(bill.getDueDate());
		
		return billRepository.save(bill1);
	}
		else {
			throw new ResourceNotFoundException("Unable  to find bill for given id");
		}
	
	 		  }
	
	public String validateConsumer(Bill bill) throws ResourceNotFoundException
	{	
		
	//	logger.info("in ConsumerServiceImpl of ValidateConsumer");
		//logger.info("out ConsumerServiceImpl of ValidateConsumer");
		
		String str = "";
		long consumer_no = bill.getConsumerNo();
		//String state = consumer.getState();
		//String board = consumer.getBoard();
		//String address = consumer.getAddress();
		Bill consumerList = billRepository.findByConsumerNo(consumer_no);
		
	//	if(consumerList==null)
		//{
			//str = "consumer does not exist";
	//	}
		if(consumerList!=null)
		{
		//	if(/*consumerList.getState().equals(state) && consumerList.getBoard().equals(board)*/ && consumerList.getAddress().equals(address))
			//{
		//		str = "Valid";
			//}
			//else if( ! consumerList.getState().equals(state) && consumerList.getBoard().equals(board) && consumerList.getAddress().equals(address))
			//{
				//str = "Invalid";
			//}
			if(consumerList.getConsumerNo()==consumer_no) {
				
				str="Valid";
				
				
			}
			else
			{
				str = "Incorrect";
			}
		}
		return str;
		
		
	}

		
	
	
	

}
