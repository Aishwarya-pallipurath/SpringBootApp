package com.cg.ebs.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.ebs.model.*;

@Repository
public interface ConsumerRepository extends JpaRepository<Consumer, Long> {
	@Query("select a from Consumer a where a.consumer_id=:consumer_id")
	Consumer findByConsumerId(@Param("consumer_id")long consumer_id);
}



