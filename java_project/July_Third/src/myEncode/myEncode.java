// Realize an encode and decode program
package myEncode;

import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class myEncode extends JFrame {
	JPanel northpanel;
	JPanel centerpanel;
	JPanel bottompanel;
	JTextArea encodepart;
	JTextArea inputpart;
	JButton encode;
	JButton decode;
	JLabel jinput;
	JLabel jencode;
	
	private void setGUI() {
		setTitle("Encode/Decode Program");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 400); // 设置窗口的大小
		encodepart = new JTextArea(5, 20);
		encodepart.setEditable(false);
		jencode = new JLabel("Encode Result:");
		jencode.setHorizontalAlignment(JLabel.LEFT);
		northpanel = new JPanel(new BorderLayout());
		northpanel.add(jencode, BorderLayout.NORTH);
		northpanel.add(new JScrollPane(encodepart), BorderLayout.CENTER);
		inputpart = new JTextArea(5, 20);
		inputpart.setEditable(true);
		jinput = new JLabel("Input Text:");
		jinput.setHorizontalAlignment(JLabel.LEFT);
		centerpanel = new JPanel(new BorderLayout());
		centerpanel.add(jinput, BorderLayout.NORTH);
		centerpanel.add(new JScrollPane(inputpart), BorderLayout.CENTER);
		bottompanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
		encode = new JButton("encode");
		decode = new JButton("decode");
		bottompanel.add(encode);
		bottompanel.add(decode);
		add(northpanel, BorderLayout.NORTH);
		add(centerpanel, BorderLayout.CENTER);
		add(bottompanel, BorderLayout.SOUTH);
		setVisible(true);
	}
	private void setButtonListener() {
		encode.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String op = inputpart.getText();
				try {
					String ep = Base64.getEncoder().encodeToString(op.getBytes("utf-8"));
					encodepart.setText(ep);
				} catch (UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		decode.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e){
				// TODO Auto-generated method stub
				String ep = inputpart.getText();
				byte[] op = Base64.getDecoder().decode(ep);
				try {
					encodepart.setText(new String(op, "utf-8"));
				} catch (UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
	}
	myEncode()
	{
		setGUI();
		setButtonListener();
	}
	public static void main(String[] args)
	{
		new myEncode();
	}
}
