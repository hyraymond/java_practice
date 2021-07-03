// To implement the admin and password login.
package JUNE_THIRTY;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;
import javax.swing.text.JTextComponent;

public class captcha implements ActionListener, MouseListener{
	JTextField tf1;
	JPasswordField tf2;
	JLabel l1;
	JLabel l2;
	JFrame f1;
	String admin;
	String password;
	JDialog jd;
	JButton jb;
	
	captcha() {
		f1 = new JFrame();
		f1.setSize(500, 500);
		f1.setLayout(null);
		admin = "";
		password = "";
		
		tf1 = new JTextField();
		tf2 = new JPasswordField();
		l1 = new JLabel("Admin: ");
		l2 = new JLabel("Password: ");
		jd = new JDialog();
		jb = new JButton("OK");
		
//		tf1.setLocation(50, 50);
		tf1.setBounds(100,100,300,20);
//		tf2.setLocation(50, 200);
		tf2.setBounds(100,200,300,20);
		l1.setBounds(20, 100, 80, 20);
		l2.setBounds(20, 200, 80, 20);
		jd.setSize(200, 100);
		
		f1.add(tf1);
		f1.add(tf2);
		f1.add(l1);
		f1.add(l2);
		
		f1.setTitle("ÓÂÐ¡»¢");
		Image icon = Toolkit.getDefaultToolkit().getImage("C:/Users/87335/Desktop/files/2021spring/java_practice/java_project/CAPTCHA/src/JUNE_THIRTY"
				+ "/icon.jpg");
		f1.setIconImage(icon);
		
		tf1.addActionListener(this);
		tf1.addMouseListener(this);
		tf2.addActionListener(this);
		tf2.addMouseListener(this);
		tf1.setToolTipText("please enter your admin");
		tf2.setToolTipText("please enter your password");
		f1.setDefaultCloseOperation(f1.EXIT_ON_CLOSE);
		jb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jd.setVisible(false);
			}
		});
		jd.add(jb);
		
		f1.setVisible(true);
	}
	public static void main(String[] args) {
        new captcha();
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JTextComponent k = (JTextComponent)e.getSource();
		String text = k.getText();
		if (k == tf1)
		{
			admin = text;
		}
		else if(k == tf2)
		{
			admin = tf1.getText();
			password = text;
			try {
				if (true == ifValid(admin, password))
				{
					jb.setText("Login successfully");
				}
				else
				{
					jb.setText("Wrong admin or password");
				}
				jd.setVisible(true);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		((JTextComponent) e.getSource()).setText(null);
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	private static boolean ifValid(String admin, String pass) throws IOException {
		String a;
		String p;
		File file = new File("C:/Users/87335/Desktop/files/2021spring/java_practice/java_project/CAPTCHA/src/JUNE_THIRTY"
				+ "/admin.txt");
		
		try {
			BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			while((a = bf.readLine()) != null)
			{
				p = bf.readLine();
				if (a.compareTo(admin) == 0 && p.compareTo(pass) == 0)
				{
					return true;
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
