package interview;
public class Arrays<T extends Comparable> {
    public static void removeDuplicates(int arr[]){
        int temp[]=new int[arr.length];
        int j=0;
        for(int i=0;i<arr.length-1;i++)
            if(arr[i]!=arr[i+1])
               temp[j++]=arr[i]; 
        temp[j]=arr[arr.length-1];
    }
    /**
     * O(N) and O(1) SPACE
     * @param arr
     * @param x
     * @return 
     */
    public static boolean isFoundIn2D(int arr[][],int x){
        int row=0,col=arr.length-1;
        while(col >= 0 && row < arr.length){
            if(arr[row][col]==x)
                return true;
            else if(arr[row][col] < x)
                row++;
            else
                col--;
        }
        return false;
    }
    /**
     * T.C O(n log n) for sorting in worst case + o(log n) for searching
     * else
     * O(log n) in average 
     * @param arr
     * @param x
     * @return 
     */
    public static int countOccurences(int arr[],int x){
        boolean flag=true;
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]>arr[i+1]){
                flag=false;
                break;
            }
        }
        if(!flag)
            java.util.Arrays.sort(arr);
        int firstIndex=getOccurences(arr,x,true);
        int lastIndex=getOccurences(arr,x,false);
        return (lastIndex-firstIndex+1);
    }
    private static int getOccurences(int arr[],int x,boolean flag){
        int low=0,high=arr.length-1,result=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]==x){
                result=mid;
                if(flag)
                    high=mid-1;
                else
                    low=mid+1;
            }
            else if(x < arr[mid])
                high=mid-1;
            else
                low=mid+1;
        }
        return result;
    }
    public static<T extends Comparable> void fillArray(T arr[], T e){
        for(int i=0;i<arr.length;i++)
            arr[i]=e;
    }
    /**
     * T.C O(N)
     * S.C O(1)
     * 
     * @param arr
     * @param x
     * @return 
     */
    public boolean linearSorted(int arr[],int x){
        java.util.Arrays.sort(arr);
        for(int i=0;i<arr.length;i++){
            if(x==arr[i])
                return true;
            else if(x < arr[i])
                return false;;
        }
        return false;
    }
    /**
     * T.C log(n)
     * S.c log(n) when recursion is used or else o(1)
     * @param <T>
     * @param arr
     * @param x
     * @param high
     * @param low
     * @return
     */
    private static<T extends Comparable> int binarySearch(T arr[],T x,int high,int low){
        if(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]==x)
                return mid;
            else if(x.compareTo(arr[mid]) < 0)
                return binarySearch(arr,x,mid-1,low);
            else if(x.compareTo(arr[mid]) > 0)
                return binarySearch(arr,x,high,mid+1);
        }
        return -1;
    }
    public static<T extends Comparable> int binarySearch(T arr[],T x){
        return binarySearch(arr,x,arr.length,0);
    }
    /**
     * T.C O(LOG N) SPACE O(1)
     * @param <T>
     * @param arr
     * @return 
     */
    public static<T extends Comparable> int firstOne(T arr[]){
       int firstIndex=binarySearch(arr,1,arr.length,0),RESULT=-1;
       if(firstIndex < 0)
           return RESULT;
       else{
           RESULT=firstIndex;
           int leftMost=binarySearch(arr,1,firstIndex-1,0);
           if(leftMost >= 0 )
               RESULT=leftMost;
       }
       return RESULT;
    }
    
}
