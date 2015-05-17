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

    public int getParent(int n){
	return n / 2;
    }

    public int getLeft(int n){
	return n * 2;
    }

    public int getRight(int n){
	return n*2 + 1;
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
	while (getParent(i) > 0){
	    int parent = getParent(i);
	    if (!inPosition(parent, i)){
		swap(i, parent);
	    }
	    i = parent;
	}
    }

    public int remove(){
	int size = heap[0];
	if (size == 0){
	    throw new NoSuchElementException();
	} else {
	    int removed = heap[1];
	    heap[1] = heap[size];
	    shiftDown(1);
	    heap[0] = size--;
	    return removed;
	}
    }

    public boolean hasLeft(int i){
	return (getLeft(i) <= heap[0]);
    }

    public boolean hasRight(int i){
	return (getRight(i) <= heap[0]);
    }

    private void shiftDown(int i){
	int size = heap[0];
	while (hasLeft(i) == true){ 
	    int l = getLeft(i);
	    int r = getRight(i);
	    if (hasRight(i) == true){ 
		if (!inPosition(i, l) || !inPosition(i, l)){
		    if (isMax = true){
			if (heap[l]> heap[r]){
			    swap(i, l);
			    i = l;
			}else if (heap[l] < heap[r]){
			    swap(i, r);
			    i = r;
			}
		    }else{
			if (heap[l] < heap[r]){
			    swap(i, l);
			    i = l;
			}else{
			    swap(i, r);
			    i = r;
			}
		    }
		}else{
		    return;
		}
	    }else if (!inPosition(i, l)){
		swap(i, l);
		i = l;
	    }else{
		return;
	    }
	}
    }

    private boolean inPosition(int parent, int child){
	if (isMax){
	    if (heap[child] < heap[parent]){
		return true;
	    }else {
		return false;
	    }
	}else{
	    if (heap[child] > heap[parent]){
		return true;
	    }else {
		return false;
	    }
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
	String ret = "[";
	for (int i = 1; i <= heap[0]; i ++){
	    ret += " " + heap[i];
	}	
	return ret + " ]";
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
	h.remove();
	System.out.println(h);
       
    }

}
