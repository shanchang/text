package control;

import model.Account;

import DaO.AccountDAO;

public class AccountControl {
	
	private static AccountControl control = null; 
	private AccountDAO accountDAO = null;
	public static AccountControl getAccountControl(){
		if(null==control){
			control = new AccountControl();
		}
		return control;
	}
	public AccountControl() {
		accountDAO = new AccountDAO();
		
	}
	
	public Account getAccountId(String accountId){   
		if(accountDAO.findById(accountId)==null){
			return null;	
		}
		else{
			return accountDAO.findById(accountId);
			
		}
	}
	public int getState(String accountId){
		return accountDAO.findById(accountId).getState();
	}
	public void changeState(String accoundId){
		
		Account account=AccountControl.getAccountControl().getAccountId(accoundId);
		account.setState(0);
		accountDAO.save(account);
			
	}
	
}

	