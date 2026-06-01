public class h111 {
    public static void main(String[] args) {
        System.out.println("Abstract class H");
    }
    abstract class A {
     
     abstract void display();
     
    }

    abstract class B extends A {
        void display() {
            System.out.println("Abstract class H");
        }
    }
}