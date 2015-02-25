public class NQueens{

    final static String clear =  "\033[2J";
    final static String hide =  "\033[?25l";
    final static String show =  "\033[?25h";

    private char[][]board;

    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }
 
    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }

    public String name(){
	return "zheng.andy";
    }

    public String toString(){
	String ans = "\n";
	for (int x = 0; x < board.length; x ++){
	    for (int y = 0; y < board[0].length; y ++){
		ans += " " + board[x][y];
	    }
	    ans += "\n";
	}
	return hide + clear + go(0,0) + ans + "\n" + show;
    }

    public NQueens(int size){
	board = new char[size][size];
	for (int x = 0; x < size; x ++){
	    for (int y = 0; y < size; y ++){
		board[x][y] = '.';
	    }
	}
    }



}
