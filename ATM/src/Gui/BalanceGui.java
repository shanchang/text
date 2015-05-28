package Gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import service.MainGuiServer;

public class BalanceGui extends JFrame {

	private JPanel contentPane;
	MainGuiServer mainGuiServer=new MainGuiServer();

	/**
	 * Create the frame.
	 */
	public BalanceGui(String account_ID,String customerName) {
		setTitle("ATM");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 330, 223);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("余额：");
		label.setBounds(22, 113, 54, 15);
		contentPane.add(label);
		
		JLabel lblid = new JLabel("账户ID：");
		lblid.setBounds(22, 79, 54, 15);
		contentPane.add(lblid);
		
		JLabel lblNewLabel = new JLabel("客户：");
		lblNewLabel.setBounds(22, 47, 54, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(customerName);
		lblNewLabel_1.setBounds(68, 47, 54, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(account_ID);
		lblNewLabel_2.setBounds(68, 79, 86, 15);
		contentPane.add(lblNewLabel_2);
		//获得余额
		
		String balance=mainGuiServer.getAccountBalance(account_ID).toString();
		JLabel lblNewLabel_3 = new JLabel(balance);
		lblNewLabel_3.setBounds(68, 113, 86, 15);
		contentPane.add(lblNewLabel_3);
		
		JButton button = new JButton("返回");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button.setBounds(193, 42, 95, 25);
		contentPane.add(button);
		
		JButton button_1 = new JButton("退卡");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showConfirmDialog(null, "谢谢使用！","提示:", JOptionPane.CLOSED_OPTION);
				System.exit(0); 
			}
		});
		button_1.setBounds(193, 113, 95, 25);
		contentPane.add(button_1);
		
		
		
	}

}
