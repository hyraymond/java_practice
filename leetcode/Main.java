import java.util.*;
public class Main {
    public static void main(String[] args)
    {
        StringBuilder t = new StringBuilder("abcdefghij");
        t.insert(1, 1);
        System.out.println(t);
        t.delete(0, 1);
        System.out.println(t);
    }
}
