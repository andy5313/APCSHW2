public class Frontier{
    
    private MyDeque<Coordinate> d;
    private int mode;

    public Frontier(int mode){
	this.mode = mode;
	d = new MyDeque<Coordinate>();
    }

    public void add(Coordinate value){
	if (mode == 0){
	    d.addFirst(value);
	}else if (mode == 1){
	    d.addLast(value);
	}
    }
    public Coordinate remove(){
	return d.removeFirst();
    }

    public boolean isEmpty(){
	return d.isEmpty();
    }

}
