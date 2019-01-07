package interview;
public class LinkedStack<T> {
    private final LinkedList<T> stack;
    public LinkedStack(){
        stack=new LinkedList<>();
    }
    public void push(T e){
        stack.addFirst(e);
    }
    public T pop(){
       return  stack.removeFirst();
    }
    public void print(){
        stack.print();
    }
}
