package control;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import model.Consume;

import DaO.ConsumeDAO;

public class ConsumeControl {
	private static ConsumeControl control = null; 
	private ConsumeDAO consumeDAO = null;
	public static ConsumeControl getConsumerControl(){
		if(null==control){
			control = new ConsumeControl();
		}
		return control;
	}

	
	public ConsumeControl() {
		consumeDAO = new ConsumeDAO();
	
	}
	public Consume saveConsume(Long getMoney,Long saveMoney,String accountId){
		
		//得到系统当前时间
		Date date = new Date();
		SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String consumerDate = df1.format(date);
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		ts = Timestamp.valueOf(consumerDate);
		
		Consume consume=new Consume(ts, accountId, saveMoney, getMoney);	
		consumeDAO.save(consume);
		return consume;
	}
	public List getAccountId(String accountId ){
		List list= consumeDAO.findByAccountId(accountId);
		return list;
	}
	   
	
	

}
