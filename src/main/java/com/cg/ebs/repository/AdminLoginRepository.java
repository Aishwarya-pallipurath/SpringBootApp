package com.cg.ebs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.cg.ebs.model.Admin;

@Repository
public interface AdminLoginRepository extends JpaRepository<Admin, String>{
	@Query("select a from Admin a where a.email=:email")
	Admin findByEmail(@Param("email") String email);
}
