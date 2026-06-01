import java.util.Scanner;
class x{
        void ch(int n){
        if(n%2==0){
            System.out.println("Even");
        }else{
            System.out.println("Odd");
        }
    }
}
    public class h8{
        public static void main(String args[]){
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter a number: ");
            int n = sc.nextInt();
            x obj = new x();
            obj.ch(n);
        }
    }