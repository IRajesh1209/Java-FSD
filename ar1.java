import java.util.Arrays;
import java.util.Scanner;
public class ar1{
    public static void main (String args[]){
        Scanner in = new Scanner(System.in);
     
        int []arr=new int[5];
        arr[0]=12;
        arr[1]=111;
        arr[2]=1222;
        arr[3]=1322;

        System.out.println(arr[2]);

         for(int i=0;i<5;i++){
             arr[i]=in.nextInt();
        }
          System.out.print(Arrays.toString(arr));
         // System.out.print(Arrays.sort(arr));
          
        //  for(int i=0;i<5;i++){
        //     System.out.print(arr[i] + " ");
        // }
        // for(int n:arr){
        //     System.out.print(n+" ");
        // }


    }
    
}
