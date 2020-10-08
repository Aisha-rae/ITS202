public class BubbleSort{
	public static void Sort(int[] array){
		int n = array.length;

		for (int i = 0; i < n; i++ ) {
			for (int j = 0; j< n-1; j++ ) {
				if (array[j] > array[j+1]) {
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
				
			}
			
		}
	}
	public static void main(String[] args) {
		int[] array = {7,2,4,1,5,3};
		int n = array.length;

		System.out.print("\nThe unsorted array:");
		for (int i = 0; i < n; i++ ) {
			System.out.print(array[i]);
		}	
		Sort(array);	
		System.out.println("");
		System.out.print("\nThe sorted array:");
		for (int i = 0; i < n; i++ ) {
			System.out.print(array[i]);
		}	
		System.out.println("");	
	}
}