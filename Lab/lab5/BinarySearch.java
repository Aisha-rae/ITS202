public class BinarySearch{
public int Search(int []a, int key, int lo,int hi){
	if(hi>=lo){
		int mid = (lo+hi)/2;
	if(key==a[mid]){
		return mid;
	}	
	else if(key<a[mid]){
		return Search(a,key,lo,mid-1);
	}
	else{
		return Search(a,key,mid+1,hi);
	}
 }
  return -1;
}
public void sort(int []a){
   int n=a.length;
	System.out.println("The sorted array: ");
	for(int i=0; i<=n-1;i++){
	int smallest=i;
	for(int j=i+1; j<n; j++){
	if(a[j]<a[smallest]){
	smallest = j;
	}
}
	int temp=a[smallest];
	a[smallest] = a[i];
	a[i]=temp;

	System.out.print(a[i]+" ");
	}
}
public static void main(String[] args) {
	BinarySearch ob = new BinarySearch();
	int a[]={4,1,7,8,2,6,9};
	ob.sort(a);
	int z = ob.Search(a, 4,0,9);
	if(z == -1){
		System.out.println("The number doesn't exist");
	}
		System.out.println("\nThe index of number is "+z);
  }
}