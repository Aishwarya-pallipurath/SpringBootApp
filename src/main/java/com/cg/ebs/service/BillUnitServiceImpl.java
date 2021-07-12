package com.cg.ebs.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ebs.model.BillUnit;
import com.cg.ebs.repository.BillUnitRepository;

@Service
public class BillUnitServiceImpl implements BillUnitService {
	
	@Autowired
	private BillUnitRepository billUnitRepository;
	

	@Override
	public List<BillUnit> getAllBillUnits() {

		return this.billUnitRepository.findAll();
	}

	@Override
	public BillUnit addBillUnit(BillUnit billunit) {
		return this.billUnitRepository.save(billunit);
	}
	
	@Override
	public BillUnit findByEmail(String email) {
		BillUnit billunit = null;
		Optional<BillUnit> billUnits = this.billUnitRepository.findByEmail(email);
		if (billUnits.isPresent()) {
			billunit = billUnits.get();
		}
		return billunit;
	}

}
