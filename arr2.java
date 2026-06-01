import java.util.Scanner;
import java.util.Arrays;
    public class arr2{
        public static void main(String args[]){
            Scanner sc = new Scanner(System.in);
            System.out.println("enter Size: ");
            int size = sc.nextInt();
            int arr[] = new int[size];
            
            // input Elements
            System.out.println("Enter Elements are: ");
            for(int i=0;i<size;i++){
                arr[i] = sc.nextInt();
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            Arrays.sort(arr);
            int len = arr.length;
            System.out.println("Sorted Array: " + Arrays.toString(arr));
            System.out.println("Length: " + len);


        }
    }
