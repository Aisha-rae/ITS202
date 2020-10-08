public class SelectionSort{
	public static void main(String[] args){
		int array[] = {7,2,4,1,5,3};
		System.out.print("\nThe unsorted array:");
		for (int a = 0; a < array.length; a++){
			System.out.print(" "+ array[a]);
		}
		System.out.print("\nThe sorted array:");
		for (int i = 0; i<=array.length - 1; i++) {
			int swap = i;
			for (int j = i+1; j<array.length; j++){
				if(array[j]<array[swap]){
					swap = j;
				}																																																																																																																																														
			}
			int temp = 	array[i];
			array[i] = array[swap];
			array[swap] = temp;	
			System.out.print(" "+array[i]);
		}
	 }
	
} 