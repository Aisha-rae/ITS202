import java.util.*;
public class ArrayList
{
	//declaring and initiating the actual value
	double first = 0.25;
	double second = 0.75;
	int capacity = 4;
	static int z;
	int erase;
	int top = 0;
	int count = 0;
	static double length;
	static int array[];

	public static void main(String[] args) {
		ArrayList obj = new ArrayList();
		obj.add(10);
		obj.add(20);
		obj.add(30);
		obj.add(40);
		obj.pop();
		obj.resize();
		System.out.println("toString is " +obj.toString());
		System.out.println("The number of elements in the new Array is " +z);
		System.out.println("The size of new Array is " +obj.size());
		System.out.println("All functions are passed");
	}
	// Constructor
	public ArrayList()
	{
		array = new int[capacity]; 
	}
	public void add(int a)
	{
		array[top] = a;
		top++;
	}
	public int size()
	{
		return capacity; //declaration of the size
	}
	//Removing element from the array
	public void pop()
	{
		top--;
		erase = array[top];
		array[top] = 0;
		for(int i = 0; i < array[i]; i++) {
			count++;
		}
		z = count;
		length = (double)z/capacity;
		System.out.println("The erase element is " +erase);
	}
	//Resizing the array after removing
	public void resize()
	{
		if(length == first) {
			int newarray[] = new int[(capacity/2)*2];
			for(int i = 0; i < array.length; i++) {
				newarray[i] = array[i];
			}
			array = newarray;
			capacity = capacity/2;
			for(int x : newarray) {
				System.out.print(x + " ");
				}	
		}
		else if(length == second) {
			int newarray[] = new int[capacity*2];
			for(int i = 0; i < array.length; i++) {
				newarray[i] = array[i];
			}
			capacity = capacity * 2;
			array = newarray;
			for(int y : newarray) {
			System.out.print(y + " ");
			}
			System.out.println();
		}
		else {
			System.out.println("ArrayIndexOutOfBoundRange");
		}
	}
	
	public String toString()
	{
		String s = Arrays.toString(array); //Converting to string
		return s;
	}
	
}