public class Coordinate{

    private int x;
    private int y;
    private Coordinate prev;
	
    public Coordinate(int x, int y){
	this.x = x;
	this.y = y;
    }

    public void setPrev(Coordinate p){
	prev = p;
    }
    public Coordinate getPrev(){
	return prev;
    }
    public int getX(){
	return x;
    }
    public int getY(){
	return y;
    }
	
	
}
