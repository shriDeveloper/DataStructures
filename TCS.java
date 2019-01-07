package interview;
import java.io.*;
public class TCS {
    public static int getCountBits(int i){
        int count=0;
        while(i > 0){
            count+= i & 1;
            i>>=1;
        }
        return count;
    }
    public static void main(String[] args)throws IOException {
       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       int T=Integer.parseInt(br.readLine());
       String y[]=br.readLine().split(",");
       int A[]=new int[y.length];
       int INVERSIONS=0;
       for(int i=0;i<y.length;i++)
           A[i]=getCountBits(Integer.parseInt(y[i]));
       for(int i=0;i<A.length-1;i++){
           for(int j=i+1;j<A.length;j++){
               if(A[i]>A[j])
                   INVERSIONS+=1;
           }
       }
       System.out.println(INVERSIONS);
    }
}
