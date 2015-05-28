package Gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import service.MainGuiServer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsumerGui extends JFrame {

	private JPanel contentPane;
	private JTable table;
	MainGuiServer mainGuiServer=new MainGuiServer();
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public ConsumerGui(String account_ID) {
		setTitle("ATM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 38, 406, 176);
		contentPane.add(scrollPane);
		
		table = new JTable();
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
					
			},
			new String[] {
				"\u65E5\u671F", "\u8D26\u6237ID", "\u53D6\u94B1\u91D1\u989D", "\u5B58\u94B1\u91D1\u989D"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton button = new JButton("返回");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button.setBounds(254, 238, 95, 25);
		contentPane.add(button);
		
		//显示交易列表
		mainGuiServer.showConsume(account_ID, table);
		
		
		
	}
}
