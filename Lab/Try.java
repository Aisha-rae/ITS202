public class Try{
	static int[]array;
	public static void main(String[] args){
		array = new int [3];
		array[0]=1;
		array[1]=2;
		array[2]=3;

		int []newarr= resize(4);
		for(int i=0; i<newarr.length; i++){
			System.out.println(newarr[i]);
		}
	}
	public static int[] resize(int length){
		int [] arr = new int[length];
		for(int i=0; i<array.length; i++ ){
			arr[i] = array[i];
		}
		arr[length -1]=4;
		array = arr;
		return array;
	}
}
