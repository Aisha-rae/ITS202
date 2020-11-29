public class SolutionTest{
	public static void main(String[] args) { 
       Solution <String, Integer> k = new Solution<String, Integer>();
       System.out.println(k.isEmpty());
       k.put("ABDUL",1);
       System.out.println(k.get("ABDUL"));
       k.put("HRITHIK",2);
       k.put("SAI",3);
       k.put("SAMAL",6);
       System.out.println(k.get("SAI"));
       k.put("TASHI",4);
       System.out.println(k.size());
       System.out.println(k.min());
       System.out.println(k.floor("HRITHIK"));
       System.out.println(k.floor("HAHA"));
       System.out.println(k.select(2));
       for (String x : k.keys("ABDUL","TASHI")){
            System.out.print(x+" ");
       }
       System.out.println();
       k.put("CHIMI",5);
       k.put("SAMAL",4);
       System.out.println(k.get("SAMAL"));
       k.put("NIMA",7);
       System.out.println(k.size());
       System.out.println(k.get("CHIMI"));
       System.out.println(k.floor("CHIMA"));
       k.put("SONAM",8);
       for (String x : k.keys("ABDUL","TASHI")){
            System.out.print(x+" ");
       }
       System.out.println();  
    }
} 