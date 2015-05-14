import java.util.*;
import java.io.*;

public class MyHeap{

    private int[] heap;
    private boolean isMax;

    public MyHeap(){
	this(true);
    }
    public MyHeap(boolean isMax){
	heap = new int[10];
	heap[0] = 0;
	this.isMax = isMax;
    }
    
    public String name(){
	return "andy.zheng";
    }

    public void swap(int first, int second){
	int saved = heap[first];
	heap[first] = heap[second];
	heap[second] = saved;
    }

    public void add(int n){
	if (heap[0] == heap.length-1) {
	    resize();
	}

	heap[0] = heap[0]+1;
	heap[heap[0]]= n;
	int i = heap[heap[0]];
	while (i / 2 > 0){
	    if (heap[i] > heap[i / 2]){
		swap(i, i / 2);
	    }
	    i = i /2;
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

    private void resize(){ 
	int[] copy = Arrays.copyOf(heap, heap.length*2);
	heap = copy;
    }

    public static void main(String[]args){
	MyHeap h = new MyHeap();
	
	h.add(5);
	h.add(8);
	h.add(3);
	System.out.println(h);	
    }

}
