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
	for (int y = 0; y < size; y ++){
	    for (int x = 0; x < size; x ++){
		board[y][x] = '.';
	    }
	}
    }
    
    public boolean solve(){
	return solve(0, board.length);
    }
    
    public boolean solve(int x){
	if (x < 0 || x > board.length){
	    return false;
	}
	board[0][x] = 'Q';
	return solve(1, board.length - 1);
    }

    public boolean solve(int x, int numQueens){
	if (numQueens == 0){
	    return true;
	}
	for (int y = 0; y < board.length; y ++){

	    if (canPlaceQueen(y, x)){

	        board[x][y] = 'Q';

		if (solve(x + 1, numQueens - 1)){
		    return true;
		}

		board[x][y] = '.';
	    }
	}

	return false;
    }

    public boolean canPlaceQueen(int col, int row){
	// checks vertical for queen
        for (int i = row; i >= 0; i --){
	    if (board[i][col] == 'Q'){
		return false;
	    }
	}

	//checks up-left diagonal for queen
	int c = col;
	int r = row;
	while(c >= 0 && r >= 0){
	    if (board[r][c] == 'Q'){
		return false;
	    }
	    c --;
	    r --;
	}

	//checks up-right diagonal for queen
	c = col;
	r = row;
        while(c < board.length && r >= 0){
	    if (board[r][c] == 'Q'){
		return false;
	    }
	    c++;
	    r--;
	}

	return true;
    }

    public static void main(String[] args){
	NQueens q = new NQueens(8);
	if (q.solve()){
	    System.out.println(q);
	}else{
	    System.out.println("Not Possible");
	}
    }
}
