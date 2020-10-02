public class Queue{
	int[] array;
	int rear;
	int len;
	int front;
	int first;

	public Queue(int x){
		len = 0;
		rear = -1;
		front = -1;
		first = -1;
		array = new int[x];
	}
	public boolean isEmpty(){
		if (len == 0) {
			return true;	
		}
		return false;

	}

	public int len(){
		if(isEmpty()){
			return 1;
		}
		return len;
	}

	public int first(){
		if (isEmpty()) {
			return 0;	
		}
		else
		{
			return array[front];
		}
	}
	public void enqueue(int x){
		if (isEmpty()) {
			array[0] = x;
			front = 0;
			rear = 0;
			first = array[0];
		}
		else
		{
			array[rear + 1] = x;
			rear = rear + 1;
		}
		len = len + 1;
	}
	public int dequeue(){
		if (isEmpty()) {
			return 0;
		}
		else
		{
			front = front + 1; 
		}
		len = len - 1;
		return array[front-1];
	}


	public static void main(String[] args) {		
        Queue s = new Queue(8);
        s.enqueue(10);
        s.enqueue(20);
        s.enqueue(30);
    
        System.out.println(s.isEmpty());
        System.out.println(s.len());
        System.out.println(s.first());
        System.out.println(s.dequeue());
        System.out.println(s.len());        

		
	}
}
