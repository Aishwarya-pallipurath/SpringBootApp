package com.cg.ebs.controller;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.cg.ebs.exception.ResourceNotFoundException;
import com.cg.ebs.model.BillUnit;
import com.cg.ebs.repository.BillUnitRepository;
import com.cg.ebs.service.BillUnitService;


@RestController
@RequestMapping("/api/billunit")
public class BillUnitController {
	
	private static Logger log = LogManager.getLogger(BillUnitController. class);

	
	@Autowired
	private BillUnitService billUnitService;
	
	@Autowired
	private BillUnitRepository billUnitRepository;
	
	@GetMapping("/viewallbillunits")
	public ResponseEntity<List<BillUnit>> getAllBillUnits() throws ResourceNotFoundException {
		log.info("getAllBillUnits() of BillUnitController");
		List<BillUnit> billunits = this.billUnitService.getAllBillUnits();
		if (billunits.isEmpty()) {
			throw new ResourceNotFoundException("No Bill Units added!");
		}

		return new ResponseEntity<List<BillUnit>>(billunits, HttpStatus.OK);
	}
	
	@PostMapping("/addbillunit")
	public ResponseEntity<BillUnit> addBillUnit(@RequestBody BillUnit billUnit) {
		log.info("addBillUnit() of BillUnitController");
		try {
			this.billUnitService.addBillUnit(billUnit);
			return ResponseEntity.status(HttpStatus.CREATED).body(billUnit);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
	@GetMapping("findbyemail/{email}")
	public ResponseEntity<BillUnit> findByEmail(@PathVariable String email) throws ResourceNotFoundException {
		log.info("findByEmail() of BillUnitController");
		BillUnit billUnits = billUnitService.findByEmail(email);
		if (billUnits == null) {
			throw new ResourceNotFoundException("Bill Unit not found for this Email: " + email);
		}
		return ResponseEntity.ok().body(billUnits);

	}

}
