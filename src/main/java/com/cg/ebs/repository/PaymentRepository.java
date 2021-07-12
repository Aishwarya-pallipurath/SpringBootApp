package com.cg.ebs.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.ebs.model.Payment;
@Repository
public interface PaymentRepository extends CrudRepository<Payment,Integer> {
	Payment findByPaymentId(int paymentId);
}
