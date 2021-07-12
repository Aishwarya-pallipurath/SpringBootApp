package com.cg.ebs.service;

import java.util.List;

import com.cg.ebs.model.BillUnit;

public interface BillUnitService {
	

	List<BillUnit> getAllBillUnits();

	BillUnit findByEmail(String email);

	BillUnit addBillUnit(BillUnit billUnit);


}
