package electricity.billing.system;

import java.awt.*;

import javax.swing.*;

public class Splash extends JFrame implements Runnable	 {
	Thread t;
	Splash(){
		ImageIcon i1;
		i1=new ImageIcon(ClassLoader.getSystemResource("elect.jpg"));
		Image i2=i1.getImage().getScaledInstance(576, 451, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image= new JLabel(i1);
		add(image);
		setVisible(true);
		int x=1;
		for(int i=1; i<600 ;i+=4) {
			
		
		
		setSize(i+x,i-100);
		
		setLocation(700- ((i+x)/2) ,400-(i/2));
		}
		try {
			Thread.sleep(3);
		}catch(Exception e) {
			e.printStackTrace();
		}
		t=new Thread(this);
		 t.start();

	}
	
	 

	

	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(5000);
			setVisible(false);
			
			new Login();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Splash();
	}

}
