public class h121{
    public static void main(String[] args) {
        String name = new String("Rajesh");
        //System.out.println(name);
        if (name.length() > 8) {
            System.out.println(name.charAt(7));
        } else {
            System.out.println("Index out of bounds");
        }
        
    }
}
