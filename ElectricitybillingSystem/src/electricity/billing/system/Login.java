package electricity.billing.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;
import java.awt.event.*;
public class Login extends JFrame implements ActionListener {
	
	JButton login,signup,cancel;
	
	JTextField username,pass;
	Choice loggingin;
	Login(){
		
		super("Login Page");
		JLabel lblusername =new JLabel("Username");
		lblusername.setBounds(300, 20, 100, 20);
		getContentPane().setBackground(Color.WHITE);
		
		 username= new JTextField();
		username.setBounds(380,20,150,20);
		add(username);
		JLabel lblpass =new JLabel("Password");
		lblpass.setBounds(300, 60, 100, 20);
		
		 pass= new JTextField();
		pass.setBounds(380,60,150,20);
		add(pass);
		
		JLabel lbllogging =new JLabel("Logging In As");
		lbllogging.setBounds(290, 100, 100, 20);
		
		loggingin=new Choice();
		loggingin.add("Admin");
		loggingin.add("Customer");
		loggingin.setBounds(380,100,150,20);
		add(loggingin);
		setLayout(null);
		add(lblusername);
		add(lblpass);
		add(lbllogging);
		
		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("login.png"));
		Image i2=i1.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
		login=new JButton("Login",new ImageIcon(i2));
		
		login.setBounds(330,160,100,20);
		login.addActionListener(this);
		add(login);
		
		ImageIcon i3= new ImageIcon(ClassLoader.getSystemResource("cancel.jpg"));
		Image i4=i3.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
		 cancel=new JButton("Cancel",new ImageIcon(i4));
		cancel.setBounds(450,160,100,20);
		cancel.addActionListener(this);
		add(cancel);
		
		
		ImageIcon i5= new ImageIcon(ClassLoader.getSystemResource("signup.png"));
		Image i6=i5.getImage().getScaledInstance(19, 19, Image.SCALE_DEFAULT);
		 signup=new JButton("SignUp",new ImageIcon(i6));
		signup.setBounds(380,200,100,20);
		signup.addActionListener(this);
		add(signup);
		
		ImageIcon i7= new ImageIcon(ClassLoader.getSystemResource("second.jpg"));
		Image i8=i7.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
		ImageIcon i9=new ImageIcon(i8);
		JLabel image=new JLabel(i9);
		image.setBounds(0,0,250,250);
		add(image);
		setSize(600,300);
		setLocation(400,200);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==login) {
			
			String susername= username.getText();
			String spassword=pass.getText();
			String user=loggingin.getSelectedItem();
			
			try {
				
				Conn c=new Conn();
				String query="select * from login where username ='"+susername+"'and password = '"+spassword+"'and user ='"+user+"' ";
				
				ResultSet rs=c.s.executeQuery(query);
				
				if(rs.next()) {
					
					String meter=rs.getString("meter_no");
					setVisible(false);
					new Project(user,meter);
					
				}
				else {
					
					JOptionPane.showMessageDialog(null, "Invalid Login");
					username.setText("");
					pass.setText("");
					
				}
			}catch(Exception e1) {
				e1.printStackTrace();
			}
			
		}else if(e.getSource()==signup) {
			
			
			setVisible(false);
			
			new Signup();
		}
		else if(e.getSource()==cancel) {
			
			dispose();
		}
		
	}

	public static void main(String[] args) {
		new Login();
	}
	}
