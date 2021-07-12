package com.cg.ebs.service;


import com.cg.ebs.model.Payment;
import com.cg.ebs.exception.PaymentException;

public interface PaymentService {
	/**
	 * This method will add the payment
	 * @param payment
	 * @return payment
	 */
	public Payment addPayment(Payment payment);
	
	/**
	 * this method will delete the payment
	 * @param paymentId
	 */
	public Payment deletePayment(int paymentId)throws PaymentException;
	/**
	 * this method will provide payment details
	 * @param paymentId
	 * @return
	 * @throws PaymentIdNotFoundException
	 */
	
	public Payment viewPaymentDetailsById(int paymentId)throws PaymentException;
	public Iterable<Payment> getAllPayments();


}
