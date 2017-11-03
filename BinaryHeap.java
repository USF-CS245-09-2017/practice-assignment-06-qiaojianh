/*
	@Qiaojian Hu
*/
public class BinaryHeap{

	private int[] queue;
	private int size;

	public BinaryHeap(){
		this.queue = new int[10];
		this.size = 0;
	}

	private void grow(){
		int[] newArr = new int[queue.length*2];

		for (int i = 0; i < queue.length; i++) {
		 	newArr[i] = queue[i];
		}

		queue = newArr; 
	}

	public void add(int num){

    	int i = size;
    	if (i >= queue.length){
      		grow();
    	}	
    	size = i + 1;
    	if (i == 0){
        	queue[0] = num;
    	}else{
        	siftUp(i, num);
    	}
	}

	private void siftUp(int k, int num) {
    	while (k > 0) {
        	int parent = (k - 1)/2;
        	int tmp = queue[parent];
        	if (num >= tmp){
            	break;
            }
        	queue[k] = tmp;
        	k = parent;
    	}
    	queue[k] = num;
	}

	public int remove(){
		if (size == 0){
        	throw new IndexOutOfBoundsException();
    	}
    	int s = --size;
    	int result = queue[0];
    	int x = queue[s];
    	if (s != 0){
        	siftDown(0, x);
        }
    	return result;
	}

	private void siftDown(int k, int num) {
    	int half = size / 2;
    	while (k < half) {
        	int child = (k*2) + 1;
        	int c = queue[child];
        	int right = child + 1;
        	if (right < size &&  c > queue[right]){
            	c = queue[right];
            	child = right;
        	}if (num <=  c){
            	break;
        	}
        	queue[k] = c;
        	k = child;
    	}
    	queue[k] = num;
    }
}