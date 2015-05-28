package service;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Account;
import model.Consume;
import DaO.AccountDAO;
import control.AccountControl;
import control.ConsumeControl;

public class MainGuiServer {
	
	public Double getAccountBalance(String account_ID){
		Account account =AccountControl.getAccountControl().getAccountId(account_ID);
		return account.getBalance();
	}
	public void saveBalance(Double money,String accountID,int seq){
		
		MainGuiServer mainGuiServer=new MainGuiServer();
		Double balance;
		if(seq==1){
			 balance=mainGuiServer.getAccountBalance(accountID)-money;
		}
		else{
			 balance=mainGuiServer.getAccountBalance(accountID)+money;
		}
		Account account=AccountControl.getAccountControl().getAccountId(accountID);
		account.setBalance(balance);
		AccountDAO accountDAO=new AccountDAO();
		accountDAO.save(account);
		if(seq==1){
			JOptionPane.showConfirmDialog(null, "取款成功！","提示:", JOptionPane.CLOSED_OPTION);
		}
		else{
			JOptionPane.showConfirmDialog(null, "存款成功！","提示:", JOptionPane.CLOSED_OPTION);
		}
	}
	public void showConsume(String accountID,JTable table){
		List <Consume> list=ConsumeControl.getConsumerControl().getAccountId(accountID);
		DefaultTableModel table2 = (DefaultTableModel) table.getModel();
		table2.setRowCount(0);//清除原有行
		if(list.size()==0)
		{
		   JOptionPane.showConfirmDialog(null, "没有交易记录！！！","提示:", JOptionPane.CLOSED_OPTION);
		}
		else{
			for(int i=0;i<list.size();i++){
				String []temp=new String [4];
				temp[0]=list.get(i).getConsumerDate().toString();	
				temp[1]=accountID;
				temp[2]=String.valueOf(list.get(i).getGetMoney());	
			    temp[3]=String.valueOf(list.get(i).getSaveMoney());
				table2.addRow(temp);
			}
		}
		
	}

}
