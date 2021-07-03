// implement a clock
package July_Third;

import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class practice_two implements Runnable{
	JFrame f;
	Thread t = null;
	int hours = 0, minutes = 0, seconds = 0;
	String timeString = "";
	JButton b;
	
	practice_two() {
		f = new JFrame();
		f.setTitle("Swingʵ��ʼ��Ч��");
		
		t = new Thread(this);
		t.start();
		
		b = new JButton();
		b.setBounds(100, 100, 100, 50);
		
		f.add(b);
		f.setSize(300, 400);
		f.setLayout(null);
		f.setVisible(true);
	}
	
	public void run() {
		try {
			while (true) {
				Calendar cal = Calendar.getInstance();
				hours = cal.get( Calendar.HOUR_OF_DAY);
				if (hours > 12)
				{
					hours -= 12;
				}
				minutes = cal.get( Calendar.MINUTE);
				seconds = cal.get(Calendar.SECOND);
				SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss");
				Date date = cal.getTime();
				timeString = formatter.format(date);
				printTime();
				t.sleep(1000);
			}
		}
		catch (Exception e) { }
	}
	
	public void printTime () {
		b.setText(timeString);
	}
	
	public static void main (String[] args) {
		new practice_two();
	}
}
