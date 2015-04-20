import java.util.*;
import java.io.*;
public class Maze{

    private char[][]maze;
    private int maxx,maxy;
    private int startx,starty;
    private int endx, endy;
    private Coordinate end;
    private int solveNum, stepsTaken;
    private int[] solutionCoor;
    private int DFS = 0;
    private int BFS = 1;
    private int Best = 2;
    private int AStar = 3;


    public Maze(String filename){
	startx = -1;
	starty = -1;
	String ans = "";
	try{
	    Scanner in = new Scanner(new File(filename));

	    while(in.hasNext()){
		String line= in.nextLine();
		if(maxy==0){
		    maxx=line.length();
		}
		maxy++;
		ans+=line;
	    }
	}
	catch(Exception e){
	    System.out.println("File: "+filename+" could not be opened.");
	    e.printStackTrace();
	    System.exit(0);
	}

	maze = new char[maxx][maxy];
	for(int i=0;i<ans.length();i++){
	    char c = ans.charAt(i);
	    maze[i%maxx][i/maxx]= c;
	    if(c=='S'){
		startx = i%maxx;
		starty = i/maxx;
	    }
	}
	
    }

    private static final String clear =  "\033[2J";
    private static final String hide =  "\033[?25l";
    private static final String show =  "\033[?25h";

    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }

    public String toString(){
	String ans = "" + maxy + " rows " + maxx + " columns\n";
	for (int y = 0; y < maxy; y ++){
	    for (int x = 0; x < maxx; x ++){
		ans += maze[x][y];
	    }
	    ans += "\n";
	}
	return ans;
    }

    public String toString(boolean animate){
	if (animate){
	    return hide + clear + go(0,0) + toString() + show;
	}else{
	    return toString();
	}
    }

    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }



    public boolean solveDFS(){
	return solve(0, false);
    }
    public boolean solveDFS(boolean animate){
	return solve(0, animate);
    }
    public boolean solveBFS(){
	return solve(1, false);
    }
    public boolean solveBFS(boolean animate){
	return solve(1, animate);
    }
    public boolean solveBest(){
	return solveBest(false);
    }
    public boolean solveBest(boolean animate){
	return solve(2, animate);
    }
    public boolean solveAStar(){
	return solveAStar(false);
    }
    public boolean solveAStar(boolean animate){
	return solve(3, animate);
    }


    public boolean solve(int mode, boolean animate){
	Frontier f = new Frontier(mode, endx, endy);
	Coordinate start = new Coordinate(startx, starty, 0);
	f.add(start);

	while(!f.isEmpty()){
	    if (animate){
		wait(30);
		System.out.println(toString(animate));
	    }
	    
	    Coordinate current = f.remove();
	    int x = current.getX();
	    int y = current.getY();

	    if (maze[x][y] == 'E'){
		end = current;
		Coordinate c = end;
		while(c != null){
		    solveNum ++;
		    c = c.getPrev();
		}

		clearPath();
		addSolution();
		System.out.println(toString());
		return true;
	    }else{
		maze[x][y] = '.';
		Coordinate[] nextMoves = new Coordinate[]{
		    new Coordinate(x-1, y, current.getStepsTaken()+1),
		    new Coordinate(x+1, y, current.getStepsTaken()+1),
		    new Coordinate(x, y-1, current.getStepsTaken()+1),
		    new Coordinate(x, y+1, current.getStepsTaken()+1),
		};
		for (Coordinate cord : nextMoves){
		    cord.setPrev(current);
		    int cx = cord.getX();
		    int cy = cord.getY();
		    if (inMaze(cx,cy) && isValid(cx,cy)){
			f.add(cord);
		    }
		}	
	    }
	}
	

	System.out.println("No Solution\n");
	return false;
	
    }

    public void clearPath(){
	Coordinate c = end;
	while (c != null){
	    int x = c.getX();
	    int y = c.getY();
	    if (x == end.getX() && y == end.getY()){
		maze[x][y] = 'E';
	    }else if (x == startx && y == starty){
		maze[x][y] = 'S';
	    }else{
		maze[x][y] = 'P';
	    }
	    c = c.getPrev();
	}
	for (int y = 0; y < maxy; y ++){
	    for (int x = 0; x < maxx; x ++){
		if (maze[x][y] == '.'){
		    maze[x][y] = ' ';
		}
	    }
	}
    }

    public boolean inMaze(int x, int y){
	return (x > 0 && y > 0 && x <= maxx && y <= maxy);
    }

    public boolean isValid(int x, int y){
	return !(maze[x][y] == '#' || maze[x][y] == '.');
    }

    public int abs(int x){
	if (x < 0){
	    x *= -1;
	    return x;
	}else{
	    return x;
	}
    }

    public void addSolution(){
	solutionCoor = new int[solveNum * 2];
	Coordinate c = end;
	int i = 0;
	while (c!= null){
	    solutionCoor[i] = c.getX();
	    solutionCoor[i+1] = c.getY();
	    i += 2;
	    c = c.getPrev();
	}
	for (int x = 0; x < solutionCoor.length / 2; x ++){
	    int temp = solutionCoor[x];
	    solutionCoor[x] = solutionCoor[solutionCoor.length - x - 1];
	    solutionCoor[solutionCoor.length - x - 1] = temp;
	}	
    }

    public int[] solution(){
	return solutionCoor;
    }

}
