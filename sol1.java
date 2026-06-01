public class sol1{
    public static void main(String args[]){
        StringBuilder sb = new StringBuilder("Hellllo");

       StringBuilder A = sb.append("Worlss");
       //A.reverse();

       // StringBuilder S=sb.insert(4,"HELLO");


         //StringBuilder b = sb.delete(1,2);
         //StringBuilder c = sb.replace(0,1,"O");
        // StringBuilder d = sb.reverse();
        // System.out.println(S);
        // System.out.println(a);
        //System.out.println(b);
        // System.out.println(c);
         //System.out.println(d);
         
         sb.deleteCharAt(6);
         String ax=sb.toString();
         System.out.println(ax);
         

         
        

    }
}