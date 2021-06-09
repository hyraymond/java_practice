package Round_H_2020_1;
// A game called Retype, reference: https://codingcompetitions.withgoogle.com/kickstart/round/000000000019ff49/000000000043adc7
// Solution1, calculate the two possible results and return the less one; Failed in the last data sets.
// The reason is use int instead of long. After long, pass all sets.
import java.util.*;
import java.io.*;
public class Solution{
    public static void main(String[] args){
        try
        {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            int case_number = Integer.parseInt(bf.readLine());
            for (int k = 0; k < case_number; ++k)
            {
                String[] all = bf.readLine().split(" ");
                long total = Integer.parseInt(all[0]);
                long cur = Integer.parseInt(all[1]);
                long sword = Integer.parseInt(all[2]);
                long temp1 = cur + total;
                long temp2 = cur > sword ? (total + 2 * cur - 2 * sword): total;
                long temp = temp1 < temp2 ? temp1 : temp2;
                System.out.print("Case #"+(k+1)+": " + temp);
                // TBD
                System.out.println("");
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
            return;
        }
    }
}
