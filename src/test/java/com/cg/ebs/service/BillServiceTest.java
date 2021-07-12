package com.cg.ebs.service;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import com.cg.ebs.exception.ResourceNotFoundException;
import com.cg.ebs.model.Bill;
import com.cg.ebs.repository.BillRepository;
import org.junit.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BillServiceTest {
	
	@Autowired
    private BillService billService;
	  @MockBean
	    private BillRepository billRepository;
	  
	  @Test
	    void testCreateBill() {
	        Bill bill=new Bill();
	        bill.setBillAmount("567");
	        bill.setUnits("567");
	        bill.setDueDate("25/01/2000");
	        bill.setBillMonth("April");
	               Mockito.when(billRepository.save(bill)).thenReturn(bill);
	        assertThat(billService.createBill(bill)).isEqualTo(bill);
	            
	        }
	  @Test
      void testDeleteBillById() throws ResourceNotFoundException {
      	Bill bill=new Bill();
	        bill.setBillAmount("567");
	        bill.setUnits("567");
	        bill.setDueDate("25/01/2000");
	        bill.setBillMonth("April");
      Assert.assertTrue(billRepository.findById(1).isPresent());                     
  }  
	  @Test
      void testGetAllBills() throws ResourceNotFoundException {
        Bill bill=new Bill();
        bill.setBillAmount("567");
	        bill.setUnits("567");
	        bill.setDueDate("25/01/2000");
	        bill.setBillMonth("April"); 
	        
	        Bill bill1=new Bill();
        bill1.setBillAmount("567");
 
        bill1.setUnits("567");
        bill.setDueDate("25/01/2000");
        bill1.setBillMonth("April");
        
        List<Bill> billList = new ArrayList<>();
        billList.add(bill1);
	    billList.add(bill);
	    Mockito.when(billRepository.findAll()).thenReturn(billList);
	    assertEquals(billService.getAllBills(),billList);
    }
	  @Test
      void testUpdateBillById() throws ResourceNotFoundException {
      	Bill bill=new Bill();
	        bill.setBillAmount("567");
	     //   bill.setBu("4637");
	      //  bill.setConsumerNumber("1234567898");
	       // bill.setConsumerType("lt");
	        bill.setUnits("567");
	        bill.setDueDate("25/01/2000");
	        bill.setBillMonth("April"); 
	        bill.setBillId(1);
	        try {
	        Mockito.when(billRepository.findById(1).get()).thenReturn(bill);
	     // bill.setBu("46389");
		    bill.setBillMonth("may");
		  Mockito.when(billRepository.save(bill)).thenReturn(bill);
		  assertThat(billService.updateBillById(bill,1)).isEqualTo(bill);
	        }
	        catch(Exception e) {
	        	
	        }
		   
      }
	   @Test
   	void testFindBillById() throws ResourceNotFoundException {
   		Bill bill=new Bill();		 
   		bill.setBillAmount("567");
 	       // bill.setBu("4637");
 	      //  bill.setConsumerNumber("1234567898");
 	        //bill.setConsumerType("lt");
 	        bill.setUnits("567");
 	        bill.setDueDate("25/01/2000");
 	        bill.setBillMonth("April"); 
           bill.setBillId(1);
   		//  Integer billId=bill.getBillId();
           try {
   		Mockito.when(billRepository.findById(1).get()).thenReturn(bill);
   		assertThat(billService.getBillById(1)).isEqualTo(bill);

           }
           catch(Exception e)
           {
           	
           }
   		
   	}
      
}
