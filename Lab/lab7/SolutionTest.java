public class SolutionTest{
	public static void main(String[] args) { 
       Solution <Integer, String> k = new Solution<Integer, String>();
       System.out.println(k.isEmpty());
       k.put(3,"Math");
       k.put(2,"Science");
       k.put(7,"English");
       k.put(9,"Dzongkha");
       k.put(1,"Social Studies");
       System.out.println(k.get(7));
       System.out.println(k.min());
       System.out.println(k.floor(5));
       System.out.println(k.select(2));
       

       
    }
}