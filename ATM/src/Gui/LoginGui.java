package Gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import control.AccountControl;
import service.LoginService;

public class LoginGui extends JFrame {

	private JPanel contentPane;
	private JTextField text1;
	private JPasswordField text2;
	private int count=0;
	LoginService loginService=new LoginService();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGui frame = new LoginGui();
					frame.setVisible(true);				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginGui() {
		setTitle("登陆");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("账户ID：");
		label.setBounds(95, 46, 54, 15);
		contentPane.add(label);
		
		text1 = new JTextField();
		text1.setColumns(10);
		text1.setBounds(167, 43, 135, 21);
		contentPane.add(text1);
		
		JLabel label_1 = new JLabel("账户密码：");
		label_1.setBounds(95, 95, 66, 15);
		contentPane.add(label_1);
		
		text2 = new JPasswordField();
		text2.setBounds(167, 92, 135, 21);
		contentPane.add(text2);
		
		JButton button = new JButton("登陆");
		button.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			
				String accountID=text1.getText();
				String accountKey= new String(text2.getPassword());

				
				
				if(loginService.isAccount(accountID, accountKey)==-1){
					JOptionPane.showConfirmDialog(null, "用户名错误","提示:", JOptionPane.CLOSED_OPTION);
				}
				else{
					if(loginService.isState(accountID)==-1){
						JOptionPane.showConfirmDialog(null, "该账户已被冻结！！","提示:", JOptionPane.CLOSED_OPTION);
					}
					else{
						if(loginService.isAccount(accountID, accountKey)==2){
							JOptionPane.showConfirmDialog(null, "密码错误","提示:", JOptionPane.CLOSED_OPTION);
							count++;
							if(count==3){
								JOptionPane.showConfirmDialog(null, "密码错误3次，账户冻结！！","提示:", JOptionPane.CLOSED_OPTION);
								AccountControl.getAccountControl().changeState(accountID);
							}
						}
						else{  //密码正确
								dispose();
								MainGUI frame2= new MainGUI(accountID);
								frame2.setVisible(true);
						}
					}
					
					
				}
				text1.setText(null);
				text2.setText(null);
			}
		});
		button.setBounds(95, 173, 95, 25);
		contentPane.add(button);
		
		JButton button_1 = new JButton("取消");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_1.setBounds(207, 173, 95, 25);
		contentPane.add(button_1);
	}
}
