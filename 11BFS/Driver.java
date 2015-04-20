import java.util.*;
public class Driver{
    public static void main(String[]args){
	
	Maze m = new Maze("data1.dat");
	boolean b = false;
	

	if (args.length > 1 && args[1].equals("true")){
	    b = true;
	}
	if (args[0].equals("BFS")){
	    m.solveBFS(b);
	    System.out.println(Arrays.toString(m.solution()));
	}else if (args[0].equals("DFS")){
	    m.solveDFS(b);
	    System.out.println(Arrays.toString(m.solution()));
	}else if (args[0].equals("Best")){
	    m.solveBest(b);
	    System.out.println(Arrays.toString(m.solution()));
	}else if (args[0].equals("AStar")){
	    m.solveAStar(b);
	    System.out.println(Arrays.toString(m.solution()));
	}
	
	
    
    }
}
