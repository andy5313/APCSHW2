public class LNode{
    private int value;
    private LNode next;

    public LNode(int Value){
	value = Value;
    }
    public int getValue(){
	return value;
    }

    public void setValue(int Value){
	value = Value;
    }

    public LNode getNext(){
	return next;
    }

    public void setNext(LNode Next){
	next = Next;
    }
       
}
