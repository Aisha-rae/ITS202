public class InsertionSort {  

    public static void insertion(int array[]) {  
        int n = array.length;  

        for (int i = 0; i < n-1; i++) {  

            for (int j = i + 1; j>0 && Compare(j-1, j, array) ;j-- ) {
                int temp = array[j-1];
                array[j-1] = array[j];
                array[j] = temp;
            }
                
            }
        } 
        public static boolean Compare(int i, int j, int[] array){
            if (array[i] > array[j]) {
                return true;  
            }
            return false;   
        }  
       
    public static void main(String[] args) {    
        int[] arr = {7,2,4,1,5,3};   
        InsertionSort obj = new InsertionSort();
        System.out.print("\nThe unsorted array:");   
        for(int i = 0; i < arr.length; i++){    
            System.out.print(arr[i]);    
        }    
        System.out.println("");
        obj.insertion(arr);

        System.out.print("\nThe sorted array:");
          for(int i = 0; i < arr.length; i++){    
            System.out.print(arr[i]);    
        }   
    }
}

