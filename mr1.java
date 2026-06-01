import java.util.*;
 class H{
    public int add(int n,int g){
        return n-g;
        // System.out.println("This is A class ");
    }
    
}
class Ad extends H{
     public int add(int n,int g)
    {
         return n+g;
    }
}
class obj extends Ad{
    public int add(int n,int g)
    {
         return n*g;
    }
}
public class mr1{
    public static void main(String[] args) {
        Ad obj = new Ad();
        int res = obj.add(10, 20);
        System.out.println(res);
        System.out.println("This is B class ");

         obj = new obj();
        int result = obj.add(10, 20);
        System.out.println(result);
    }
}