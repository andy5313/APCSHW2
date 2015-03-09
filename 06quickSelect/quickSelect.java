import java.util.Arrays;

public class quickSelect{

    public static int quickselect(int[] ary,int index){
	int si = 0;
	int ei = ary.length-1;
	int partindex = -1;

	while (index != partindex){
	    partindex = partition(ary,si,ei);
	    if (index > partindex){
		si = partindex;
		partindex = partition(ary,si,ei);
	    }else if (index < partindex){
		ei = partindex;
		partindex = partition(ary,si,ei);
	    }
	}
	return ary[partindex];
    }

    public static int partition(int[] ary,int si, int ei){
	int ri = si + (int)(Math.random()*(ei-si+1));
	int pivot = ary[ri];
	int end = ei;
	int[] copy= new int[ary.length];
	for (int i=0;i<ary.length;i++){
	    if (i<si || i>ei){
		copy[i] = ary[i];
	    }
	}
	for (int i=si;i<=end;i++){
	    if (ary[i] < pivot){
		copy[si] = ary[i];
		si++;
	    }else if (ary[i] > pivot){
		copy[ei] = ary[i];
		ei--;
	    }
	}
	copy[si] = pivot;
	System.arraycopy(copy,0,ary,0,ary.length);
	return si;
    }


}
