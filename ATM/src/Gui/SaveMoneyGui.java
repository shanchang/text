package Gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import service.MainGuiServer;
import control.ConsumeControl;

public class SaveMoneyGui extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	MainGuiServer mainGuiServer=new MainGuiServer();

	/**
	 * Create the frame.
	 */
	public SaveMoneyGui(String account_ID) {
		final String accountID=account_ID;
		setTitle("ATM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 345, 236);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("请输存入的金额：");
		label.setBounds(47, 61, 122, 15);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(179, 58, 74, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("确定");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if(textField.getText().equals("")){
					JOptionPane.showConfirmDialog(null, "请输入存款金额！","提示:", JOptionPane.CLOSED_OPTION);
					}
					else{
						Double money=(double) Integer.parseInt(textField.getText());
						Long saveMoney=new Long(Integer.parseInt(textField.getText()));
						if(money%100!=0||money<=0){
						JOptionPane.showConfirmDialog(null, "请输入正确的金额！","提示:", JOptionPane.CLOSED_OPTION);
						
						}
						else if(money>2000){
						JOptionPane.showConfirmDialog(null, "存款的金额不能大于2000！","提示:", JOptionPane.CLOSED_OPTION);
						
						}
						else{
						mainGuiServer.saveBalance(money, accountID,2);
						ConsumeControl.getConsumerControl().saveConsume(Long.valueOf(0), saveMoney, accountID);
						}						
					}
			    }
				catch(Exception a){
				JOptionPane.showConfirmDialog(null, "请输入的正确格式金额！","提示:", JOptionPane.CLOSED_OPTION);
				}
				textField.setText(null);			
			}
		});
		button.setBounds(47, 128, 95, 25);
		contentPane.add(button);
		
		JButton button_1 = new JButton("返回");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_1.setBounds(179, 128, 95, 25);
		contentPane.add(button_1);
		
		JLabel label_1 = new JLabel("请输入能被100整除的数，不超过10位");
		label_1.setBounds(81, 89, 229, 15);
		contentPane.add(label_1);
	}
}
