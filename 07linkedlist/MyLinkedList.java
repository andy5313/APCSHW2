public class MyLinkedList{
    private LNode head;
    private int size;
    
    public MyLinkedList(){
	head = new LNode(0);
	size = 0;
    }
    
    public String toString(){
	Strings ans = "[ ";
	LNode temp = head;
	while(temp!= null){
	    ans += temp.getValue() + ",";
	    temp = temp.getNext();
	}
	return ans.substring(0, ans.length()-1)+ " ]";
    }

    public int get(int index){
	if (index < 0 || index >= size){
	    throw new IndexOutofBoundsException();
	}
	LNode temp = head;
	for (int i = 0; i < index; i ++){
	    temp = temp.getNext();
	}
	return temp.getValue();
    }

    public void set(int index, int value){
	LNode temp = head;
	for (int i = 0; i < index; i++){
	    temp = temp.getNext();
	}
	temp.setValue(value);
    }

    public boolean add(int value){
	LNode next = new LNode(value);
	if (size == 0){
	    head = next;
	} else {
	    LNode temp = head;
	    for (int i = 0; i < size ; i++){
		temp = temp.getNext();
	    }
	    temp.setNext(next);
	}
	size ++;
	return true;
    }

    public boolean add(int index, int value){
	if (index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}
	LNode add = new LNode(value);
	if (index == 0){
	    add.setNext(head);
	    head = add;
	} else if (index == size() -1) {
	    add(value);
	} else {
	    LNode temp = head;
	    for (int i = 0; i < index -1; i ++){
		temp = temp.getNext();
	    }
	    LNode next = temp.getNext();
	    temp.setNext(add);
	    add.setNext(next);
	}
	size ++;
	return true;
	
    }
    public int remove(int index){

    }

    public int indexOf(int value){
	LNode temp = head;
	for (int i = 0; int i < size; i ++){
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
	
    }
}
