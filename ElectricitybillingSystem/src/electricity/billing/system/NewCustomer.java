package electricity.billing.system;

import java.awt.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NewCustomer  extends JFrame implements ActionListener{
	
	JTextField tfname,tfaddress,tfstate,tfcity,tfemail,tfphone;
	
	JButton next,cancel;
	JLabel meternumber;
	
	public NewCustomer() {
		// TODO Auto-generated constructor stub
		
		setSize(700,500);
		setLocation(400,100);
		JPanel p=new JPanel();
		p.setLayout(null);
		p.setBackground(new Color(173,216,230));
		add(p);
		
		JLabel heading =new JLabel("New Customer");
		heading.setFont(new Font("Tahoma",Font.BOLD,18));
		heading.setForeground(Color.BLACK);
		heading.setBounds(180,25,200,20);
		p.add(heading);
		
		JLabel lblname =new JLabel("Customer Name");
		lblname.setForeground(Color.BLACK);
		lblname.setBounds(100,80,100,20);
		p.add(lblname);
		
		tfname=new JTextField();
		tfname.setBounds(240,80,190,20);
		p.add(tfname);
		
		JLabel lblmeter =new JLabel("Meter Number");
		lblmeter.setForeground(Color.BLACK);
		lblmeter.setBounds(100,120,100,20);
		p.add(lblmeter);
		
		 meternumber=new JLabel();
		meternumber.setBounds(240,120,190,20);
		p.add(meternumber);
		
		Random ran =new Random();
		long number =ran.nextLong()%1000000;
		meternumber.setText("" +Math.abs(number));
		
		JLabel lbladdress =new JLabel("Address");
		lbladdress.setForeground(Color.BLACK);
		lbladdress.setBounds(100,160,100,20);
		p.add(lbladdress);
		
		tfaddress=new JTextField();
		tfaddress.setBounds(240,160,190,20);
		p.add(tfaddress);
		
		
		JLabel lblstate =new JLabel("State");
		lblstate.setForeground(Color.BLACK);
		lblstate.setBounds(100,200,100,20);
		p.add(lblstate);
		
		tfstate=new JTextField();
		tfstate.setBounds(240,200,190,20);
		p.add(tfstate);
		
		JLabel lblcity =new JLabel("City");
		lblcity.setForeground(Color.BLACK);
		lblcity.setBounds(100,240,100,20);
		p.add(lblcity);
		
		tfcity=new JTextField();
		tfcity.setBounds(240,240,190,20);
		p.add(tfcity);
		
		JLabel lblemail =new JLabel("Email");
		lblemail.setForeground(Color.BLACK);
		lblemail.setBounds(100,280,100,20);
		p.add(lblemail);
		
		tfemail=new JTextField();
		tfemail.setBounds(240,280,190,20);
		p.add(tfemail);
		
		JLabel lblphone =new JLabel("Phone Number");
		lblphone.setForeground(Color.BLACK);
		lblphone.setBounds(100,320,100,20);
		p.add(lblphone);
		
		tfphone=new JTextField();
		tfphone.setBounds(240,320,190,20);
		p.add(tfphone);
		
		
		
		next=new JButton("Next");
		next.setBounds(120,390,100,25);
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.addActionListener(this);
		p.add(next);
		
		
		
		cancel=new JButton("Cancel");
		cancel.setBounds(250,390,100,25);
		cancel.setBackground(Color.BLACK);
		cancel.setForeground(Color.WHITE);
		cancel.addActionListener(this);
		p.add(cancel);
		
		setLayout(new BorderLayout());
		add(p,"Center");
		ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("hicon1.jpg"));
		Image i2 =i1.getImage().getScaledInstance(150, 300,Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image= new JLabel(i3);
		add(image,"West");
		getContentPane().setBackground(Color.WHITE);
		
		setVisible(true);
		
	}

	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==next) {
			
			String name= tfname.getText();
			String meter =meternumber.getText();
			String address=tfaddress.getText();
			String city=tfcity.getText();
			String state= tfstate.getText();
			String email =tfemail.getText();
			String phone= tfphone.getText();
			
			String query="insert into customer values('"+name+"','"+meter+"','"+address+"','"+city+"','"+state+"','"+email+"','"+phone+"')";
			String query2="insert into login values('"+meter+"','','"+name+"','','')";
			
			try {
				
				Conn c=new Conn();
				c.s.executeUpdate(query);
				c.s.executeUpdate(query2);
				
				JOptionPane.showMessageDialog(null, "Customer Detial Added SUccessfully");
				setVisible(false);
				new Meterinfo(meter);
				
			}catch(Exception ae) {
				ae.printStackTrace();
			}
		}
		else {
			setVisible(false);
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new NewCustomer();
	}

	

}
