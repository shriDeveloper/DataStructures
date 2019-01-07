package interview;
import java.util.*;
class Direction{
    long COST;
    String cmd;
    int LAST_X;
    int LAST_Y;
    public Direction(long c,String cmd,int l_x,int l_y){
        this.COST=c;
        this.cmd=cmd;
        this.LAST_X=l_x;
        this.LAST_Y=l_y;
    }
    @Override
    public String toString(){
        return "COST:  "+COST+" CMD: "+cmd+" X: "+LAST_X+" Y: "+LAST_Y;
    }
}
public class TicTac {
    static void initCost(long c[][]){
        for(int i=0;i<c.length;i++)
            for(int j=0;j<c.length;j++)
                c[i][j]=Math.abs(new Random().nextLong()%10000);
        /* */
        for(int i=0;i<c.length;i++){
            for(int j=0;j<c.length;j++){
                System.out.printf(" "+c[i][j]);
            }
            System.out.println("");
        }
    }
    
    static void mapRoute(char m[][],int x,int y,char w,long ma[][]){
        //ArrayList<Direction> list=new ArrayList<>();
        TreeMap<Long,Direction> map=new TreeMap<>();
        long UP=0,DOWN=0,LEFT=0,RIGHT=0,DIA_UP=0,DIA_DOWN=0,DI_LEFT=0,DI_RIGHT=0;
        int LAST_x=-1,LAST_y=-1;
        if(x < 0 || y < 0 || x >= m.length || y>=m.length)
            return;
        int k=m.length;
        for(int i=x-1;i>=0;i--){
            if(m[i][y]!=w){
               m[i][y]=w;
               UP+=ma[i][y];
            }
            LAST_x=i;
            LAST_y=y;
        }
        if(UP!=0)
            map.put(UP,new Direction(UP,"U",LAST_x,LAST_y));
        //FOR DOWN
        for(int i=x+1;i<k;i++){
            if(m[i][y]!=w){
                m[i][y]=w;
                DOWN+=ma[i][y];
            }
            LAST_x=i;
            LAST_y=y;
        }
        if(DOWN!=0)
            map.put(DOWN,new Direction(DOWN,"D",LAST_x,LAST_y)); 
        //FOR LEFT
        for(int i=y-1;i>=0;i--){
            if(m[x][i]!=w){
                m[x][i]=w;
                LEFT+=ma[x][i];
            }
            LAST_x=x;
            LAST_y=i;
        }
        if(LEFT!=0)
            map.put(LEFT,new Direction(LEFT,"L",LAST_x,LAST_y));
        //FOR RIGHT
        for(int i=y+1;i<k;i++){
            if(m[x][i]!=w){
                m[x][i]=w;
                RIGHT+=ma[x][i];
            }
            LAST_x=x;
            LAST_y=i;
        }
        if(RIGHT!=0)
            map.put(RIGHT,new Direction(RIGHT,"R",LAST_x,LAST_y)); 
        //UPPER DIAGONAL
        for(int i=x-1,j=y+1;i>=0 && j<k;i--,j++){
            if(m[i][j]!=w){
                m[i][j]=w;
                DIA_UP+=ma[i][j];
            }
            LAST_x=i;
            LAST_y=j;
        }
        if(DIA_UP!=0)
            map.put(DIA_UP,new Direction(DIA_UP,"UR",LAST_x,LAST_y)); 
        //FOR LOWER DIAGONAL
        for(int i=x+1,j=y-1;i<k && j>=0;i++,j--){
            if(m[i][j]!=w){
                m[i][j]=w;
                DIA_DOWN+=ma[i][j];
            }
            LAST_x=i;
            LAST_y=j;
        }
        if(DIA_DOWN!=0)
            map.put(DIA_DOWN,new Direction(DIA_DOWN,"LL",LAST_x,LAST_y)); 
        //FOR ANOTHER  DIAGONAL
        for(int i=x-1,j=y-1;i>=0 && j>=0;i--,j--){
            if(m[i][j]!=w){
                m[i][j]=w;
                DI_LEFT+=ma[i][j];
            }
            LAST_x=i;
            LAST_y=j;
        }
        if(DI_LEFT!=0)
            map.put(DI_LEFT,new Direction(DI_LEFT,"UL",LAST_x,LAST_y)); 
        //FOR ANOTHER  DIAGONAL
        for(int i=x+1,j=y+1;i<k && j<k;i++,j++){
            if(m[i][j]!=w){
                m[i][j]=w;
                DI_RIGHT+=ma[i][j];
            }
            LAST_x=i;
            LAST_y=j;
        }
        if(DI_RIGHT!=0)
            map.put(DI_RIGHT,new Direction(DI_RIGHT,"LR",LAST_x,LAST_y)); 
        System.out.println("OPTIMIZED:  "+map.get(map.firstKey()));
    }
    public static void main(String[] args) {
       char MATRIX[][]=new char[100][100];
       long COST[][]=new long[100][100];
       initCost(COST);
       Scanner sc=new Scanner(System.in);
       while(true){
           System.out.println("ENTER X!!");
           int x=sc.nextInt();
           System.out.println("ENTER Y!!");
           int y=sc.nextInt();
           MATRIX[x][y]='#';
           long startTime = System.nanoTime();
           mapRoute(MATRIX,x,y,'#',COST);
           long endTime = System.nanoTime();
           
           long duration = ((endTime - startTime)/1000000);
           
           System.out.println("MILI: "+duration);
           
           for(int i=0;i<MATRIX.length;i++){
             for(int j=0;j<MATRIX.length;j++){
                    System.out.print(" "+MATRIX[i][j]);
               }
               System.out.println("");
           }
           if(x==404)
               break;
            /** INIT */
       for(int i=0;i<MATRIX.length;i++)
           for(int j=0;j<MATRIX.length;j++)
               MATRIX[i][j]=' ';
       }
    }
}
