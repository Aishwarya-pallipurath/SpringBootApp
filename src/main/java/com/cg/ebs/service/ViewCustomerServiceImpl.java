package com.cg.ebs.service;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.ebs.model.ViewCustomer;
import com.cg.ebs.repository.ViewCustomerRepository;

@Service
public class ViewCustomerServiceImpl implements ViewCustomerService {
	private static final Logger logger = LoggerFactory.getLogger(ViewCustomerServiceImpl.class);

	@Autowired
	private ViewCustomerRepository viewCustomerRepository;

	@Override
	public List<ViewCustomer> getAllCustomers() {
		logger.info("getAllCustomer() of ViewCustomerServiceImpl");

		return this.viewCustomerRepository.findAll();
	}


	@Override
	public ViewCustomer findByEmail(String email) {
		logger.info("findByEmail() of ViewCustomerServiceImpl");
		return viewCustomerRepository.findByEmail(email);
	}

}
