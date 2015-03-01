

public class makeLake {
    
    private int[][] pasture = {{28, 25, 20, 32, 34, 36},
			       {27, 25, 20, 20, 30, 34},
			       {24, 20, 20, 20, 20, 30},
			       {20, 20, 14, 14, 20, 20}};
    private int pastureX;
    private int pastureY;
    

    public makeLake(int pastureX, int pastureY) {
	this.pastureX = pastureX;
	this.pastureY = pastureY;

    }
    
    public void stomp(int y, int x, int stomps) {
        int maxVal = 0;
	y--;
	x--;
	for (int r = y; r < y + 3; r++) {
	    for (int c = x; c < x + 3; c++) {
		if (pasture[r][c] > maxVal) {
		    maxVal = pasture[r][c];
		}
	    }
	}

	for (int r = y; r < y + 3; r++) {
	    for (int c = x; c < x + 3; c++) {
		int stompsRemoved = maxVal - pasture[r][c];
		if (stompsRemoved < stomps) {
		    pasture[r][c] -= stomps - stompsRemoved;
		}
	    }
	}
    }

    public int TDepth(int lakeElevation) {
	int lakeTDepth = 0;

	for (int r = 0; r < pastureY; r++) {
	    for (int c = 0; c < pastureX; c++) {
		if (lakeElevation - pasture[r][c] > 0) {
		    lakeTDepth += lakeElevation - pasture[r][c];
		}
	    }
	}
	
	return lakeTDepth;
    }

    public int volume() {
	return 72 * 72 * TDepth(22);
    }

    public String toString() {
	String s = "";
	for (int r = 0; r < pastureY; r++) {
	    for (int c = 0; c < pastureX; c++) {
		s += String.format("%3d", pasture[r][c]);
	    }
	    s += "\n";
	}
	return s;
    }

    public static void main(String[] args) {
	makeLake lake = new makeLake(6,4);
	lake.stomp(1, 4, 4);
	lake.stomp(1, 1, 10);
	System.out.println(lake);
	System.out.println(lake.TDepth(22));
	System.out.println(lake.volume());
    }
    
}
