import java.util.*;
 class H{
    public void anm(){
        System.out.println("This is H class");
    }
}

class M extends H{
    public void anm(){
        super.anm();
        System.out.println("This is M class");
    }
}

public class mr3{
    public static void main(String[] args) {
        H obj = new H();
        // obj.anm();
        
        M obj1 = new M();
        obj1.anm();
    }
}