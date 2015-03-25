import java.util.*;

public class MyDeque<T>{
    private int head,tail,size;
    private Object[] array;

    public MyDeque(){
	array = new Object[10];
	head = 4;
	tail = 5;
	size = 0;
    }

    public void addFirst(T value){
	array[head] = value;
	head--;
	size++;
	if (head == -1){
	    head = array.length-1;
	}
    }

    public void addLast(T value){
	array[tail] = value;
	tail++;
	size++;
	if(tail == array.length){
	    tail = 0;
	}
    }

    public T removeFirst(){
	if (head == array.length -1){
	    head = 0;
	}else{
	    head++;
	}
	T temp =(T)array[head];
	array[head] = null;
	return temp;	
    }

    public T removeLast(){
	if (tail == 0){
	    tail = array.length-1;
	}else{
	    tail--;
	}
	T save = (T)array[tail];
	array[tail] = null;
	return save;
    }
    

}
