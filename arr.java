import java.util.Arrays;
public class arr{
    public static void main(String args[]){
        
        int num[] = {1,32,45,67,89,-12,-23-22};
        for(int n : num){
        if(n<0){
            System.out.println(n);
            continue;
        }
        if(n==0){
            System.out.println("Number not found");
            continue;
        }
        }
    }
}