import java.util.*;

public class Solution<Key extends Comparable<Key>, Value> {
    private Node root;
    int size;             
    private class Node {
        private Key key;           
        private Value val;         
        private Node left, right;  
        private int size;          

        public Node(Key key, Value val, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }

    /**
     * Initializes an empty symbol table.
     */
    public Solution() {
        root = null;
        size = 0;
    }

    /**
     * Returns true if this symbol table is empty.
     * @return {@code true} if this symbol table is empty; {@code false} otherwise
     */
    public boolean isEmpty() {
        if (size() == 0){
            return true;
        }
        else{
            return false;
        }
       
    }

    /**
     * Returns the number of key-value pairs in this symbol table.
     * @return the number of key-value pairs in this symbol table
     */
    public int size() {
      return size(root);
       
    }

    // return number of key-value pairs in BST rooted at x
    private int size(Node x) {
        if (x == null) return 0;
        return 1 + size(x.left) + size(x.right);
       
     }

    /**
     * Does this symbol table contain the given key?
     *
     * @param  key the key
     * @return {@code true} if this symbol table contains {@code key} and
     *         {@code false} otherwise
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    // public boolean contains(Key key) {
       
    // }

    /**
     * Returns the value associated with the given key.
     *
     * @param  key the key
     * @return the value associated with the given key if the key is in the symbol table
     *         and {@code null} if the key is not in the symbol table
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Value get(Key key) {
        if (key == null){
            throw new IllegalArgumentException("The root is null");
        }
        else{

            return get(root,key);
        }
    }

    private Value get(Node x, Key key) {

        while ( x != null){
           int cmp = key.compareTo(x.key);
            if(cmp < 0){
                x = x.left;
            }
            else if (cmp > 0){
                x = x.right;
            }
            else{
                return x.val;
            } 
        }
        return null;  
    }

    /**
     * Inserts the specified key-value pair into the symbol table, overwriting the old 
     * value with the new value if the symbol table already contains the specified key.
     * Deletes the specified key (and its associated value) from this symbol table
     * if the specified value is {@code null}.
     *
     * @param  key the key
     * @param  val the value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void put(Key key, Value val) {
       if (root == null) {
            root = new Node(key,val,1);
            return;
        }
        Node p = root;
        while(true)
        {
            if (key.compareTo(p.key) < 0 ) {
                if ( p.left == null ) {
                    p.left = new Node(key,val,1);
                    return;
                }
                else
                p = p.left;
            }
            else if ( key.compareTo(p.key) > 0 ) {
                if ( p.right == null ) {
                    p.right = new Node(key,val, 1);
                    
                return;
                }
                else
                    p = p.right;
                }
            else { 
                p.val = val;
                return;

            }   
        }
    
       
    }

    

    /**
     * Returns the smallest key in the symbol table.
     *
     * @return the smallest key in the symbol table
     * @throws NoSuchElementException if the symbol table is empty
     */
    public Key min() {
       return min(root).key;
    } 

    private Node min(Node x) { 
         x = root;
         while(x.left == null){
            return x;
         }
         return x;
    } 

    public Key max(){
        return max(root).key;
    }
    private Node max(Node x){
        x = root;
        while(x.right == null){
            return x;
        }
        return x;
    }

    /**
     * Returns the largest key in the symbol table less than or equal to {@code key}.
     *
     * @param  key the key
     * @return the largest key in the symbol table less than or equal to {@code key}
     * @throws NoSuchElementException if there is no such key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Key floor(Key key) {
        if(key == null){
            throw new IllegalArgumentException ("The node is empty");
        }
       Node x = floor(root, key);
        if(x == null){
            return null;
        }
        else{
            return x.key;
        }
    } 

     private Node floor(Node x, Key key) {
        Node num = null;
        while(x != null){
            int cmp  = key.compareTo(x.key);
            if(cmp == 0) return x;
            if (cmp > 0){
                num = x;
                x = x.right;
            }else{
                x = x.left;
            }
        }
        return num;
     }   

    /**
     * Return the key in the symbol table whose rank is {@code k}.
     * This is the (k+1)st smallest key in the symbol table.
     *
     * @param  k the order statistic
     * @return the key in the symbol table of rank {@code k}
     * @throws IllegalArgumentException unless {@code k} is between 0 and
     *        <em>n</em>–1
     */
    public Key select(int k) {
        if (k<0 || k >= size()){
            throw new IllegalArgumentException("Rank is not within size and 0");
        }
        Node c = select(root, k);
        if(c != null) {
            return c.key;
        }
        return null;
    }
    private Node select(Node x, int k) {
        while(x != null){
            int size = size(x.left);

            if (size > k) x = x.left;
            
            else if(size < k){
                x = x.right;
                k = k - size -1;
            }
            else return x;
        }
        return null;
    } 

    

    /**
     * Returns all keys in the symbol table in the given range,
     * as an {@code Iterable}.
     *
     * @param  lo minimum endpoint
     * @param  hi maximum endpoint
     * @return all keys in the symbol table between {@code lo} 
     *         (inclusive) and {@code hi} (inclusive)
     * @throws IllegalArgumentException if either {@code lo} or {@code hi}
     *         is {@code null}
     */
    public Iterable<Key> keys(Key lo, Key hi){
        if(lo==null || hi==null) throw new IllegalArgumentException("The key is null");

        Queue<Key> b = new LinkedList<Key>();
        keys(root, b, lo, hi); 
        return b;
    }
    private void keys(Node x, Queue<Key> b, Key lo, Key hi){ 
        if (x == null) return;  
        
        Node y = x;  
        
        while (y != null){  
      
            int com = y.key.compareTo(hi);
            int cop = y.key.compareTo(lo);

            if (y.left == null){   
                if (com <= 0 && cop >= 0)  b.offer(y.key);
                y = y.right;

            }else{  
                Node z = y.left;
                while (z.right != null && z.right != y)  
                    z = z.right;  
                if (z.right == null){  
                    z.right = y;  
                    y = y.left; 
                }else{  
                    z.right = null;    
                    if (com <= 0 && cop >= 0)  b.offer(y.key);  
                    y = y.right;  
                }  
            }  
        }   
    }
        
}
  
    
