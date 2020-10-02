public class stack{
	int max;
	int array [];
	int top;
	int size;
	public stack(){
		max = 5;
		array = new int[max];
		top = 0;
		size = 0; 
	} 
	public boolean isEmpty(){
        if (size == 0){
            return true;  
        }
        else{
            return false;
        }
    }
    public int size() {
    	return size;
    }
    public int top(){
    	if (isEmpty()) {
    		return 0;
    	}
        else{
            return top;
        }
    }
    public void push(int i) 
    {
     if(top>max){
        System.out.println("Overflow");
     }
      else{
       array[++top] = i;
       System.out.println("Push " + i);
    }
    size = size +1;
}
    public int pop( ){
       if(top>max) {
           System.out.println("Underflow");
        }
        else{
            top =top-1; 
        }
        size = size -1;
        return array[top+1];
}
    public static void main(String[] args){
        stack s1=new stack();
        s1.push(10);
        s1.push(20);
        s1.push(30);
        System.out.println("Size " + s1.size());
        System.out.println("Pop " + s1.pop());
        System.out.println("Size " + s1.size());
    }
}

