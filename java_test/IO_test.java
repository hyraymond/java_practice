//This a simple test for Java IO stream.
//2020/05/25
/*
FileOutputStream/FileInputStream, read or write by byte, with no buffer.
BufferedOutputStream/BufferedInputStream, with buffer.
FileWriter/FileReader, read or write by charactor, with no buffer.
BufferredWriter/BufferredReader.
InputStreamWriter/InputStreamReader, convert the byte stream to charactor stream or the opposite.
vodi setIn/setOut/setErr, retarget the standard in/out/err stream.
*/
import java.util.*;
import java.io.*;
public class IO_test{
    public static void main(String[] args) throws Exception
    {
        // Random ran_generator = new Random();
        // FileOutputStream data = new FileOutputStream("data.txt", true);
        // for (int i = 0; i < 10; ++i)
        // {
        //     data.write(ran_generator.nextInt());
        // }
        // String str = "\nThis is a test\n";
        // byte[] b = str.getBytes();

        // for (int i = 0; i < b.length; ++i)
        // {
        //     data.write(b[i]);
        // }
        // data.close();

        // FileInputStream receive_data = new FileInputStream("data.txt");
        // int k;
        // while(true)
        // {
        //     k = receive_data.read();
        //     if (k == -1)
        //     {
        //         break;
        //     }
        //     System.out.println(k);
        // }
        // receive_data.close();

        // Random ran_generator = new Random();
        // FileWriter data = new FileWriter("data.txt", false);
        // for (int i = 0; i < 10; ++i)
        // {
        //     data.write(ran_generator.nextInt(67));
        // }
        // String str = "\nThis is a test\n";

        // for (int i = 0; i < str.length(); ++i)
        // {
        //     data.write(str.charAt(i));
        // }
        // data.close();

        FileWriter data = new FileWriter("data.txt");
        BufferedWriter out = new BufferedWriter(data);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String tes = in.readLine();
        out.write(tes);
        out.flush();
        out.close();
        in.close();
        data.close();
    }
}