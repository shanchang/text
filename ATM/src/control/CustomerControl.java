package control;

import java.util.List;

import model.Customer;

import DaO.CustomerDAO;

public class CustomerControl {
	
	private static CustomerControl control=null;
	private CustomerDAO customerDAO = null;
	public static CustomerControl getCustomerControl(){
		if(null==control){
			control = new CustomerControl();
		}
		return control;
	}
	
	public CustomerControl() {
		customerDAO = new CustomerDAO();
	}
	public String getCustomerName(String accountID){
		if(customerDAO.findByAccountId(accountID)==null){
			return null;
		}
		else{
			List<Customer> list=customerDAO.findByAccountId(accountID);
			return list.get(0).getCustomerName();
			
		}
		
	}

}
