package com.cg.ebs.controller;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.ebs.model.Payment;
import com.cg.ebs.MapValidationErrorService;
import com.cg.ebs.exception.PaymentException;
import com.cg.ebs.service.PaymentService;
@RestController
@RequestMapping("/api/v2")
@CrossOrigin
public class PaymentController {
	private static final Logger LOGGER = LogManager.getLogger(PaymentController.class);
	@Autowired
	private PaymentService paymentService;
	@Autowired
	private MapValidationErrorService mapValidationErrorService;
	@PostMapping("/Payment")
	public ResponseEntity<?> addPayment(@Valid @RequestBody Payment payment,BindingResult result){
		LOGGER.info("Entered inside add method of payment controller");
		ResponseEntity<?> errorMap=mapValidationErrorService.mapValidationService(result);
		if(errorMap!=null) {
			return errorMap;
		}
		Payment newPayment=paymentService.addPayment(payment);
		return new ResponseEntity<>(newPayment,HttpStatus.CREATED);
		
	}
	@DeleteMapping("/Payment/{paymentId}")
	public ResponseEntity<String> deletePayment(@PathVariable int paymentId)throws PaymentException {
		LOGGER.info("Entered inside delete method of payment controller");
		paymentService.deletePayment(paymentId);
		return new ResponseEntity<>("Payment with Id : "+paymentId+" id deleted.....", HttpStatus.OK);
		
	}
	@GetMapping("/Payment/{paymentId}")
	public ResponseEntity<Payment> viewPaymentById(@PathVariable int paymentId)throws PaymentException {
		LOGGER.info("Entered inside get method of payment controller");
		return new ResponseEntity<>(paymentService.viewPaymentDetailsById(paymentId),HttpStatus.OK);
		
	}
	@GetMapping("/allPayments")
	public Iterable<Payment> getAllPayments(){
		LOGGER.info("Entered inside get all method of payment controller");
		return paymentService.getAllPayments();
	}

}
