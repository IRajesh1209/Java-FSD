import java.util.Scanner;
public class h11{
    public static void main(String args[]){

        System.out.println("Enter the two numbers :");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        System.out.println("Enter the operation (1-4):");
        int operation = scanner.nextInt();
        int sum = 0;
        switch(operation){
            case 1:
                System.out.println("Addition");
                int k = m + n;
                System.out.println(k);
                break;
            case 2:
                System.out.println("Subtraction");
                int l = m - n;
                System.out.println(l);
                break;
            case 3:
                System.out.println("Mul");
                int p = m*n;
                System.out.println(p);
                break;
            case 4:
                System.out.println("Div");
                int q = m/n;
                System.out.println(q);
                break;
            default:
                System.out.println("Invalid operation");
                break;
        }

    }



}