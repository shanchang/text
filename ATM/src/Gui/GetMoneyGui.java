package Gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import service.MainGuiServer;
import control.ConsumeControl;
import javax.swing.JLabel;

public class GetMoneyGui extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	MainGuiServer mainGuiServer=new MainGuiServer();
	

	/**
	 * Create the frame.
	 */
	public GetMoneyGui(String account_ID) {
		final String accountID=account_ID;
		setTitle("ATM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("100");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainGuiServer.saveBalance((double) 100, accountID,1);
				ConsumeControl.getConsumerControl().saveConsume(Long.valueOf(100), Long.valueOf(0), accountID);
			}
		});
		button.setBounds(29, 68, 95, 25);
		contentPane.add(button);
		
		JButton button_1 = new JButton("300");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainGuiServer.saveBalance((double) 300, accountID,1);
				ConsumeControl.getConsumerControl().saveConsume(Long.valueOf(300), Long.valueOf(0), accountID);
			}
		});
		button_1.setBounds(29, 129, 95, 25);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("500");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainGuiServer.saveBalance((double) 500, accountID,1);
				ConsumeControl.getConsumerControl().saveConsume(Long.valueOf(500), Long.valueOf(0), accountID);
			}
		});
		button_2.setBounds(315, 68, 95, 25);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("1000");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainGuiServer.saveBalance((double) 1000, accountID,1);
				ConsumeControl.getConsumerControl().saveConsume(Long.valueOf(1000), Long.valueOf(0), accountID);
			}
		});
		button_3.setBounds(315, 129, 95, 25);
		contentPane.add(button_3);
		
		textField = new JTextField();
		textField.setBounds(173, 129, 88, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton button_4 = new JButton("取款");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				if(textField.getText().equals("")){
					JOptionPane.showConfirmDialog(null, "请输入取款金额！","提示:", JOptionPane.CLOSED_OPTION);
				}
				else{
					Double money=(double) Integer.parseInt(textField.getText());
					Long getMoney=new Long(Integer.parseInt(textField.getText()));
					if(money%100!=0||money<=0){
						JOptionPane.showConfirmDialog(null, "请输入正确的金额！","提示:", JOptionPane.CLOSED_OPTION);
						
					}
					else if(money>2000){
						JOptionPane.showConfirmDialog(null, "取款的金额不能大于2000！","提示:", JOptionPane.CLOSED_OPTION);
						
					}
					else if(money>mainGuiServer.getAccountBalance(accountID)){
						JOptionPane.showConfirmDialog(null, "抱歉！您的余额不足！","提示:", JOptionPane.CLOSED_OPTION);
						
					}
					else{
						mainGuiServer.saveBalance(money, accountID,1);
						ConsumeControl.getConsumerControl().saveConsume(getMoney,Long.valueOf(0), accountID);
										
					}
						
				}
			}
			catch(Exception a){
				JOptionPane.showConfirmDialog(null, "请输入的正确格式金额！","提示:", JOptionPane.CLOSED_OPTION);
			}
				textField.setText(null);
			}
		});
		button_4.setBounds(29, 213, 95, 25);
		contentPane.add(button_4);
		
		JButton button_5 = new JButton("返回");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_5.setBounds(315, 213, 95, 25);
		contentPane.add(button_5);
		
		JLabel label = new JLabel("请输入能被100整除的数字，不能超过10位");
		label.setBounds(91, 175, 341, 15);
		contentPane.add(label);
	}
}
