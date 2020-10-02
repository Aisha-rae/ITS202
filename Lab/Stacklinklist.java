public class Stacklinklist{
	
	Node head; 
	int size;
	public Stacklinklist(){
		head = null; 
		size = 0;;	
	}

	public void push(int a){
		Node hello = new Node(a);
		hello.next = head;
		head = hello;
		System.out.println(a);

		size += 1;
	}
	public boolean isEmpty(){
		if(head == null){
			return true;
		}
		else{
			return false;
			
		}
		
	}
	public int size(){
		return size;
	}
	public int top(){
		if (head == null) {
			System.out.println("The stack is empty");
		}
		return head.a;
	}
	public void pop(){
		Node tem = head;
		this.head = this.head.next;
		System.out.println("The pop data is ="+tem.a);

		size -= 1;
	}
	public static void main(String[] args) {
		Stacklinklist k =new Stacklinklist();
  		k.push(10);
  		k.push(20);
  		k.push(30);
  		System.out.println("The stack is empty ="+k.isEmpty());
  		System.out.println("The size is = "+k.size());
  		System.out.println("The top is = "+k.top());
  		k.pop();
  		System.out.println("The size is = "+k.size());

  		assert(k.isEmpty() == false);
    	assert(k.size() == 2);
    	assert(k.top() == 2);

	}
}	
class Node{
	int a;
	Node next;

	public Node(int a){
		this.a = a;
		this.next = null;
	}
}