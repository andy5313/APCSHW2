public class MyLinkedList<T>{
    private LNode<T> head;
    private int size;
    
    public MyLinkedList(){
	head = new LNode<T>();
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
    }
}
