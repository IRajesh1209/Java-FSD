class a{
    void sum(){
        System.out.println("sum");
    }
}
class b extends a{
    void sub(){
        super.sum();
        System.out.println("sub");
    }
}
public class h3{
    public static void main(String args[]){
        b obj = new b();
        obj.sub();
    }
}
