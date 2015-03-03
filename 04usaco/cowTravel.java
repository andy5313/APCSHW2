import java.util.*;
import java.io.*;
public class cowTravel{
    
    private File input;
    private Scanner scan;
    private String[][]field;
    private int r,c,startr,startc,endr,endc,steps,count;

    public cowTravel(){
	try{
	    input = new File("ctravel.txt");
	    scan = new Scanner(input);
	} catch (Exception e){}
	
	field = new String[scan.nextInt()][scan.nextInt()];
	steps = scan.nextInt();
	
	for (int x = 0; x < field.length; x ++){
	    for (int y = 0; y < field[0].length; y++){
		field[x][y] = scan.next();
	    }
	}

	startr = scan.nextInt() - 1;
	startc = scan.nextInt() - 1;
	endr = scan.nextInt() - 1;
	endc = scan.nextInt() - 1;
    }

    public int solve(){
        this.solve(startr,startc,0);
	return count;
    }
	
    
    public void solve(int r,int c,int seconds){
	if (r<field.length && r >=0 && c<field[0].length && c>=0 && seconds <= steps){
	    if (seconds == steps && r == endr && c == endc){
		count++;
	    }
	    if (field[r][c].equals(".")){
		solve(r+1,c,seconds+1);
		solve(r,c+1,seconds+1);
		solve(r-1,c,seconds+1);
		solve(r,c-1,seconds+1);
	    }
	}
    }


    public static void main (String[]args){
	cowTravel c = new cowTravel();
	System.out.println(c.solve());
    }
}
