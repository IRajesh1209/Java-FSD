public class Cals{
    public int add(int n,int x){
        return n+x;
    }
    public float ad(float n, float x){
        return n+x;
    }
    public float man(float n,float x){
        return n-x;
    }
   // return n*x;
}
public class Mo{
    public static void main(String args[]){
        Cals c = new Cals();
        System.out.println(c.add(10,20));
        System.out.println(c.ad(10.5f,20.5f));
        System.out.println(c.man(10.5f,20.5f));
        //System.out.println(c.add(10,20,30));

    }
}
