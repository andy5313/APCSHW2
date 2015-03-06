import java.util.*;
public class quickSelect{

    public static void partition( int[] ary, int si, int ei ){
	Random rand = new Random();
	int pivot = rand.nextInt(ei+1-si) + si;
	int[] D = new int[ary.length];
	int first = si;
	int last = ei;
	
	for (int i = si; i <= ei; i ++){
	    if (ary[i] < ary[pivot]){
		D[first] = ary[i];
		first ++;
	    }
	    if (ary[i] > ary[pivot]){
		D[last] = ary[i];
		last --;
	    }
	}
	D[first] = ary[pivot];
	
	for (int i = si - 1; i >= 0; i --){
	    D[i] = ary[i];
	}
	for (int i = ei + 1; i < ary.length; i ++){
	    D[i] = ary[i];
	}
    }

    public static void main(String[] args){
	int [] a = {5, 7, 10, 8, 1, 6 , 3 , 4, 9, 2};
	partition(a, 0, 9);
	for (int i = 0; i < a.length; i ++){
	    System.out.print(a[i] + " ");
	}
    }
}
