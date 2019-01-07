package interview;
import java.util.Arrays;
public class Stack<T extends Comparable<T>> implements DSUtility {
    /* FOR O(1) MIN-MAX */
    private final  java.util.Stack<T> minStack=new java.util.Stack<>();
    private final  java.util.Stack<T> maxStack=new java.util.Stack<>();
    private Object stack[];
    private int TOP;
    private int SIZE;
    public boolean isFull(){
        return (TOP==SIZE-1);
    }
    public boolean isEmpty(){
        return (TOP==-1);
    }
    public Stack(int N){
        if(N <= 0)
            throw new RuntimeException("SIZE CANNOT BE NEGATIVE!!");
        stack=new Object[N];
        TOP=-1;
        SIZE=N;
    }
    public Stack(){
        stack=new Object[10];
        TOP=-1;
        SIZE=10;
    }
    protected  void pushSupportingStack(T e){
        if(minStack.isEmpty())
            minStack.push(e);
        if(e.compareTo(minStack.peek()) < 0)
            minStack.push(e);
        if(maxStack.isEmpty())
            maxStack.push(e);
        if(e.compareTo(maxStack.peek())> 0)
            maxStack.push(e);
    }
    public void push(T e){
        if(TOP==SIZE-1){
            System.out.println("Stack is Full");
        }else{
            pushSupportingStack(e);
            stack[++TOP]=e;
        }
    }
    public T pop(){
        if(TOP==-1){
            System.out.println("NOTHING TO POP!!");
            return null;
        }else{
            return (T)stack[TOP--];
        }
    }
    public void print(){
        if(TOP==-1)
            throw new RuntimeException("STACK IS EMPTY!");
        int HEAD=TOP;
        while(HEAD!=-1){
            System.out.print(" "+stack[HEAD]);
            HEAD--;
        }
    }
    public static boolean isBalanced(String y){
		Stack<Character> stack=new Stack<>();
		for(int i=0;i<y.length();i++){
			char c=y.charAt(i);
			if(c=='('||c=='['||c=='{')
				stack.push(c);
			else if((c=='}' || c==']' || c==')') && !stack.isEmpty()){
				if((stack.peek()=='{' && c=='}') || (stack.peek()=='[' && c==']') || (stack.peek()=='(' && c==')') ){
					stack.pop();
				}else{
					return false;
				}
			}else{
				if(c==']' || c=='}' || c==')')
					return false;
			}

		}
		return (stack.isEmpty());
	}
    public T peek(){
        if(TOP==-1)
            throw new RuntimeException("STACK IS EMPTY!!");
        return (T)stack[TOP];
    }
    @Override
    public Object min() {
        return minStack.peek();
    }
    @Override
    public Object max() {
        return maxStack.peek();
    }
    @Override
    public void sort() {
        Arrays.sort(stack);
    }
    public int size(){
        return SIZE;
    }
}
