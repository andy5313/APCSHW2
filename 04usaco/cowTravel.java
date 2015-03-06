import java.util.*;
import java.io.*;
public class cowTravel{
    
    private File input;
    private Scanner scan;
    private String[][]field;
    private int r,c,startr,startc,endr,endc,ways,seconds;

    public cowTravel(){
	try{
	    input = new File("ctravel.txt");
	    scan = new Scanner(input);
	} catch (Exception e){}
	
	r = scan.nextInt();
	c = scan.nextInt();
	field = new String[r][c];
	seconds = scan.nextInt();
	
	for (int x = 0; x < field.length; x ++){
	    for (int y = 0; y < field[0].length; y++){
		field[x][y] = scan.next();
	    }
	}

	startr = scan.nextInt() - 1;
	startc = scan.nextInt() - 1;
	endr = scan.nextInt() - 1;
	endc = scan.nextInt() - 1;
	ways = 0;
    }

    public int solve(){
        solve(startr,startc,seconds);
	return ways;
    }
	
    
    public void solve(int x,int y,int steps){
	if (x<0|| y <0 || x >= field[0].length || y<0 || y >= field.length){
	    return;
	}
	if (x == endr && y ==endc && steps == 0){
	    ways++;
	    return;
	}
	if (field[x][y].equals("*") || steps ==0){
	    return;
	}
	solve(x+1,c,steps-1);
	solve(x,c+1,steps-1);
	solve(r-1,c,steps-1);
	solve(r,c-1,steps-1);
	    
	
    }


    public static void main (String[]args){
	cowTravel c = new cowTravel();
	System.out.println(c.solve());
    }
}
