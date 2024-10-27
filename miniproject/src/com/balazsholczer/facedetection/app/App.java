package com.balazsholczer.facedetection.app;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.balazsholczer.facedetection.gui.MainFrame;
public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}catch(ClassNotFoundException |InstantiationException
				|IllegalAccessException |UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		SwingUtilities.invokeLater(new Runnable()
				{
			public void run() {
				new MainFrame();
			}
				});

	}

}
