import java.util.*;

public class MyStack<T>{
    private MyLinkedList<T> stack;

    public MyStack(){
	stack = new MyLinkedList<T>();
    }

    public String name(){
	return "zheng.andy";
    }

    public void push(T value){
	if (stack.size()==0){
	    stack.add(value);
	}else{
	    stack.add(0, value);
	}
    }
   
    public T peak(){
	if (stack.size()==0){
	    throw new EmptyStackException();
	}
	return stack.get(0);
    }

    public T pop(){
	if (stack.size()==0){
	    throw new EmptyStackException();
	}
	return stack.remove(0);
    }
    
    public static void main(String[] args){
	MyStack<Integer> stack = new MyStack<Integer>();
	stack.push(1);
	stack.push(2);
	stack.push(3);
	System.out.println(stack.pop());
	System.out.println(stack.peak());
	
    }
}
