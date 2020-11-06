public class keyindex{
	void index(int a[]){
		int R = 10;
		int N = a.length;
		int[] aux = new int[N];
 		int[] count = new int[R+1];
 
 		for (int i = 0; i < N; i++){
 			count[a[i] + 1]++;	
 		}
 		for (int r = 0; r < R; r++){
 			count[r+1] += count[r];
 		}
 		
 		for (int i = 0; i < N; i++){
 			aux[count[a[i]]++] = a[i];
 		}
 		
 		for (int i = 0; i < N; i++){
 			a[i] = aux[i];
 		}
		for (int i = 0; i < N; i++){
			System.out.print(a[i]+" ");
		}
	}
	public static void main(String[] args) {
		keyindex ob = new keyindex();
		int a[] = {1,2,1,9,0,0,4,1};
		ob.index(a); 
		
	}
}