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

public class DepositDetails extends JFrame implements ActionListener {

	
	Choice meternumber, cmonth;
	JTable table;
	JButton search,print;
	
	public DepositDetails() {
		// TODO Auto-generated constructor stub
		super("Deposit Details");
		
		setSize(700,700);
		setLocation(400,100);
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		
		JLabel lblmeternumber=new JLabel("Search By Meter Number");
		lblmeternumber.setBounds(20,20,150,20);
		add(lblmeternumber);
		
		meternumber =new Choice();
		meternumber.setBounds(180,20,150,20);
		add(meternumber);
		
		try {
			
			Conn c=new Conn();
			ResultSet rs=c.s.executeQuery("select * from customer");
			while(rs.next()) {
				meternumber.add(rs.getString("meter_no"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		JLabel lblmonth=new JLabel("Search By Month");
		lblmonth.setBounds(400,20,100,20);
		add(lblmonth);
		
		cmonth =new Choice();
		cmonth.setBounds(520,20,150,20);
		
		cmonth.add("January");
		cmonth.add("February");
		cmonth.add("March");
		cmonth.add("April");
		cmonth.add("May");
		cmonth.add("June");
		cmonth.add("July");
		cmonth.add("August");
		cmonth.add("September");
		cmonth.add("october");
		cmonth.add("November");
		cmonth.add("December");
		add(cmonth);
		
		table= new JTable();
		
		try {
			
			Conn c= new Conn();
			ResultSet rs=c.s.executeQuery("select * from bill");
			
			table.setModel(DbUtils.resultSetToTableModel(rs));
			

		}catch(Exception ec) {
			ec.printStackTrace();
		}
		
		JScrollPane sp= new JScrollPane(table);
		sp.setBounds(0,100,700,600);
		add(sp);
		
		search= new JButton("Search");
		search.setBounds(20,70,80,20);
		search.addActionListener(this);
		add(search);
		
		print= new JButton("Print");
		print.setBounds(120,70,80,20);
		print.addActionListener(this);
		add(print);
		
		setVisible(true);
		
		
		
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==search) {
			String query1="select * from bill where meter_no ='"+ meternumber.getSelectedIndex()+"' and month ='"+cmonth.getSelectedItem()+"'";
			
			try {
				
				Conn c= new Conn();
				ResultSet rs=c.s.executeQuery(query1);
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
				
			}catch(Exception ep) {
				ep.printStackTrace();
			}
			
		} else {
			try {
				table.print();
			
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new DepositDetails();
	}

	

}
