import java.util.Scanner;

public class ReverseString {
   
    public static void main(String[] args) {
        ReverseString aReverseString = new ReverseString();
        aReverseString.run();
    }
    
    private void run()
    {
        Scanner sc = new Scanner(System.in);
        
        String str;
        System.out.print("Enter a String: ");
        str = sc.next();
        
        for(int i = str.length()-1; i >= 0; i--) {
            System.out.print(str.charAt(i));
        }
        System.out.println();
        sc.close();
    }
    
}