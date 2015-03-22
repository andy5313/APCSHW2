import java.util.*;

public class MyLinkedList<T> implements Iterable<T>{

    private class MyLLIterator<T> implements Iterator<T>{
	
	private LNode<T> current;
	
	public MyLLIterator(LNode<T> c){
	    current = c;
	}
	
	public boolean hasNext(){
	    return (current != null);
	}
	
	public T next(){
	    if (hasNext()){
		LNode<T> n = current;
		n = current.getNext();
		return n.getValue();
	    }else{
		throw new NoSuchElementException();
	    }
	}
	
	public void remove(){
	    throw new UnsupportedOperationException();
	}

    }

    public Iterator<T> iterator(){
	return new MyLLIterator<T>(head);
    }
   
    private LNode<T> head;
    private LNode<T> tail;
    private int size;

    
    public MyLinkedList(){
	head = new LNode<T>();
	tail = new LNode<T>();
	size = 0;
    }

    public String name(){
	return "zheng.andy";
    }
    
    public String toString(){
	String ans = "[ ";
	LNode<T> temp = head;
	while(temp!= null){
	    ans += temp.getValue() + ",";
	    temp = temp.getNext();
	}
	return ans.substring(0, ans.length()-1)+ " ]";
    }

    public T get(int index){
	if (index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}
	LNode<T> temp = head;
	for (int i = 0; i < index; i ++){
	    temp = temp.getNext();
	}
	return temp.getValue();
    }

    public void set(int index, T value){
	LNode<T> temp = head;
	for (int i = 0; i < index; i++){
	    temp = temp.getNext();
	}
	temp.setValue(value);
    }

    public boolean add(T value){
	LNode<T> next = new LNode<T>(value);
	if (size == 0){
	    head = next;
	} else {
	    LNode<T> temp = head;
	    for (int i = 0; i < size-1 ; i++){
		temp = temp.getNext();
	    }
	    temp.setNext(next);
	}
	size ++;
	return true;
    }

    public boolean add(int index, T value){
	if (index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}
	LNode<T> add = new LNode<T>(value);
	if (index == 0){
	    add.setNext(head);
	    head = add;
	} else if (index == size() -1) {
	    add(value);
	} else {
	    LNode<T> temp = head;
	    for (int i = 0; i < index -1; i ++){
		temp = temp.getNext();
	    }
	    LNode<T> next = temp.getNext();
	    temp.setNext(add);
	    add.setNext(next);
	}
	size ++;
	return true;
	
    }

    public T remove(int index){
	if (index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}
	LNode<T> removed;
	if (index == 0){
	    removed = head;
	    head = removed.getNext();
	}else if (index == size()-1){
	    LNode<T> temp = head;
	    for (int i = 0; i < size() - 2; i++){
		temp = temp.getNext();
	    }
	    removed = tail;
	    tail = temp;
	}else{
	    LNode<T> temp = head;
	    for (int i = 0; i < index - 1; i++){
		temp = temp.getNext();
	    }
	    removed = temp.getNext();
	    temp.setNext(removed.getNext());
	}
	size --;
	return removed.getValue();
    }

    public int indexOf(T value){
	LNode<T> temp = head;
	for (int i = 0; i < size; i ++){
	    if (temp.getValue() == value){
		return i;
	    }
	    temp = temp.getNext();
	}	
	return -1;
    }

    public int size(){
	return size;
    }

    public static void main(String[] args){
	MyLinkedList<Integer> list = new MyLinkedList<Integer>();
	list.add(5);
	list.add(10);
	list.add(2);
	list.add(7);
	list.add(8);
	System.out.println(list);
	list.remove(0);
	System.out.println(list);
    }
}
