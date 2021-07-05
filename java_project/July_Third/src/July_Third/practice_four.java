// Internet programming, realize a chat program
package July_Third;

import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class practice_four extends JFrame{
	private JPanel jp1;
	private JPanel jp2;
	practice_four() {
		jp1 = new JPanel(new BorderLayout());
		jp2 = new JPanel(new BorderLayout());
		jp1.add(new JLabel("salfdjalsdkf"), BorderLayout.CENTER);
		jp2.add(new JButton(), BorderLayout.CENTER);
		add(jp1, BorderLayout.WEST);
		add(jp2, BorderLayout.EAST);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 400); // 设置窗口的大小
		setVisible(true);
	}
	private void setGUI()
	{
		
	}
	public static void main (String[] args) {
		new practice_four();
	}
}
