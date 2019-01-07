import java.io.*;
import java.util.regex.*;
public class TCSARR {
    public static void main(String[] args)throws IOException {
       String y="kakjkfkkjkjf939048388**#@*#*@#*$**Q($**@Q#$*#*$*#@$";
       y=y.replaceAll("\\p{Punct}","");
        System.out.println("FINAL: "+y);
    }
}
