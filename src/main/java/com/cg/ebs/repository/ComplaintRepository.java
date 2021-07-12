package com.cg.ebs.repository;

import org.springframework.data.repository.CrudRepository;

import com.cg.ebs.model.Complaint;

public interface ComplaintRepository extends CrudRepository<Complaint,Integer> {

}
