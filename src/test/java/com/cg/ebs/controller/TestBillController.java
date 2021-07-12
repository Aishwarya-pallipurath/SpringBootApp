package com.cg.ebs.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.cg.ebs.model.Bill;
import com.cg.ebs.repository.BillRepository;
import com.cg.ebs.service.BillService;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;



@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = BillController.class)
public class TestBillController {
	 @Autowired
	    MockMvc mockMvc;

	     @MockBean
	    BillService billService;
	     
	     @MockBean
	     BillRepository billRepository;
	     /**
	 	 * this method tests the create bill operation
	 	 * @throws Exception
	 	 
	 	*/
	    @Test
	    public void testCreateBill() throws Exception {
	    	    Bill bill=new Bill();
		        bill.setBillAmount("567");
		        //bill.setBu("4637");
		        bill.setConsumerNo(1234567898);
		      //  bill.setConsumerType("lt");
		        bill.setUnits("567");
		        bill.setDueDate("25/01/2000");
		        bill.setBillMonth("April");


	       
	        String jsonInput = this.converttoJson(bill);

	        Mockito.when(billService.createBill(Mockito.any(Bill.class))).thenReturn(bill);
	        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post("/createNewBill")
	                .accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
	                .andReturn();
	        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	        String jsonOutput = mockHttpServletResponse.getContentAsString();
	        assertThat(jsonInput).isEqualTo(jsonOutput);
	        Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
	    }

	    /**
		 * this method tests the update bill operation
		 * @throws Exception
		 
		*/
	    @Test
	    public void testUpdateBill() throws Exception {
	    	Bill bill=new Bill();
	        bill.setBillAmount("567");
	        //bill.setBu("4637");
	         bill.setConsumerNo(1234567898);
	       // bill.setConsumerType("lt");
	        bill.setUnits("567");
	        bill.setDueDate("25/01/2000");
	        bill.setBillMonth("April");

	        String jsonInput=this.converttoJson(bill);
			  Mockito.when(billService.updateBillById(bill, 5)).thenReturn(bill);
			  MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.put("/update/{id}",5)
	                  .accept(MediaType.APPLICATION_JSON)
	                  .content(jsonInput)
	                  .contentType(MediaType.APPLICATION_JSON))
	                  .andReturn();
			  assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());

	    }
	    
	    /**
		 * this method tests the GetAllbills operation
		 */
	     @Test
		 void testGetAllBills() throws Exception {
			 
			 
	    	    Bill bill1=new Bill();
		        bill1.setBillAmount("567");
		      //  bill1.setBu("4637");
		       bill1.setConsumerNo(1234567898);
		        //bill1.setConsumerType("lt");
		        bill1.setUnits("567");
		        bill1.setDueDate("25/01/2000");
		        bill1.setBillMonth("April");
		        
		        Bill bill2=new Bill();
		        bill2.setBillAmount("567");
		       // bill2.setBu("4637");
		      bill2.setConsumerNo(1234567898);
		        //bill2.setConsumerType("lt");
		        bill2.setUnits("567");
		        bill2.setDueDate("25/01/2000");
		        bill2.setBillMonth("April");
			  
			  List<Bill> billList=new ArrayList<Bill>();
			  billList.add(bill1);
			  billList.add(bill2);		  
			  String jsonInput=this.converttoJson(billList);
			  Mockito.when(billService.getAllBills()).thenReturn(billList);
			  MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/getAllBills")
	                  .accept(MediaType.APPLICATION_JSON)
	                  .content(jsonInput)
	                  .contentType(MediaType.APPLICATION_JSON))
	                  .andReturn();
	                
	        assertEquals(HttpStatus.OK.value(),mvcResult.getResponse().getStatus());
			  
		 }
	     /**
	 	 * this method tests the findBillById operation
	 	 * @throws Exception
	 	 
	 	*/
	    @Test
		 void testFindBillById() throws Exception {
	        String uri="/getBillById/{bill_id}";
	    	Bill bill=new Bill();
	        bill.setBillAmount("567");
	       // bill.setBu("4637");
	       bill.setConsumerNo(1234567898);
	        //bill.setConsumerType("lt");
	        bill.setUnits("567");
	        bill.setDueDate("25/01/2000");
	        bill.setBillMonth("April");
	        bill.setBillId(1);
			  String jsonInput=this.converttoJson(bill);
			  try {
				  Mockito.when(billService.getBillById(1).get()).thenReturn(bill);  
			  MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(uri,1)
	                  .accept(MediaType.APPLICATION_JSON)
	                  .content(jsonInput)
	                  .contentType(MediaType.APPLICATION_JSON))
	                  .andReturn();
			
			 assertEquals(HttpStatus.OK.value(),mvcResult.getResponse().getStatus());
			  }
			  catch(Exception e) {
					 
		 }
	    }
	    
	    /**
		 * this method tests the delete bill operation
		 * @throws Exception
		 
		*/
	    @Test
		public void testDeleteBillById() throws Exception {
			String URI="/deleteBillById/{bill_id}";
			Bill bill=new Bill();
	        bill.setBillAmount("567");
	        //bill.setBu("4637");
	         bill.setConsumerNo(1234567898);
	        //bill.setConsumerType("lt");
	        bill.setUnits("567");
	        bill.setDueDate("25/01/2000");
	        bill.setBillMonth("April");
	        bill.setBillId(1);
	        try {
			Mockito.when(billService.getBillById(1).get()).thenReturn(bill);
		    Mockito.when(billRepository.findById(1).get()).thenReturn(bill);
			Mockito.when(billService.deleteBillById(1)).thenReturn("ujb");
		       this.mockMvc.perform(MockMvcRequestBuilders.delete(URI, 1).accept(MediaType.APPLICATION_JSON)).andReturn();
	        }
	        catch(Exception e) {
	        	
	        }

		}
  
	 
	 
	    private String converttoJson(Object restaurantdetails) throws JsonProcessingException {
	        ObjectMapper objectMapper = new ObjectMapper();
	        return objectMapper.writeValueAsString(restaurantdetails);
	    }

}
