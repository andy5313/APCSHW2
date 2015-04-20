import java.util.*;

public class MyDeque<T>{
    private int head,tail,size;
    private Object[] d;
    private int[] priority;

    public String name(){
	return "andy.zheng";
    }
    public MyDeque(){
	d = new Object[10];
	priority = new int[10];
	head = 5;
	tail = 4;
	size = 0;
    }

    public boolean isEmpty(){
	return size == 0;
    }
    public void addFirst(T value){
	if (size == d.length){
	    expand();
	}
	head--;
	if (head == -1){
	    head = d.length-1;
	}
	d[head] = value;
	size++;

    }

    public void addLast(T value){
	if (size == d.length){
	    expand();
	}
	tail++;
	if(tail == d.length){
	    tail = 0;
	}
	d[tail] = value;
	size++;

    }

    public T removeFirst(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
	size --;
	T first = (T)d[head];
	head ++;
	if (head == d.length){
	    head = 0;
	}
	return first;	
    }

    public T removeLast(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
	size --;
	T last = (T)d[tail];
	tail --;
	if (tail == -1){
	    tail = d.length - 1;
	}
	return last;
    }
    
    public void expand(){
	Object[] a = new Object[d.length * 2];
	if (head < tail){
	    for (int i = head; i <= tail; i ++){
		a[i] = d[i];
	    }
	}else{
	    for (int i = head; i < d.length; i ++){
		a[i] = d[i];
	    }
	    for (int i = 0; i <= tail; i ++){
		a[i + d.length] = d[i];
	    }
	    tail += d.length;
	}
        d = a;
    }    

    public String toString(){
	String s = "[ ";
	if (size > 0){
	    if (head <= tail){
		for (int i = head; i <= tail; i ++){
		    s += d[i] + " ";
		}
	    }else{
		for (int i = head; i < d.length; i ++){
		    s += d[i] + " ";
		}
		for (int i = 0; i <= tail; i ++){
		    s += d[i] + " ";
		}
	    }
	}
	return s + "]";
    }

    public void addPriority(T value, int p){
	if (size == d.length){
	    expandPriority();
	    expand();
	}
	addFirst(value);
	priority[head] = p;
    }

    public void expandPriority(){
	int[] a = new int[d.length * 2];
	if (head < tail){
	    for (int i = head; i <= tail; i ++){
		a[i] = priority[i];
	    }
	}else{
	    for (int i = head; i < priority.length; i ++){
		a[i] = priority[i];
	    }
	    for (int i = 0; i <= tail; i ++){
		a[i + priority.length] = priority[i];
	    }
	}
        priority = a;
    }

    public T removeSmallest(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
	int smallest = priority[head];
	int index = head;
        Object remove = d[head];
	if (head < tail){
	    for (int i = head; i <= tail; i ++){
		if (priority[i] < smallest){
		    smallest = priority[i];
		    index = i;
		    remove = d[i];
		}
	    }
	}else{
	    for (int i = head; i < priority.length; i ++){
		if (priority[i] < smallest){
		    smallest = priority[i];
		    index = i;
		    remove = d[i];
		}
	    }
	    for (int i = 0; i <= tail; i ++){
		if (priority[i] < smallest){
		    smallest = priority[i];
		    index = i;
		    remove = d[i];
		}
	    }
	}
        d[index] = d[head];
	priority[index] = priority[head];
	head ++;
	if (head == d.length){
	    head = 0;
	}
	size --;
	return (T)remove;

    }
    
    public String toStringPriority(){
	String s = "[ ";
	if (size > 0){
	    if (head <= tail){
		for (int i = head; i <= tail; i ++){
		    s += priority[i] + " ";
		}
	    }else{
		for (int i = head; i < priority.length; i ++){
		    s += priority[i] + " ";
		}
		for (int i = 0; i <= tail; i ++){
		    s += priority[i] + " ";
		}
	    }
	}
	return s + "]";
    }

    

}
