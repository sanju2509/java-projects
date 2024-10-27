package electricity.billing.system;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class Project extends JFrame implements ActionListener {
		String atype,meter;
	public Project(String atype,String meter) {
		this.atype=atype;
		this.meter=meter;
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("elect1.jpg"));
		Image i2=i1.getImage().getScaledInstance(1550, 850,Image.SCALE_DEFAULT);
		
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		add(image);
		
		JMenuBar mb= new JMenuBar();
		setJMenuBar(mb);
		
		JMenu master=new JMenu("Master");
		master.setForeground(Color.BLUE);
		
		
		JMenuItem newcustomer =new JMenuItem("New Customer");
		newcustomer.setFont(new Font("Times New Roman",Font.BOLD,12));
		newcustomer.setBackground(Color.WHITE);
		ImageIcon icon1= new ImageIcon(ClassLoader.getSystemResource("icon1.png"));
		Image image1 =icon1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		newcustomer.setIcon(new ImageIcon(image1));
		
		newcustomer.setMnemonic('D');
		newcustomer.addActionListener(this);
		newcustomer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK));
		master.add(newcustomer);
		
		
		JMenuItem customerdetail =new JMenuItem("Customer Details");
		customerdetail.setFont(new Font("Times New Roman",Font.BOLD,12));
		customerdetail.setBackground(Color.WHITE);
		ImageIcon icon2= new ImageIcon(ClassLoader.getSystemResource("icon2.png"));
		Image image2 =icon2.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		customerdetail.setIcon(new ImageIcon(image2));
		
		customerdetail.setMnemonic('M');
		
		customerdetail.addActionListener(this);
		customerdetail.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,ActionEvent.CTRL_MASK));
		master.add(customerdetail);
		
		
		JMenuItem depositdetail =new JMenuItem("Deposit Details");
		depositdetail.setFont(new Font("Times New Roman",Font.BOLD,12));
		depositdetail.setBackground(Color.WHITE);
		ImageIcon icon3= new ImageIcon(ClassLoader.getSystemResource("icon3.png"));
		Image image3 =icon3.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		depositdetail.setIcon(new ImageIcon(image3));
		
		depositdetail.setMnemonic('N');
		depositdetail.addActionListener(this);

		depositdetail.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
		master.add(depositdetail);
		
		
		JMenuItem calculatebill =new JMenuItem("Calculate Bill");
		calculatebill.setFont(new Font("Times New Roman",Font.BOLD,12));
		calculatebill.setBackground(Color.WHITE);
		ImageIcon icon4= new ImageIcon(ClassLoader.getSystemResource("icon5.png"));
		Image image4 =icon4.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		calculatebill.setIcon(new ImageIcon(image4));
		
		calculatebill.setMnemonic('B');
		calculatebill.addActionListener(this);

		calculatebill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B,ActionEvent.CTRL_MASK));
		master.add(calculatebill);
		
		JMenu info=new JMenu("Information");
		info.setForeground(Color.RED);
		
		
		JMenuItem updateinfo =new JMenuItem("Update Information");
		updateinfo.setFont(new Font("Times New Roman",Font.BOLD,12));
		updateinfo.setBackground(Color.WHITE);
		ImageIcon icon5= new ImageIcon(ClassLoader.getSystemResource("icon4.png"));
		Image image5 =icon5.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		updateinfo.setIcon(new ImageIcon(image5));
		
		updateinfo.setMnemonic('P');
		updateinfo.addActionListener(this);
		updateinfo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.CTRL_MASK));
		info.add(updateinfo);
		
		JMenuItem viewinfo =new JMenuItem("View Information");
		viewinfo.setFont(new Font("Times New Roman",Font.BOLD,12));
		viewinfo.setBackground(Color.WHITE);
		ImageIcon icon6= new ImageIcon(ClassLoader.getSystemResource("icon5.png"));
		Image image6 =icon6.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		viewinfo.addActionListener(this);
		viewinfo.setIcon(new ImageIcon(image6));
		
		viewinfo.setMnemonic('L');
		viewinfo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,ActionEvent.CTRL_MASK));
		info.add(viewinfo);
		
		
		JMenu user=new JMenu("User");
		user.setForeground(Color.BLUE);
		
		
		JMenuItem paybill =new JMenuItem("Pay Bill");
		 paybill.setFont(new Font("Times New Roman",Font.BOLD,12));
		 paybill.setBackground(Color.WHITE);
		ImageIcon icon7= new ImageIcon(ClassLoader.getSystemResource("icon4.png"));
		Image image7 =icon7.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		 paybill.setIcon(new ImageIcon(image7));
		 paybill.addActionListener(this);
		 paybill.setMnemonic('R');
		 paybill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,ActionEvent.CTRL_MASK));
		user.add( paybill);
		
		JMenuItem billdetails =new JMenuItem("Bill Details");
		billdetails.setFont(new Font("Times New Roman",Font.BOLD,12));
		billdetails.setBackground(Color.WHITE);
		ImageIcon icon8= new ImageIcon(ClassLoader.getSystemResource("icon6.png"));
		Image image8 =icon8.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		billdetails.addActionListener(this);
		billdetails.setIcon(new ImageIcon(image8));
		
		billdetails.setMnemonic('K');
		billdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K,ActionEvent.CTRL_MASK));
		user.add(billdetails);
		
		JMenu report=new JMenu("Report");
		report.setForeground(Color.RED);
		
		
		JMenuItem generatebill =new JMenuItem("Generate Bill");
		generatebill.setFont(new Font("Times New Roman",Font.BOLD,12));
		generatebill.setBackground(Color.WHITE);
		ImageIcon icon9= new ImageIcon(ClassLoader.getSystemResource("icon7.png"));
		Image image9 =icon9.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		generatebill.setIcon(new ImageIcon(image9));
		generatebill.addActionListener(this);
		generatebill.setMnemonic('G');
		generatebill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G,ActionEvent.CTRL_MASK));
		report.add( generatebill);
		
		JMenu utility=new JMenu("Utility");
		utility.setForeground(Color.BLUE);
		
		
		JMenuItem notepad =new JMenuItem("NotePad");
		notepad.setFont(new Font("Times New Roman",Font.BOLD,12));
		notepad.setBackground(Color.WHITE);
		ImageIcon icon10= new ImageIcon(ClassLoader.getSystemResource("icon12.png"));
		Image image10 =icon10.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		notepad.setIcon(new ImageIcon(image10));
		
		notepad.setMnemonic('N');
		notepad.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
		notepad.addActionListener(this);
		utility.add( notepad);
		
		JMenuItem calculator =new JMenuItem("Calculator");
		calculator.setFont(new Font("Times New Roman",Font.BOLD,12));
		calculator.setBackground(Color.WHITE);
		ImageIcon icon11= new ImageIcon(ClassLoader.getSystemResource("icon9.png"));
		Image image11 =icon11.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		calculator.setIcon(new ImageIcon(image11));
		calculator.addActionListener(this);
		calculator.setMnemonic('C');
		calculator.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
		utility.add( calculator);
		
		JMenu mexit=new JMenu("Exit");
		mexit.setForeground(Color.RED);
		
		
		JMenuItem exit =new JMenuItem("Exit");
		exit.setFont(new Font("Times New Roman",Font.BOLD,12));
		exit.setBackground(Color.WHITE);
		exit .addActionListener(this);
		ImageIcon icon12= new ImageIcon(ClassLoader.getSystemResource("icon11.png"));
		Image image12 =icon12.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		exit.setIcon(new ImageIcon(image12));
		
		exit.setMnemonic('C');
		exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
		mexit.add(exit);
		
		if(atype.equals("Admin")) {
			mb.add(master);
		}else {
			mb.add(user);
			
			mb.add(info);
			mb.add(report);
		}
		
		mb.add(utility);
		mb.add(mexit);
		
		
		
		
		setLayout(new FlowLayout());
		
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		String msg=ae.getActionCommand();
		
		if(msg.equals("New Customer")) {
			new NewCustomer();
	}
	else if(msg.equals("Customer Details")) {
		new CustomerDetails();
	}
	else if(msg.equals("Deposit Details")) {
		
		new DepositDetails();
	}
	else if(msg.equals("Calculate Bill")) {
		new CalculateBill();
	}else if(msg.equals("View Information")) {
		new ViewInformation(meter);
	}
	else if(msg.equals("Update Information")) {
		new UpdateInformation(meter);
	}
	else if(msg.equals("Bill Details")) {
		new BillDetails(meter);
	}
		
	else if(msg.equals("NotePad")) {
		try {
			
			Runtime.getRuntime().exec("notepad.exe");
			
		}catch(Exception en) {
			en.printStackTrace();
		}
	}
	else if(msg.equals("Calculator")) {
		try {
			
			Runtime.getRuntime().exec("calc.exe");
			
		}catch(Exception n) {
			n.printStackTrace();
		}
	}
	else if(msg.equals("Exit")) {
		setVisible(false);
		new Login();
	}
	else if(msg.equals("Pay Bill")) {
		new PayBill(meter);
	}
	else if(msg.equals("Generate Bill")) {
		new GenerateBill(meter);
	}
		
		}		
	
	private String getActionCommand() {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Project("","");
	}

}
