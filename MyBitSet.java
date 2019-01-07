package interview;
import java.util.*;
public class MyBitSet {
    public static void main(String[] args) {
        
        /**
         * 
         *   1111 1111 1111 1111
         *   0000 0100 0001 1001 bt
         *   0000 0000 0001 0010 at
         *   0000 0000 0001 0000 bt
         * 
         *                    
         */
     
        BitSet bt=new BitSet(16);
        BitSet at=new BitSet(16);
        bt.set(0);
        bt.set(3);
        bt.set(10);
        bt.set(4);
        
        at.set(1);
        at.set(4);
        
        System.out.println("CADR:  "+bt.cardinality());
        
        bt.and(at);
        

        System.out.println("CARDI:  "+bt.cardinality());
        
        long A[]=bt.toLongArray();
        for(long y:A)
            System.out.println(" "+y);
        
        
        
    }
}
