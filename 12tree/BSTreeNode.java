public class BSTreeNode<T extends Comparable>{

    private T data;
    private BSTreeNode<T> left, right;
    
    public BSTreeNode(T d){
	setData(d);
    }

    public void setData(T d){
	data = d;
    } 
    public T getData(){
	return data;
    }

    public void setLeft(BSTreeNode l){
	left = l;
    }
    public void setRight(BSTreeNode r){
	right = r;
    }
    public BSTreeNode<T> getLeft(){
	return left;
    }
    public BSTreeNode<T> getRight(){
	return right;
    }

    public int compareTo(BSTreeNode<T> o){
	return getData.compareTo((T)o.getData());
    }

}
