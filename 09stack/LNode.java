public class LNode<T>{
    private T value;
    private LNode<T> next;

    public LNode(){

    }
    public LNode(T Value){
	value = Value;
    }
    public T getValue(){
	return value;
    }

    public void setValue(T Value){
	value = Value;
    }

    public LNode<T> getNext(){
	return next;
    }

    public void setNext(LNode<T> Next){
	next = Next;
    }
       
}
