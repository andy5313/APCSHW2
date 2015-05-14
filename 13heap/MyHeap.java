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

    public int getLeft(int n){
	return n * 2;
    }

    public int getRight(int n){
	return n*2 + 1;
    }

    public int getRoot(int n){
	return n / 2;
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
	while (getRoot(i) > 0){
	    int rootIn = getRoot(i);
	    if (!inOrder(rootIn, i)){
		swap(i, rootIn);
	    }
	    i = rootIn;
	}
    }

    private boolean inOrder(int parent, int child){
	if (isMax){
	    return (heap[parent] > heap[child]);
	}else{
	    return (heap[parent] < heap[child]);
	}
    }

    public int peek(){
	if (heap[0]==0){
	    throw new NoSuchElementException();
	}else{
	    return heap[1];
	}
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
	h.add(9);
	System.out.println(h);	
    }

}
