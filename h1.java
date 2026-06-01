 class a{
    void x(){
        System.out.println("Hellooo!");
    }
 }
class b extends a{
    void y(){
        System.out.println("World!!");
    }
}
class x extends b{
    void m(){
        System.out.println("Ms");
    }
}
public class  h1{
    public static void main(String args[]){
    x xc = new x();
    xc.m();
    }
}
