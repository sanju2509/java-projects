package electricity.billing.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.border.*;

public class Signup extends JFrame implements ActionListener{
	 
	
	JButton create,back;
	Choice accountType;
	JTextField username,name,password,meter;
	JLabel lblmeter;
	Signup(){
		
		setBounds(400,150,700,400);
		getContentPane().setBackground(Color.CYAN);
		
		setLayout(null);
		
		JPanel panel =new JPanel();
		panel.setBounds(30,30,650,300);
		panel.setBorder(new TitledBorder(new LineBorder(new Color(128,0,255),2) ,"Create Account",TitledBorder.LEADING,TitledBorder.TOP,null, new Color(128,0,255)));
		panel.setBackground(Color.white);
		panel.setForeground(new Color(34,139,34));
		add(panel);
		panel.setLayout(null);
		
		
		JLabel heading =new  JLabel("Create Account");
		heading.setBounds(162,50,120,20);
		heading.setForeground(Color.BLACK);
		heading.setFont(new Font("Tahoma",Font.BOLD,14));
		panel.add(heading);
		
		accountType =new Choice();
		accountType.add("Admin");
		accountType.add("Customer");
		accountType.setBounds(290,50,140,20);
		
		panel.add(accountType);
		
		lblmeter =new  JLabel("Meter Number");
		lblmeter.setBounds(162,90,140,20);
		lblmeter.setForeground(Color.BLACK);
		lblmeter.setFont(new Font("Tahoma",Font.BOLD,14));
		lblmeter.setVisible(false);
		panel.add(lblmeter);
		
		 meter =new JTextField();
		meter.setBounds(290,90,140,20);
		meter.setVisible(false);
		panel.add(meter);
		
		
		
		JLabel lblusername =new  JLabel("Uesername");
		lblusername.setBounds(162,130,140,20);
		lblusername.setForeground(Color.BLACK);
		lblusername.setFont(new Font("Tahoma",Font.BOLD,14));
		panel.add(lblusername);
		
		username =new JTextField();
		username.setBounds(290,130,140,20);
		panel.add(username);
		
		
		JLabel lblname =new  JLabel("Name");
		lblname.setBounds(162,180,140,20);
		lblname.setForeground(Color.BLACK);
		lblname.setFont(new Font("Tahoma",Font.BOLD,14));
		panel.add(lblname);
		
		 name =new JTextField();
		name.setBounds(290,180,140,20);
		
		meter.addFocusListener(new FocusListener() {
			
			public void focusGained(FocusEvent fe) {
				
			}
			
			public void focusLost(FocusEvent ff) {
				
				try {
					Conn c= new Conn();
					ResultSet rs=c.s.executeQuery("select * from login where meter_no= '"+ meter.getText()+"'");
					while(rs.next()) {
						name.setText(rs.getString("name"));
					}
						
					
					
				}catch(Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		panel.add(name);
		
		JLabel lblpass =new  JLabel("Password");
		lblpass.setBounds(162,220,140,20);
		lblpass.setForeground(Color.BLACK);
		lblpass.setFont(new Font("Tahoma",Font.BOLD,14));
		panel.add(lblpass);
		
		password =new JTextField();
		password.setBounds(290,220,140,20);
		panel.add(password);
		
		accountType.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ie) {
				String user= accountType.getSelectedItem();
				if(user.equals("Customer")) {
					lblmeter.setVisible(true);
					meter.setVisible(true);
					name.setEditable(false);
				}
				else {
					lblmeter.setVisible(false);
					meter.setVisible(false);
					name.setEditable(true);
				}
			}
		});
		
		create= new JButton("Create");
		create.setBackground(Color.black);
		create.setForeground(Color.WHITE);
		create.setBounds(190,265,100,25);
		create.addActionListener(this);
		panel.add(create);
		
		
		 back= new JButton("Back");
		back.setBackground(Color.black);
		back.setForeground(Color.WHITE);
		back.setBounds(330,265,100,25);
		back.addActionListener(this);
		panel.add(back);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("signupImage.png"));
		Image i2=i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image= new JLabel(i3);
		image.setBounds(440,30,200,220);
		panel.add(image);
		
		
		
		setVisible(true);
		
	}
	
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==create) {
			
			String atype=accountType.getSelectedItem();
			String susername=username.getText();
			String sname=name.getText();
			String spassword=password.getText();
			String smeter= meter.getText();
			
			try {
				
				Conn c=new Conn();
				
				String query=null;
				if(atype.equals("Admin")) {
					
					query="insert into login values('"+smeter+"','"+susername+"','"+sname+"','"+spassword+"','"+atype+"')";
				}else {
					query="update login set username ='"+susername+"',password='"+spassword+"',user='"+atype+"' where meter_no='"+smeter+"'";
				}
						
				
				c.s.executeUpdate(query);
				
				JOptionPane.showMessageDialog(null, "Account Created successfully");
				
				setVisible(false);
				new Login();
				
			}catch(Exception e1) {
				e1.printStackTrace();
				
			}
		} else if(e.getSource()==back) {
			
			setVisible(false);
			new Login();
		}
		
	}
	
	public static void main(String[] args) {
		new Signup();
	}




	
}
