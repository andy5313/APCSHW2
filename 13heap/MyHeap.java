public class MyHeap{

    private int[] heap;
    private int size;
    private boolean isMax;

    public MyHeap(){
	this(true);
    }
    public MyHeap(boolean isMax){
	heap = new int[10];
	size = 0;
	this.isMax = isMax;
    }
    
    public String name(){
	return "andy.zheng";
    }

    public void swap(int first, int second){
	int saved = heap[first];
	heap[first] = heap[second];
	heap[b] = saved;
    }

    public void add(int n){


    }

    public int remove(){
}
	
    }

    public int peek(){
	return heap[1];
    }

    public String toString(){
	String ret = "";
	
	ret += "[";
	for (int i = 1; i <= heap[0]; i ++){
	    ret += " " + heap[i];
	}
	ret += " ]";
	
	return ret;
    }

    public static void main(String[]args){
	
    }

}
