public class LinearSearch{
	public static void Search(int a[]){
		int N = a.length;
		int key = 9;
		for (int i=0;i<N;i++) {
			if(a[i] == key){
				System.out.print("The index of the key is "+i);
				return;
			}
		}
		System.out.println("The number doesn't exist");
	}
	public static void main(String[] args) {
		LinearSearch ob = new LinearSearch();
		int a[] = {4,9,3,1,0,8};
		ob.Search(a);

	}
}