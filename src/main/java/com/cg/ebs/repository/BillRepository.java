package com.cg.ebs.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cg.ebs.model.Bill;


public interface BillRepository extends CrudRepository<Bill,Integer>{

	@Query("select a from Bill a where a.consumerNo=:consumer_no")
	Bill findByConsumerNo(@Param("consumer_no")long consumerNo);

}
