import java.util.*;
import java.io.*;

public class Frontier{
    
    private MyDeque<Coordinate> d;
    private int DFS = 0;
    private int BFS = 1;
    private int Best = 2;
    private int AStar = 3;
    private int mode;
    private int endx, endy;

    public Frontier(int mode){
	this.mode = mode;
	d = new MyDeque<Coordinate>();
    }

     public Frontier(int mode, int endx, int endy){
	this.mode = mode;
	d = new MyDeque<Coordinate>();
	this.endx = endx;
	this.endy = endy;
    }

    public void add(Coordinate c){
	int cx = c.getX();
	int cy = c.getY();
	if (mode == DFS){
	    d.addFirst(c);
	}else if(mode == BFS){
	    d.addLast(c);
	}else if (mode == Best){
	    d.add(c, Math.abs(endx - cx) + Math.abs(endy - cy));
	}else{
	    d.add(c, Math.abs(endx - cx) + Math.abs(endy - cy) + c.getStepsTaken());
	}
    }


    public Coordinate remove(){
        if (mode == BFS || mode == DFS){
	    return d.removeFirst();
	}else{
	    return d.removeSmallest();
	}
    }

    public boolean isEmpty(){
	return d.isEmpty();
    }

}
