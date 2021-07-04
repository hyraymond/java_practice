//To practice multiple thread and thread synchronize
//If only background threads are running in a process, the process ends
package July_Third;

import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class practice_three {
	public static void main (String[] args) throws InterruptedException {
		MyThread mythread = new MyThread();
		Thread l1 = new Thread(mythread, "Thread1");
		Thread l2 = new Thread(mythread, "Thread2");
		Thread l3 = new Thread(mythread, "Thread3");
		Thread l4 = new Thread(mythread, "Thread4");
		l2.setPriority(10);
		l1.start();
		l2.start();
		l3.start();
		l4.start();
	}
}
class MyThread implements Runnable {
	static int k = 100;
	public void run() {
		Thread no = Thread.currentThread();
		String n = no.getName();
		Object lock = new Object();
		synchronized(lock) 
		{
			while (k > 0)
			{
				System.out.println(n + " sales number " + k-- + " ticket");
			}
		}
		
	}
}
