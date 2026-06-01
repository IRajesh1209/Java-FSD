import java.util.Scanner;
import java.util.Arrays;

public class h1s {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size:");
        int size = sc.nextInt();
        int arr[] = new int[size];

        // Taking input
        System.out.println("Enter elements:");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        int x = sc.nextInt();

        for(int i=0;i<arr.length;i++){
            if(arr[i] == x){
                System.out.println("Element found at index: " + i);
            }
        }
    }
}