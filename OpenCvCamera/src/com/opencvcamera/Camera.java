package com.opencvcamera;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.swing.*;

public class Camera extends JFrame {
	
	//camera Screen
		private	JLabel camerascreen;
		private JButton btnCapture;
		private VideoCapture capture;
		private Mat image;
		private boolean clicked=false;
	public Camera() {
		//design UI
		setLayout(null);
		camerascreen=new JLabel();
		camerascreen.setBounds(0,0,640,480);
		add(camerascreen);
		btnCapture=new JButton("Capture");
		btnCapture.setBounds(300,480,80,40);
		add(btnCapture);
		btnCapture.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				clicked=true;
				
			}
			
		});
		
		addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent e) {
				super.windowClosed(e);
				image.release();
				System.exit(0);
			}
		});
		
		setSize(new Dimension(640,560));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	//create camera
	public void startCamera() {
		capture=new VideoCapture(0);
		image=new Mat();
		
		byte[] imageData;
		ImageIcon icon;
		while(true) {
			//read image to matrix
			capture.read(image);
			//convert matrix to byte
			final MatOfByte buf=new MatOfByte();
			Imgcodecs.imencode(".jpg",image,buf);
			imageData= buf.toArray();
			//add to JLabel
			icon=new ImageIcon(imageData);
			camerascreen.setIcon(icon);
			//capture and save to file
			if(clicked) {
				//prompt for enter image name
				String name=JOptionPane.showInputDialog(this,"Enter image name");
				if(name==null)
				{
					name=new SimpleDateFormat("yyyy-mm-dd-hh-mm-ss").format(new Date(0));
				}
				//write to file
				Imgcodecs.imwrite("images/" +name+ ".jpg",image);
				clicked=false;
			}
			
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		EventQueue.invokeLater(new Runnable()
				{
			public void run() {
				final Camera camera=new Camera();
				//start camera in thread
				new Thread(new Runnable() {
				

					public void run() {
						// TODO Auto-generated method stub
						camera.startCamera();
						
					}}).start();
			}
			
				});
			
		

	}

}
