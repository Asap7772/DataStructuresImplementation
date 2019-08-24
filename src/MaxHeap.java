import java.util.Arrays;

import static java.lang.Math.log;

public class MaxHeap {
	int[] arr;
	int size = 0;

	public MaxHeap(){
		this(15);
	}

	public MaxHeap(int max){
		arr = new int[max];
	}

	public void insert(int num){
		arr[size++] = num;
		bubbleUp(size - 1);
	}

	private void bubbleUp(int i) {
		if(i == 0) return;
		int p = parent(i);
		if(arr[i] > arr[p]) {
			int temp = arr[i];
			arr[i] = arr[p];
			arr[p] = temp;
			bubbleUp(parent(i));
		}
	}

	public int peek() throws Exception {
		if(size == 0) throw new IndexOutOfBoundsException("Empty Heap");
		return arr[0];
	}

	public int removeMax() throws Exception {
		if(size == 1) return arr[--size];

		int temp = peek();
		arr[0] = arr[--size];
		trickleDown(0);
		return temp;
	}

	public void trickleDown(int index){
		if(leftChild(index) >= size) return;
		if(rightChild(index) >= size){
			int c = leftChild(index);
			if(arr[index] < arr[c]) {
				int temp = arr[index];
				arr[index] = arr[c];
				arr[c] = temp;
			}
		}else {
			int c1 = leftChild(index);
			int c2 = rightChild(index);

			if(arr[c1] > arr[c2]){
				if(arr[index] < arr[c1]){
					int temp = arr[index];
					arr[index] = arr[c1];
					arr[c1] = temp;
					trickleDown(c1);
				}
			}else{
				if(arr[index] < arr[c2]){
					int temp = arr[index];
					arr[index] = arr[c2];
					arr[c2] = temp;
					trickleDown(c2);
				}
			}
		}
	}

	private int parent(int i){
		return (i-1)/2;
	}

	private int leftChild(int i){
		return 2 * i + 1;
	}

	private int rightChild(int i){
		return 2 * i + 2;
	}

	@Override
	public String toString() {
		String str = "";
		int prev = 0;
		for(int i = 0; i < size; i++){
			str += arr[i] + " ";
			if(isPower(i+2, 2)) str += "\n";
		}
		return  str + "\n";
	}

	private boolean isPower(int i, int pow) {
		if(i == 0) return true;
		double x = log(i)/log(pow);

		return (x - (int)x == 0.0);
	}

	public static void main(String[] args) throws Exception {
		MaxHeap heap = new MaxHeap();
		heap.insert(100);
		heap.insert(19);
		heap.insert(36);
		heap.insert(17);
		heap.insert(3);
		heap.insert(25);
		heap.insert(1);
		heap.insert(2);
		heap.insert(7);
		System.out.println(heap);

		heap.insert(21);
		System.out.println(heap);
		System.out.println(heap.peek() + "\n");
		heap.removeMax();
		System.out.println(heap);
	}
}
