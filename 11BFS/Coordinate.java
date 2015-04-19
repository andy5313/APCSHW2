public class Coordinate{

    private int x;
    private int y;
    private Coordinate prev;
    private int stepsTaken;
	
    public Coordinate(int x, int y){
	this.x = x;
	this.y = y;
    }
    
    public Coordinate(int x, int y, int steps){
	this.x = x;
	this.y = y;
	stepsTaken = steps;
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
    public void setStepsTaken(int steps){
	stepsTaken = steps;
    }
    public int getStepsTaken(){
	return stepsTaken;
    }
    
	
}
