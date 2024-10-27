package electricity.billing.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

public class CustomerDetails extends JFrame implements ActionListener {

	
	Choice meternumber, cmonth;
	JTable table;
	JButton search,print;
	
	public CustomerDetails() {
		// TODO Auto-generated constructor stub
		super("Customer Details");
		
		setSize(1200,650);
		setLocation(30,30);
		
		table= new JTable();
		
		try {
			
			Conn c= new Conn();
			ResultSet rs=c.s.executeQuery("select * from customer");
			
			table.setModel(DbUtils.resultSetToTableModel(rs));
			

		}catch(Exception ec) {
			ec.printStackTrace();
		}
		
		JScrollPane sp= new JScrollPane(table);
		
		add(sp);
		
		
		
		print= new JButton("Print");
		
		print.addActionListener(this);
		add(print,"South");
		
		setVisible(true);
		
		
		
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
			try {
				table.print();
			
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CustomerDetails();
	}

	

}
