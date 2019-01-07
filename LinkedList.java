package interview;
interface ListUtil<T> {
    public void addLast(T e);
    public void addFirst(T e);
    public void addAfter(T e, T y);
    public void addAt(T e, int pos);
    public T removeLast();
    public T removeFirst();
    public T remove(T e);
    public T removeAt(int pos);
    public void print();
}
/**
 * 
 * LINKED LIST SINGLY IMPLEMENTATION
 * @author shri
 * @param <T> 
 */
public class LinkedList < T > implements ListUtil {
    private Node head;
    private int SIZE;
    public LinkedList() {
        SIZE = 0;
    }
    public Node reaverseK(int k,Node head){
        
        return null;
    }
    public void printReverse() {
        printReverse(head);
    }
    private void printReverse(Node head) {
        if(head==null)
            throw new RuntimeException("List is NULL");
        if (head.next != null)
            printReverse(head.next);
        System.out.print(" " + head.e);
    }
    public void deleteLoop() {
        if(head==null)
            throw new RuntimeException("List is NULL");
        Node slow, fast;
        slow = fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)break;
        }
        Node trav = head;
        while (trav.next != fast.next) {
            fast = fast.next;
            trav = trav.next;
        }
        fast.next = null;
    }
    public T getLoopedNode() {
        if(head==null)
            throw new RuntimeException("List is NULL");
        Node slow, fast;
        slow = fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        Node trav = head;
        while (trav != fast) {
            trav = trav.next;
            fast = fast.next;
        }
        return trav.e;
    }
    /**
     * 
     * LOOP CHECKING UTIL
     * @return 
     */
    public boolean isLooped() {
        if(head==null)
            throw new RuntimeException("List is NULL");
        Node slow, fast;
        slow = fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }
        return false;
    }
    /**
     * METHOD TO ADD LOOP TO LINKEDLIST
     * @param x
     * @param y 
     */
    public void addLoop(T x, T y) {
        if(head==null)
            throw new RuntimeException("List is NULL");
        Node addTrav = head, tempTrav = head;
        Node node = new Node(y);
        while (tempTrav.e != x)
            tempTrav = tempTrav.next;
        while (addTrav.next != null)
            addTrav = addTrav.next;
        node.next = tempTrav;
        addTrav.next = node;
    }
    /**
     * O(N) DELETION
     * @param e 
     */
    public void deleteAll(T e) {
        if(head==null)
            throw new RuntimeException("LIST is NULL");
        Node trav = head, prev = null;
        while (trav != null) {
            if (trav.e == e) {
                prev.next = trav.next;
                trav = prev;
            }
            prev = trav;
            trav = trav.next;
        }
    }
    public void clear() {
        Node trav=head,prev;
        while(trav!=null){
            prev=trav;
            prev=null;
            trav=trav.next;
        }
        head=null;
    }
    /**
     * 
     * O(n) T.C
     * @param index
     * @return 
     */
    public T get(int index) {
        if (index >= this.SIZE || index < 0)
            return null;
        Node trav = head;
        int pos = 0;
        while (pos < index) {
            trav = trav.next;
            pos++;
        }
        return trav.e;
    }
    public int size() {
        return SIZE;
    }
    public int indexOf(Object e) {
        Node trav = head;
        int POS = 0;
        while (trav != null) {
            if (trav.e == e)
                return POS;
            POS++;
            trav = trav.next;
        }
        return (POS < this.size()) ? POS : -1;
    }
    public void reverse() {
        Node curr = head, prev = null, nextNode = null;
        while (curr != null) {
            nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        head = prev;
    }
    /**
     * O(N) FOR TRAVERSING
     * @param K
     * @param flag
     * @return 
     */
    public T KfromIndex(int K, boolean flag) {
        if (flag)
            K = this.size() - K;
        Node trav = head;
        int POS = 1;
        while (POS < K) {
            POS += 1;
            trav = trav.next;
        }
        return trav.e;
    }
    private < T extends Comparable > int binarySearch(int low, int high, T e) {
        if (low <= high) {
            int mid = (low + (high - low) / 2);
            if (this.get(mid) == e)
                return mid;
            else if (e.compareTo(this.get(mid)) < 0)
                return binarySearch(low, mid - 1, e);
            else
                return binarySearch(mid + 1, high, e);
        }
        return -1;
    }
    /**
     * O(LOG N) SEARCH + O(N) To GET INDEX
     * @param <T>
     * @param e
     * @return 
     */
    public < T extends Comparable > boolean contains(T e) {
        return binarySearch(0, this.size() - 1, e) >= 0;
    }
    /**
     * O(n) 
     * @param <Object>
     * @param e 
     */
    public < Object extends Comparable > void sortedInsert(Object e) {
        SIZE += 1;
        Node trav = head, prev = null;
        Node node = new Node((T) e);
        while (e.compareTo(trav.e) > 0) {
            prev = trav;
            trav = trav.next;
        }
        prev.next = node;
        node.next = trav;
    }
    @Override
    public void addLast(Object e) {
        SIZE += 1;
        Node node = new Node((T) e);
        if (head == null)
            head = node;
        else {
            Node trav = head;
            while (trav.next != null)
                trav = trav.next;
            trav.next = node;
        }
    }
    @Override
    public void addFirst(Object e) {
        SIZE += 1;
        Node trav = head;
        Node node = new Node((T) e);
        node.next = head;
        head = node;
    }
    @Override
    public void addAfter(Object x, Object y) {
        SIZE += 1;
        Node node = new Node((T) y);
        Node trav = head;
        while (!trav.e.equals(x))
            trav = trav.next;
        node.next = trav.next;
        trav.next = node;
    }
    @Override
    public void addAt(Object e, int pos) {
        SIZE+=1;
        if(pos <= 0 || pos > SIZE)
            throw new RuntimeException("INvalid Index!!");
        if(pos==1){
            String y="Hello";
            System.out.println("SUBS:  "+y.substring(0,0));
            addFirst(e);
            return;
        }
        Node trav = head;
        int i = 1;
        Node node = new Node((T) e);
        while (i++ < pos - 1) {
            trav = trav.next;
        }
        node.next = trav.next;
        trav.next = node;
    }
    @Override
    public T removeLast() {
        Node trav = head, prev = null;
        while (trav.next != null) {
            prev = trav;
            trav = trav.next;
        }
        prev.next = null;
        return trav.e;
    }
    @Override
    public T removeFirst() {
        Node trav = head, prev;
        T e = trav.e;
        head = head.next;
        return e;
    }
    @Override
    public T remove(Object e) {
        Node trav = head, prev = null;
        while (!trav.e.equals(e)) {
            prev = trav;
            trav = trav.next;
        }
        prev.next = trav.next;
        return trav.e;
    }

    @Override
    public Object removeAt(int pos) {
        Node trav = head, prev = null;
        int i = 1;
        while (i++ < pos) {
            prev = trav;
            trav = trav.next;
        }
        prev.next = trav.next;
        return trav.e;
    }
    private class Node {
        T e;
        Node next;
        public Node(T x) {
            e = x;
            next = null;
        }
        @Override
        public String toString(){
            return ""+e;
        }
    }
    @Override
    public void print() {
        Node trav = head;
        int i = 1;
        while (trav != null) {
            System.out.print(" " +trav.e);
            trav = trav.next;
        }
    }
}
class DoubleList < T > extends LinkedList implements ListUtil {
    private Node HEAD;
    public DoubleList() {
        HEAD = null;
    }
    @Override
    public void addLast(Object e) {
        Node node = new Node((T) e);
        if (HEAD == null)
            HEAD = node;
        else {
            Node trav = HEAD;
            while (trav.next != null)
                trav = trav.next;
            trav.next = node;
            node.prev = trav;
        }
    }
    @Override
    public void addFirst(Object e) {
        Node node = new Node((T) e);
        if (HEAD == null)
            HEAD = node;
        else {
            node.next = HEAD;
            HEAD.prev = node;
            HEAD = node;
        }

    }
    @Override
    public void addAfter(Object e, Object y) {
        Node node = new Node((T) y);
        Node trav = HEAD, prev;
        while (!trav.x.equals(e)) {
            trav = trav.next;
        }
        node.next = trav.next;
        node.prev = trav;
        trav.next = node;
    }
    @Override
    public void print() {
        System.out.println("FORWARD");
        Node trav = HEAD;
        while (trav != null) {
            System.out.println(" " + trav.x);
            trav = trav.next;
        }
    }
    @Override
    public void addAt(Object e, int pos) {
        Node trav = HEAD, prev = null;
        int i = 1;
        Node node = new Node((T) e);
        while (i++ < pos) {
            prev = trav;
            trav = trav.next;
        }
        node.next = trav;
        trav.prev = node;
        prev.next = node;
        node.prev = prev;
    }
    @Override
    public Object removeLast() {
        Node trav = HEAD, prev = null;
        while (trav.next != null) {
            prev = trav;
            trav = trav.next;
        }
        prev.next = null;
        return trav.x;
    }
    @Override
    public Object removeFirst() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T remove(Object e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }
    @Override
    public Object removeAt(int pos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private class Node {
        Node prev;
        T x;
        Node next;
        public Node(T x) {
            this.x = x;
            prev = next = null;
        }
    }
}