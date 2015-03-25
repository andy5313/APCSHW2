import java.util.*;
public class MyQueue<T>{
    
    private MyLinkedList<T> queue;
    
    public MyQueue(){
	queue = new MyLinkedList<T>();
    }

    public String name(){
	return "zheng.andy";
    }

    public boolean enqueue(T value){
	if (value == null){
	    throw new NullPointerException();
	}
	return queue.add(value);
    }

    public T dequeue(){
	if (queue.size() == 0){
	    throw new NoSuchElementException();
	}
	return queue.remove(0);
    }


}
