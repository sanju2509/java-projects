package electricity.billing.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ViewInformation  extends JFrame implements ActionListener{
	JButton cancel;
	
	public ViewInformation(String Meter) {
		// TODO Auto-generated constructor stub
		setBounds(250,50,850,650);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel heading=new JLabel("VIEW CUSTOMER INFORMATION");
		heading.setBounds(260,0,500,40);
		heading.setFont(new Font("Tahoma",Font.BOLD,20));
		add(heading);
		
		JLabel lblname=new JLabel("Name");
		lblname.setBounds(70,80,100,40);
		lblname.setFont(new Font("Tahoma",Font.PLAIN,18));
		add(lblname);
		
		JLabel name=new JLabel("");
		name.setBounds(250,80,180,40);
		name.setFont(new Font("Tahoma",Font.PLAIN,18));
		add(name);
		
		JLabel lblmeternumber=new JLabel("Meter Number");
		lblmeternumber.setBounds(70,120,150,40);
		lblmeternumber.setFont(new Font("Tahoma",Font.PLAIN,18));
		add(lblmeternumber);
		
		JLabel meternumber=new JLabel("");
		meternumber.setBounds(250,120,180,40);
		meternumber.setFont(new Font("Tahoma",Font.PLAIN,18));
		add(meternumber);
		
		JLabel lbladdress=new JLabel("Address");
		lbladdress.setBounds(70,160,150,40);
		lbladdress.setFont(new Font("Tahoma",Font.PLAIN,18));
		add(lbladdress);
		
		JLabel address=new JLabel("");
		address.setBounds(250,160,180,40);
		address.setFont(new Font("Tahoma",Font.PLAIN,18));
		add(address);
		
		JLabel lblcity=new JLabel("City");
		lblcity.setBounds(70,200,150,40);
		lblcity.setFont(new Font("Tahoma",Font.PLAIN,18));
		add(lblcity);
		
		JLabel city=new JLabel("");
		city.setBounds(250,200,180,40);
		city.setFont(new Font("Tahoma",Font.PLAIN,18));
		add(city);
		
		JLabel lblstate=new JLabel("State");
		lblstate.setBounds(380,200,150,40);
		lblstate.setFont(new Font("Tahoma",Font.PLAIN,18));
		add(lblstate);
		
		JLabel state=new JLabel("");
		state.setBounds(450,200,180,40);
		state.setFont(new Font("Tahoma",Font.PLAIN,18));
		add(state);
		
		JLabel lblemail=new JLabel("Email");
		lblemail.setBounds(70,260,150,40);
		lblemail.setFont(new Font("Tahoma",Font.PLAIN,18));
		add(lblemail);
		
		JLabel email=new JLabel("");
		email.setBounds(250,260,180,40);
		email.setFont(new Font("Tahoma",Font.PLAIN,18));
		add(email);
		
		JLabel lblphone=new JLabel("Phone");
		lblphone.setBounds(70,300,150,40);
		lblphone.setFont(new Font("Tahoma",Font.PLAIN,18));
		add(lblphone);
		
		JLabel phone=new JLabel("");
		phone.setBounds(250,300,180,40);
		phone.setFont(new Font("Tahoma",Font.PLAIN,18));
		add(phone);
		
		try {
			Conn c=new Conn();
			ResultSet rs=c.s.executeQuery("select * from customer where meter_no='"+Meter+"'");
			while(rs.next()) {
				name.setText(rs.getString("name"));
				address.setText(rs.getString("address"));
				city.setText(rs.getString("city"));
				state.setText(rs.getString("state"));
				email.setText(rs.getString("email"));
				phone.setText(rs.getString("phone"));
				meternumber.setText(rs.getString("meter_no"));
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		cancel =new JButton("Cancel");
		
		cancel.setBackground(Color.BLACK);
		cancel.setForeground(Color.WHITE);
		cancel.setBounds(250,350,100,30);
		cancel.addActionListener(this);
		add(cancel);
		
		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("viewcustomer.jpg"));
		Image i2=i1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
		ImageIcon i3= new ImageIcon(i2);
		JLabel image =new JLabel(i3);
		image.setBounds(20,350,600,300);
		add(image);
		
		
		setVisible(true);
		
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		setVisible(false);		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ViewInformation("");
	}

	

}
