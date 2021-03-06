import java.util.*;

public class MyDeque<T>{
    private int head,tail,size;
    private Object[] array;

    public String name(){
	return "andy.zheng";
    }
    public MyDeque(){
	array = new Object[10];
	head = 4;
	tail = 5;
	size = 0;
    }

    public void addFirst(T value){
	if (size == array.length){
	    expand();
	}
	head--;
	if (head == -1){
	    head = array.length-1;
	}
	array[head] = value;
	size++;

    }

    public void addLast(T value){
	if (size == array.length){
	    expand();
	}
	tail++;
	if(tail == array.length){
	    tail = 0;
	}
	array[tail] = value;
	size++;

    }

    public T removeFirst(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
	size --;
	T first = (T)array[head];
	head ++;
	if (head == array.length){
	    head = 0;
	}
	return first;	
    }

    public T removeLast(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
	size --;
	T last = (T)array[tail];
	tail --;
	if (tail == -1){
	    tail = array.length - 1;
	}
	return last;
    }
    
    public void expand(){
	Object[] a = new Object[array.length * 2];
	if (head < tail){
	    for (int i = head; i <= tail; i ++){
		a[i] = array[i];
	    }
	}else{
	    for (int i = head; i < array.length; i ++){
		a[i] = array[i];
	    }
	    for (int i = 0; i <= tail; i ++){
		a[i + array.length] = array[i];
	    }
	    tail += array.length;
	}
        array = a;
    }    

    public String toString(){
	String s = "[ ";
	if (size > 0){
	    if (head <= tail){
		for (int i = head; i <= tail; i ++){
		    s += array[i] + " ";
		}
	    }else{
		for (int i = head; i < array.length; i ++){
		    s += array[i] + " ";
		}
		for (int i = 0; i <= tail; i ++){
		    s += array[i] + " ";
		}
	    }
	}
	return s + "]";
    }

    public static void main(String[] args){
	
	MyDeque<String> d = new MyDeque<String>();
	System.out.println(d);

    }
    

}
