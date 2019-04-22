
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
			throw new NullPointerException();
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
        int rightChild = 2 * parent + 2;
        int leftChild =  2 * parent + 1; 
        while(isleaf(pos)) {
        	//compares if the leftchild is less than the right child
        	if(data[leftChild] < data[rightChild]) {
        		swap(parent, leftChild);
        		parent = leftChild;
        		leftChild = 2 * parent + 1;
        		
        	}
        	//compares the right child with the parent
        	else if(data[parent] > data[rightChild]) {
        		swap(parent, rightChild);
        		parent = rightChild;
        		rightChild = 2 * parent + 2;
        	}
        		
        }
	}
	
	protected void increaseCapacity() {
		int[] temp = new int[size * 2];
		for(int i = 0; i < data.length; i++) {
			temp[i] = data[i];
		}
		data = temp;
	}
	    
	    private void swap(int pos1, int pos2) {
		int temp;

		temp = data[pos1];
		data[pos1] = data[pos2];
		data[pos2] = temp;
    }
	    
    private boolean isleaf(int pos) {
    	return ((pos > size/2) && (pos <= size));
        }
    
    public void print() {
    	int i;
    	for (i=1; i<=size;i++)
    	    System.out.print(data[i] + " ");
    	System.out.println();
        }

    public static void main(String args[]) {
    	
    }
}
