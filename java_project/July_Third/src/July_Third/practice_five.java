package July_Third;

import java.util.*;
import java.util.concurrent.*;
class yh implements Cloneable{
	int p;
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
class yh1 implements Cloneable{
	int a = 0;
	yh j;
	yh1(){
		j = new yh();
		j.p = 2;
	}
	@Override
    protected Object clone() throws CloneNotSupportedException {
		
        yh1 a = (yh1)super.clone();
        a.j = (yh)j.clone();
        return a;
    }
}
interface pik{
	default void mik() {
		System.out.println("hello world");
	}
	public static void kim() {
		System.out.println("hello 2world");
	}
}
class puk implements pik{
	public static void kim() {
		pik.kim();
	}
}
class pok extends puk{
}
public class practice_five{
    public static void main(String args[]) throws CloneNotSupportedException{
    	String i2 = "i";
    	String i1 = "i";
    	
    	System.out.println(System.identityHashCode(i1));
    	System.out.println(System.identityHashCode(i2));
    }
}
