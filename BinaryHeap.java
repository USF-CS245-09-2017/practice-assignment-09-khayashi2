import java.util.Arrays;
import java.util.NoSuchElementException;

public class BinaryHeap {

	private int[] data;
	private final static int DEFAULT_SIZE = 10;
	private int size;
	
	public BinaryHeap() {
		data = new int[DEFAULT_SIZE];
		size = 0;
	}
	
	public void add(int target){
		if(size == data.length) 
			increaseCapacity();
		
		data[size++] = target;
		int current = size - 1;
		int parent = (current  - 1) / 2;
		
		while(current != 0 && data[current] < data[parent]) {
			swap(current, parent);	
			current = parent;
			parent = (parent - 1) / 2;
		}
		
	}
	
	public int remove(){
		if(size == 0) {
			throw new NoSuchElementException();
		}
		swap(0, size - 1);
		--size;
		if(size > 0) {
			shiftdown(0);
		}
		return data[size];
		
	}
	
	private void shiftdown(int pos) {
		int parent = pos;
        while(hasLeftChild(parent)) {
        	int smallChild = getLeftChildIndex(parent);
        	//compare the left and right child and see which is smallest
        	if(hasRightChild(parent) && data[getRightChildIndex(parent)] < data[getLeftChildIndex(parent)])
        		smallChild = getRightChildIndex(parent);
        	
        	if(data[parent] < data[smallChild])
        		break;
        	else
        		swap(parent,smallChild);
        		
        	parent = smallChild;
        		
        }
	}
	
	protected void increaseCapacity() {
		data = Arrays.copyOf(data, size * 2);
	}
	    
	    private void swap(int pos1, int pos2) {
		int temp;

		temp = data[pos1];
		data[pos1] = data[pos2];
		data[pos2] = temp;
    }
	    
    private int getLeftChildIndex(int index) {
    	return 2 * index + 1;
    }
    
    private int getRightChildIndex(int index) {
    	return 2 * index + 2;
    }
    
    private int getParentIndex(int index) {
    	return ((index - 1) / 2);
    }
    
    
    private boolean hasLeftChild(int index) {
    	return getLeftChildIndex(index) < size;
    }
    
    private boolean hasRightChild(int index) {
    	return getRightChildIndex(index) < size;
    }
    
    
    
    public void print() {
    	int i;
    	for (i=1; i<=size;i++)
    	    System.out.print(data[i] + " ");
    	System.out.println();
        }

}
