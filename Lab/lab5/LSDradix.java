public class LSDradix{
	public static void radix(String a[], int w){
		int N = a.length;
		int R = 256;
		String[] aux = new String[N];
		for (int d = w-1; d>=0; d--){
			int[] count = new int[R+1];
			for (int i = 0; i < N; i++){
				count[a[i].charAt(d) + 1]++;	
			}
			for (int r = 0; r < R; r++){
			count[r+1] += count[r];
			}
			for (int i = 0; i < N; i++){
			aux[count [a[i].charAt(d)]++] = a[i];
			}
			for (int i = 0; i < N; i++){
				a[i] = aux[i];
			}
		}
		for (int i = 0; i < N; i++){
			System.out.print(a[i]+" ");
		   }
	}
	public static void main(String[] args) {
		LSDradix ob = new LSDradix();
		String a[] = {"yeshi", "sonam", "pelmo","karma","dorji","jigme"};
		ob.radix(a,5); 
	}
}