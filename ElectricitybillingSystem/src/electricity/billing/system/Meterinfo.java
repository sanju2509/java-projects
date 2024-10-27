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

public class Meterinfo  extends JFrame implements ActionListener{
	
	JTextField tfname,tfaddress,tfstate,tfcity,tfemail,tfphone;
	
	JButton next,cancel;
	JLabel lblmeter;
	Choice meterlocation,metertype,phasecode,billtype;
	String meternumber;
	
	public Meterinfo(String meternumber) {
		// TODO Auto-generated constructor stub
		
		this.meternumber=meternumber;
		setSize(700,500);
		setLocation(400,100);
		JPanel p=new JPanel();
		p.setLayout(null);
		p.setBackground(new Color(173,216,230));
		add(p);
		
		JLabel heading =new JLabel("Meter Information");
		heading.setFont(new Font("Tahoma",Font.BOLD,18));
		heading.setForeground(Color.BLACK);
		heading.setBounds(180,25,200,20);
		p.add(heading);
		
		JLabel lblname =new JLabel("Meter Number");
		lblname.setForeground(Color.BLACK);
		lblname.setBounds(100,80,100,20);
		p.add(lblname);
		
		JLabel lblmeternumber =new JLabel(meternumber);
		lblmeternumber.setForeground(Color.BLACK);
		lblmeternumber.setBounds(240,80,100,20);
		p.add(lblmeternumber);
		
		
		
		JLabel lblmeterlocation =new JLabel("Meter Location");
		lblmeterlocation.setForeground(Color.BLACK);
		lblmeterlocation.setBounds(100,120,100,20);
		p.add(lblmeterlocation);
		
		meterlocation=new Choice();
		meterlocation.add("Outside");
		meterlocation.add("Inside");
		meterlocation.setBounds(240,120,190,20);
		 p.add(meterlocation);
		
		
		JLabel lblmetertype =new JLabel("Meter Type");
		lblmetertype.setForeground(Color.BLACK);
		lblmetertype.setBounds(100,160,100,20);
		p.add(lblmetertype);
		
		metertype=new Choice();
		metertype.add("Electric Meter");
		metertype.add("Solar Meter");
		metertype.add("Smart Meter");
		metertype.setBounds(240,160,190,20);
		 p.add(metertype);
		
		
		JLabel lblphasecode =new JLabel("Phase Code");
		lblphasecode.setForeground(Color.BLACK);
		lblphasecode.setBounds(100,200,100,20);
		p.add(lblphasecode);
		
		phasecode=new Choice();
		phasecode.add("011");
		phasecode.add("022");
		phasecode.add("033");
		phasecode.add("044");
		phasecode.add("055");
		phasecode.add("066");
		phasecode.add("077");
		phasecode.add("088");
		phasecode.add("099");

		phasecode.setBounds(240,200,190,20);
		p.add(phasecode);
		
		
		
		JLabel lblbilltype =new JLabel("Type");
		lblbilltype.setForeground(Color.BLACK);
		lblbilltype.setBounds(100,240,100,20);
		p.add(lblbilltype);
		
		billtype=new Choice();
		billtype.add("Normal");
		billtype.add("Comercial");
		
		billtype.setBounds(240,240,190,20);
		 p.add(billtype);
		
		JLabel lbldays =new JLabel(" 30 Days");
		lbldays.setForeground(Color.BLACK);
		lbldays.setBounds(240,280,100,20);
		p.add(lbldays);
		
		
		
		JLabel lblnote =new JLabel("Note");
		lblnote.setForeground(Color.BLACK);
		lblnote.setBounds(100,320,100,20);
		p.add(lblnote);
		
		JLabel lblbill =new JLabel("By Default Bill Is Calculated for 30 Days Only");
		lblbill.setForeground(Color.BLACK);
		lblbill.setBounds(240,320,500,20);
		p.add(lblbill);
		
		
		
		next=new JButton("Submit");
		next.setBounds(200,390,100,25);
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.addActionListener(this);
		p.add(next);
		
		
		
		
		
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
			
			String meter= meternumber;
			String location =meterlocation.getSelectedItem();
			String type=metertype.getSelectedItem();
			String code=phasecode.getSelectedItem();
			String typebill= billtype.getSelectedItem();
			String days ="30";
			
			
			String query="insert into meter_info values('"+meter+"','"+location+"','"+type+"','"+code+"','"+typebill+"','"+days+"')";
			
			
			try {
				
				Conn c=new Conn();
				c.s.executeUpdate(query);
				
				JOptionPane.showMessageDialog(null, "Meter Information Added Succesfully");
				setVisible(false);
				
				
				
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
		new Meterinfo("");
	}

	

}
