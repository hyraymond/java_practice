// implement a clock
package July_Third;

import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class practice_two implements Runnable, ActionListener{
	JFrame f;
	Thread t = null;
	int hours = 0, minutes = 0, seconds = 0;
	String timeString = "";
	JButton b;
	JButton ps;
	
	practice_two() {
		f = new JFrame();
		f.setTitle("Swing实现始终效果");
		
		t = new Thread(this);
		t.start();
		
		b = new JButton();
		b.setBounds(100, 100, 100, 50);
		ps = new JButton("PAUSE");
		ps.setBounds(100, 200, 100, 50);
		
		ps.addActionListener(this);
		f.add(b);
		f.add(ps);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (t.isAlive() == true)
		{
			t.interrupt();
			ps.setText("RESUME");
		}
		else
		{
			t = new Thread(this);
			t.start();
			ps.setText("PAUSE");
		}
	}
}
