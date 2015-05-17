public class RunningMedian{
    private MyHeap maxHeap;
    private MyHeap minHeap;

    public RunningMedian(){
	maxHeap = new MyHeap();
	minHeap = new MyHeap(false);	
    }

    public double getMedian(){
	if (maxHeap.getSize() > minHeap.getSize()){
	    return maxHeap.peek();
	} else if (minHeap.getSize() > maxHeap.getSize()){
	    return minHeap.peek();
	} else { 
	    return (maxHeap.peek() + minHeap.peek()) / 2.0;
	}
    }

    public void add(int num){
	if (maxHeap.getSize() == minHeap.getSize()){
	    minHeap.add(num);
	} else {
	    double median = getMedian();
	    if (num > median){
		maxHeap.add(num);
	    } else if (num < median){
		minHeap.add(num);
	    }
	}
    
	if (minHeap.getSize() - maxHeap.getSize() > 1){
	    maxHeap.add(minHeap.remove());
	}else if (maxHeap.getSize() - minHeap.getSize() > 1){
	    minHeap.add(maxHeap.remove());
	}
    }
    

    public static void main(String[] args){
	RunningMedian m = new RunningMedian();
	m.add(5);
	m.add(9);
	m.add(4);
	m.add(1);
	m.add(6);
	m.add(7);
	System.out.println(m.getMedian());
    }
    
}
