import java.util.*;
public class SequentialSearchST<Key, Value> {
    private Node top;
    private int size;

    public SequentialSearchST() {
        top = null;
        size = 0;
    }
    private class Node{
       private Key key;
       private Value val;
       private Node next;
    
    public Node(Key key, Value val, Node next ){
        this.key = key;
        this.val = val;
        this.next = next;
    }

}

    /**
     * Returns the number of key-value pairs in this symbol table.
     *
     * @return the number of key-value pairs in this symbol table
     */
    public int size() {
        return size;
    }

    /**
     * Returns true if this symbol table is empty.
     *
     * @return {@code true} if this symbol table is empty;
     *         {@code false} otherwise
     */
    public boolean isEmpty() {
        if (size == 0){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Returns true if this symbol table contains the specified key.
     *
     * @param  key the key
     * @return {@code true} if this symbol table contains {@code key};
     *         {@code false} otherwise
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public boolean contains(Key key) {
        if (key == null){
            throw new IllegalArgumentException("The key doesn't exist");
        }
        return get(key) != null;
        
    }

    /**
     * Returns the value associated with the given key in this symbol table.
     *
     * @param  key the key
     * @return the value associated with the given key if the key is in the symbol table
     *     and {@code null} if the key is not in the symbol table
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Value get(Key key) {   
        for (Node x = top; x != null; x = x.next ) {
            if (key.equals(x.key)){
                return x.val;
            }
        }
        return null; 
    }

    // /**
    //  * Inserts the specified key-value pair into the symbol table, overwriting the old 
    //  * value with the new value if the symbol table already contains the specified key.
    //  * Deletes the specified key (and its associated value) from this symbol table
    //  * if the specified value is {@code null}.
    //  *
    //  * @param  key the key
    //  * @param  val the value
    //  * @throws IllegalArgumentException if {@code key} is {@code null}
    //  */
    public void put(Key key, Value val) {
        Node newest = new Node(key,val,null);

        for (Node x = top; x!=null; x=x.next) {
            if(key.equals(x.key)){
                x.val = val;
                return;
            }
        }
        newest.next = top;
        top = newest;
        size ++;
    }

    /**
     * Removes the specified key and its associated value from this symbol table     
     * (if the key is in this symbol table).    
     *
     * @param  key the key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void delete(Key key) {
       
            top = delete(top,key);
        
    }

    // delete key in linked list beginning at Node x
    // warning: function call stack too large if table is large
    private Node delete(Node x, Key key) {
        if (x == null){
            return null;
        }
        if (key == x.key){
            size--;
            return x.next;
        }
        x.next = delete(x.next,key);
        return x;
    }

    /**
     * Returns all keys in the symbol table as an {@code Iterable}.
     * To iterate over all of the keys in the symbol table named {@code st},
     * use the foreach notation: {@code for (Key key : st.keys())}.
     *
     * @return all keys in the symbol table
     */
    public Iterable<Key> keys()  {
       ArrayList<Key> array = new ArrayList<Key>();
       for (Node x = top; x != null; x = x.next){
            array.add(x.key);
       } 
       return array;
    }

    
    /**
         main method
     */
    public static void main(String[] args) {
        SequentialSearchST<String, Integer> ob =new SequentialSearchST<String, Integer>();
        ob.put("k", 5);
        ob.put("c", 2);
        ob.put("r", 7);
        ob.put("d", 9);
        ob.delete("c");

        System.out.println(ob.keys());
        System.out.println(ob.isEmpty());
        System.out.println(ob.size());

    }
}