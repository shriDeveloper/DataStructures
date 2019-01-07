package interview;
public class BinaryHeap{
    private final int heap[];
    private final int SIZE;
    private int TOP;
    public BinaryHeap(int N){
        heap=new int[N];
        this.SIZE=N;
        TOP=-1;
    }
    public BinaryHeap(){
        heap=new int[10];
        this.SIZE=10;
        TOP=-1;
    }
    public void insert(int e){
        heap[++TOP]=e;
    }
    private void heapify(int heap[],int index,int n){
        int largest=index;
        int left=(2*index+1);
        int right=(2*index+2);
        if(left < n && heap[left] > heap[largest])
            largest=left;
        if(right < n && heap[right] > heap[left])
            largest=right;
        if(largest!=index){
            int temp=heap[largest];
            heap[largest]=heap[index];
            heap[index]=temp;
            heapify(heap,largest,n);
        }    
    }
    public int getMax(){
        /* HEAPIFY HERE */
        for(int i=(TOP+1/2)-1;i>=0;i--)
            heapify(heap,i,TOP+1);
        return heap[0];
    }
    public int remove(){
       int x=heap[TOP];
       heap[TOP--]=0;
       return x;
    }
    public void print(){
        for(int i=0;i<=TOP;i++)
            System.out.print(" "+heap[i]);
    }
}
