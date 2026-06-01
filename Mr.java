import java.util.*;
class A{
    public void H1(){
        System.out.println("Hello1");
    }
    public void H2(){
        System.out.println("Hello2");
    }
}
class B extends A{
    public void H1(){
        System.out.println("Hello3");
    }
}
public class Mr{
public static void main(String arg[]){
    B b=new B();
    b.H1();
    b.H2();
}
}