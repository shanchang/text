package service;

import model.Account;
import control.AccountControl;


public class LoginService {
	
	public int isAccount(String id,String key){
		
		Account account=AccountControl.getAccountControl().getAccountId(id);
		if(account==null){
			return -1;
		}
		else{
			if(key.equals(account.getCustomerKey())){
				return 1;
			}
			else {
				return 2;
			}
		}		
	}
	public int isState(String accountId){
		
		if(AccountControl.getAccountControl().getState(accountId)!=1){
			return -1;   //冻结
		}
		else{
			return 1;   //正常
		}
		
	}
	
	
	
}
