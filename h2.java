interface kec{
    void cse();
    void ece();
    void mech();
}
final class Kuppam implements kec{
    public void cse(){
        System.out.println("CSE!!");
    }
    public void ece(){
        System.out.println("ECE!!");
    }
    public void mech(){
        System.out.println("MECH!!");
    }
}
public class h2{
    public static void main(String args[]){
        Kuppam kk =new Kuppam();
        kk.cse();
        kk.ece();
        kk.mech();
    }
}