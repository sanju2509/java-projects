
package electricity.billing.system;

import java.awt.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculateBill  extends JFrame implements ActionListener{
	
	JTextField tfname,tfaddress,tfstate,tfunits,tfemail,tfphone;
	
	JButton next,cancel;
	JLabel lblname,labeladdress,lblmeter;
	Choice meternumber,cmonth;
	
	public CalculateBill() {
		// TODO Auto-generated constructor stub
		
		setSize(700,500);
		setLocation(400,100);
		JPanel p=new JPanel();
		p.setLayout(null);
		p.setBackground(new Color(173,216,230));
		add(p);
		
		JLabel heading =new JLabel("Calculate Elctricity Bill");
		heading.setFont(new Font("Tahoma",Font.BOLD,18));
		heading.setForeground(Color.BLACK);
		heading.setBounds(100,25,400,20);
		p.add(heading);
		
		JLabel lblmeternumber =new JLabel("Meter Number");
		lblmeternumber.setForeground(Color.BLACK);
		lblmeternumber.setBounds(100,80,100,20);
		p.add(lblmeternumber);
		
		meternumber=new Choice();
		try {
			
			Conn c= new Conn();
			ResultSet rs=c.s.executeQuery("select * from customer");
			
			while(rs.next()) {
				
				meternumber.add(rs.getString("Meter_no"));
			}
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		meternumber.setBounds(240,80,190,20);
		p.add(meternumber);
		
		
		JLabel lblmeter =new JLabel("Name");
		lblmeter.setForeground(Color.BLACK);
		lblmeter.setBounds(100,120,100,20);
		p.add(lblmeter);
		
		 lblname=new JLabel("");
		 lblname.setBounds(240,120,190,20);
		p.add(lblname);
		
		
		
		JLabel lbladdress =new JLabel("Address");
		lbladdress.setForeground(Color.BLACK);
		lbladdress.setBounds(100,160,100,20);
		p.add(lbladdress);
		
		labeladdress=new JLabel();
		labeladdress.setBounds(240,160,190,20);
		p.add(labeladdress);
		
		try {
			
			Conn c= new Conn();
			ResultSet rs=c.s.executeQuery("select * from customer where meter_no ='"+meternumber.getSelectedItem()+"'");
			while(rs.next()) {
				lblname.setText(rs.getString("name"));
				labeladdress.setText(rs.getString("address"));
			}
		}catch(Exception ae) {
			ae.printStackTrace();
		}
		meternumber.addItemListener(new ItemListener() {
			 
			public void itemStateChanged(ItemEvent ie) {
				
				
				try {
					
					Conn c= new Conn();
					ResultSet rs=c.s.executeQuery("select * from customer where meter_no ='"+meternumber.getSelectedItem()+"'");
					while(rs.next()) {
						lblname.setText(rs.getString("name"));
						labeladdress.setText(rs.getString("address"));
					}
				}catch(Exception ae) {
					ae.printStackTrace();
				}
			}
		});
		
		JLabel lblstate =new JLabel("Units Consumed");
		lblstate.setForeground(Color.BLACK);
		lblstate.setBounds(100,200,100,20);
		p.add(lblstate);
		
		tfunits=new JTextField();
		tfunits.setBounds(240,200,190,20);
		p.add(tfunits);
		
		JLabel lblcity =new JLabel("Month");
		lblcity.setForeground(Color.BLACK);
		lblcity.setBounds(100,240,100,20);
		
		p.add(lblcity);
		
		cmonth=new Choice();
		cmonth.setBounds(240,240,190,20);
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

		p.add(cmonth);
		
		
		
		next=new JButton("Submit");
		next.setBounds(120,350,100,25);
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.addActionListener(this);
		p.add(next);
		
		
		
		cancel=new JButton("Cancel");
		cancel.setBounds(250,350,100,25);
		cancel.setBackground(Color.BLACK);
		cancel.setForeground(Color.WHITE);
		cancel.addActionListener(this);
		p.add(cancel);
		
		setLayout(new BorderLayout());
		add(p,"Center");
		ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("hicon2.jpg"));
		Image i2 =i1.getImage().getScaledInstance(150, 300,Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image= new JLabel(i3);
		add(image,"West");
		getContentPane().setBackground(Color.WHITE);
		
		setVisible(true);
		
	}

	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==next) {
			
			
			String meter =meternumber.getSelectedItem();
			String units=tfunits.getText();
			String month=cmonth.getSelectedItem();
			
			int totalbill=0;
			int units_consumed=Integer.parseInt(units);
			String query="select * from tax";
			
			try {
				
				Conn c=new Conn();
				ResultSet rs=c.s.executeQuery(query);

				while(rs.next()) {
					
					totalbill+=units_consumed* Integer.parseInt(rs.getString("cost_per_unit"));
					totalbill+= Integer.parseInt(rs.getString("meter_rent"));
					totalbill+=Integer.parseInt(rs.getString("service_charge"));
					totalbill+=Integer.parseInt(rs.getString("service_tax"));
					totalbill+=Integer.parseInt(rs.getString("swach_bharat_cess"));
					totalbill+=Integer.parseInt(rs.getString("fixed_tax"));

					
				}
			}catch(Exception ae) {
				ae.printStackTrace();
			}
				
				String query2="insert into bill values('"+meter+"','"+month+"','"+units+"','"+totalbill+"','Not Paid')";
				try {
					
					Conn c=new Conn();
					c.s.executeUpdate(query2);
					JOptionPane.showMessageDialog(null, "Customer Bill Updated Successfully");
					setVisible(false);
				}catch(Exception ec) {
					ec.printStackTrace();
				}
				
				
			
		}
		else {
			setVisible(false);
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CalculateBill();
	}

	

}

