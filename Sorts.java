package interview;
public class Sorts<T extends Comparable<T>> {
   public void selectionSort(T arr[]){
       for(int i=0;i<arr.length;i++){
           int INDEX=i;
         
           T MIN=arr[i];
           for(int j=i+1;j<arr.length;j++){
               if(arr[j].compareTo(MIN) < 0 ){
                   MIN=arr[j];
                   INDEX=j;
               }
           }
           T temp=arr[INDEX];
           arr[INDEX]=arr[i];
           arr[i]=temp;
       }
   }
   public void bubbleSort(T arr[]){
       for(int i=0;i<arr.length;i++){
           for(int j=0;j<arr.length-i-1;j++){
               if(arr[j].compareTo(arr[j+1]) > 0){
                   T temp=arr[j];
                   arr[j]=arr[j+1];
                   arr[j+1]=temp;
               }
           }
       }
   }
   public void insertionSort(T arr[]){
       for(int i=0;i<arr.length;i++){
           for(int j=i;j>0;j--){
               if(arr[j-1].compareTo(arr[j]) > 0){
                   T temp=arr[j-1];
                   arr[j-1]=arr[j];
                   arr[j]=temp;
               }
           }
       }
   }
   public void heapSort(T arr[]){
       int N=arr.length;
       for(int i=(N/2)-1;i>=0;i--)
           heapify(arr,i,N);
       for(int i=N-1;i>=0;i--){
           T temp=arr[i];
           arr[i]=arr[0];
           arr[0]=temp;
           heapify(arr,0,i);
       }
   }
   private void heapify(T arr[],int i,int N){
       int largest=i;
       int left=2*i+1;
       int right=2*i+2;
       if(left < N && arr[left].compareTo(arr[largest]) > 0)
           largest=left;
       if(right < N && arr[right].compareTo(arr[largest]) > 0)
           largest=right;
       if(largest!=i){
           T temp=arr[largest];
           arr[largest]=arr[i];
           arr[i]=temp;
           heapify(arr,largest,N);
       }
   }
   public void quickSort(T arr[]){
       int LOW=0;
       int HIGH=arr.length-1;
       quickSort(arr,LOW,HIGH);
   }
   private int partition(T arr[],int low,int high){
       T pivot=arr[high];
       int i=-1,j;
       for(j=0;j<=high-1;j++){
           if(arr[j].compareTo(pivot) < 0){
               i++;
               T temp=arr[j];
               arr[j]=arr[i];
               arr[i]=temp;
           }
       }
       T temp=arr[i+1];
       arr[i+1]=arr[j];
       arr[j]=temp;
       return i+1;
   }
   private void quickSort(T arr[],int low,int high){
       if(low < high){
           int partition=partition(arr,low,high);
           quickSort(arr,low,partition-1);
           quickSort(arr,partition+1,high);
       }
   }
}
