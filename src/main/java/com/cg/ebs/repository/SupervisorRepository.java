package com.cg.ebs.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.cg.ebs.model.Supervisor;


@Repository
public interface SupervisorRepository extends JpaRepository<Supervisor, String> {
	@Query("select c from Supervisor c where c.email=:email")
	Supervisor findByEmail(@Param("email") String email);

	//	Supervisor findByEmail(String email);

}


