public class Merge {

    // stably merge a[lo .. mid] with a[mid+1 ..hi] using aux[lo .. hi]
    private static void merge(int[] a, int[] aux, int lo, int mid, int hi) {
        // copy to aux[]
        for (int x = lo; x <= hi; x++) {
            aux[x] = a[x]; 
        }

        // merge back to a[]
        int i = lo, j = mid+1;
        for (int x = lo; x <= hi; x++) {
            if(i > mid){
                a[x] = aux[j++];
            }              
            else if(j > hi) {
                a[x] = aux[i++];
            }                
            else if (less(aux[j], aux[i])) {
                a[x] = aux[j++];
            }
            else {
                a[x] = aux[i++];
            }
        }
    }

    // mergesort a[lo..hi] using auxiliary array aux[lo..hi]
    private static void sort(int[] a, int[] aux, int lo, int hi) {
        if (hi <= lo){
            return;
        } 
        int mid = (lo + hi) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);

    }

    /**
     * Rearranges the array in ascending order, using the natural order.
     * @/param a the array to be sorted
     */
    public static void sort(int[] a) {
        int[] aux = new int[a.length];
        int lo = 0;
        int hi = a.length - 1;

        sort(a,aux,lo,hi);
    }


   /***************************************************************************
    *  Helper sorting function.
    ***************************************************************************/
    
    // is v < w ?
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
        
   /***************************************************************************
    *  Check if array is sorted - useful for debugging.
    ***************************************************************************/
    private static boolean isSorted(int[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    private static boolean isSorted(int[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1])) {
                return false;
            }
        return true;
    }

    // print array to standard output
    private static void show(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    /**
     * Reads in a sequence of strings from standard input; mergesorts them; 
     * and prints them to standard output in ascending order. 
     *
     * /@param args the command-line arguments
     */
    public static void main(String[] args) {
        int[] a = {7,1,4,6,3,9,2,5,8};
        Merge.sort(a);
        show(a);
    }
}