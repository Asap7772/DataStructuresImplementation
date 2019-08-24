public class LinkedList <T> {

	ListNode<T> head;
	int size = 0;

	public void addFirst(T data){
		head = new ListNode<T>(data, head);
		size++;
	}

	public void addLast(T data){
		if(head == null) head = new ListNode<>(data, null);
		else{
			ListNode<T> node = head;
			while (node.next != null){
				node = node.next;
			}
			node.next = new ListNode<T>(data, null);
		}
		size++;
	}

	public void remove(T value){
		ListNode<T> prev = null;
		ListNode<T> node = head;
		while (node != null){
			if(node.data.equals(value)){
				if(prev == null){
					head = head.next;
				}else{
					prev.next = node.next;
				}
				size--;
				return;
			}
			prev = node;
			node = node.next;
		}
	}

	public boolean contains(T data){
		return contains(head, data);
	}

	private boolean contains(ListNode node, T data){
		if(node == null) return false;
		return node.data.equals(data) || contains(node.next, data);
	}


	public void purge(){
		head = null;
		size = 0;
	}

	public int getSize() {
		return size;
	}

	@Override
	public String toString() {
		String str = "Linked List of size " + getSize() + ": [";
		ListNode<T> node = head;

		while (node != null){
			str += node.data + " ";
			node = node.next;
		}

		return str + "]";
	}

	private class ListNode<T>{
		T data;
		ListNode next;

		ListNode(){

		}

		ListNode(T data, ListNode<T> next){
			this.data = data;
			this.next = next;
		}
	}

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		list.addFirst(1);
		list.addFirst(2);
		System.out.println(list);
		list.addLast(3);
		list.addLast(4);
		System.out.println(list);
		list.remove(3);
		System.out.println(list);
		System.out.println();
		System.out.println("Contains 1: " + list.contains(1));
		System.out.println("Contains -54: " + list.contains(-54));
		System.out.println();
		list.purge();
		System.out.println(list);
	}
}