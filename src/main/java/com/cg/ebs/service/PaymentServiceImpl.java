package com.cg.ebs.service;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.ebs.exception.PaymentException;

import com.cg.ebs.model.Payment;

import com.cg.ebs.repository.PaymentRepository;
@Service
@Transactional
class PaymentServiceImpl implements PaymentService {
	@Autowired
	private PaymentRepository paymentRepository;

	/**
	 * overriden the add payment method
	 * 
	 */
	public Payment addPayment(Payment payment) {
		
		return paymentRepository.save(payment);
	}

	/**
	 * overriden the delete payment method
	 */

	public Payment deletePayment(int paymentId)throws PaymentException {
		Payment payment=paymentRepository.findByPaymentId(paymentId);
		paymentRepository.deleteById(paymentId);
		return payment;
			}

	
	public Payment viewPaymentDetailsById(int paymentId)throws PaymentException{
		return paymentRepository.findByPaymentId(paymentId);
		
	}

	@Override
	public Iterable<Payment> getAllPayments() {
		// TODO Auto-generated method stub
		return paymentRepository.findAll();
	}

}
