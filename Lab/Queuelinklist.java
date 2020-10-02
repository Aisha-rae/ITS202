class Linkedlist{
	Node front;
	Node tail;
	int size;
	public Linkedlist() {
		front = null;
		tail = null;
		size = 0;
	}
	public boolean isEmpty() {
		if(size == 0) {
			return true;
		}
		return false;
	}
	public void enqueue(int a) {
		Node node = new Node(a, null);
		if(size == 0) {
			front = node;
			tail = node;
			System.out.println("The enqueue data is = " +a);
		}
		else {
			tail.setNext(node);
			tail = node;
			System.out.println("The enqueue data is= " +a);
		}
		size = size + 1;
	}
	public int dequeue() {
		int data = front.getElement();
		if(isEmpty()) {
			return 1;
		}
		else {
			front = front.getNext();
			size -= 1;
			System.out.println("The dequeued data is = " +data);
		}
		return data;
	}
	
	public int first() {
		int firstdata = front.getElement();
		if(size == 0) {
			System.out.println("StackUnderFlowError");
		}
		else {
			return firstdata;
		}
		return first();
	}
	public int len() {
		if(isEmpty()) {
			return 1;
		}
		return size;
	}
}
class Node{
	//Variable declaration
	private int element;
	private Node next;
	public Node(int element, Node next) {
		this.element = element;
		this.next = next;
	}
	//getElement
	public int getElement() {
		return element;
	}
	//getNext
	public Node getNext() {
		return next;
	}
	//setElement
	public void setElement(int e) {
		element = e;
	}
	//setNext
	public void setNext(Node e) {
		next = e;
	}
}
public class Queuelinklist{

	public static void main(String[] args) {
		Linkedlist obj = new Linkedlist();
		obj.enqueue(10);
		obj.enqueue(20);
		obj.enqueue(30);

		System.out.println("The deleted data is = "+obj.dequeue());
		System.out.println("The first data is = " +obj.first());
		System.out.println("" +obj.isEmpty());
		System.out.println("The length of a queue elements is : " + obj.len());

		
		assert(obj.isEmpty() == false);
		assert(obj.first() == 20);
		assert(obj.len() == 2);
		
	}
}
