package Gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.CustomerControl;

public class MainGUI extends JFrame {

	private JPanel contentPane;

	

	/**
	 * Create the frame.
	 */
	public MainGUI(String accountID) {
		setTitle("ATM");
		final String account_ID=accountID;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("尊敬的客户：");
		label.setBounds(60, 34, 89, 15);
		contentPane.add(label);
		//得到用户名显示在界面
	    final String customerName=CustomerControl.getCustomerControl().getCustomerName(accountID);
		JLabel label_1 = new JLabel(customerName);
		label_1.setBounds(159, 34, 60, 15);
		contentPane.add(label_1);
		
		JButton button = new JButton("取钱");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GetMoneyGui getMoneyGui=new GetMoneyGui(account_ID);
				getMoneyGui.setVisible(true);
				
			}
		});
		button.setBounds(55, 66, 95, 25);
		contentPane.add(button);
		
		JButton button_1 = new JButton("存钱");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaveMoneyGui saveMoneyGui=new SaveMoneyGui(account_ID);
				saveMoneyGui.setVisible(true);
			}
		});
		button_1.setBounds(55, 115, 95, 25);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("退卡");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showConfirmDialog(null, "谢谢使用！","提示:", JOptionPane.CLOSED_OPTION);
				dispose();
			}
		});
		button_2.setBounds(290, 66, 95, 25);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("查询余额");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BalanceGui balanceGui=new BalanceGui(account_ID,customerName);
				balanceGui.setVisible(true);
			}
		});
		button_3.setBounds(55, 168, 95, 25);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("查询交易明细");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsumerGui consumerGui=new ConsumerGui(account_ID);
				consumerGui.setVisible(true);
			}
		});
		button_4.setBounds(55, 222, 129, 25);
		contentPane.add(button_4);
		
	
		
	}

}
