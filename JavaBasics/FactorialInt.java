import java.util.Scanner;

public class FactorialInt {

    public static void main(String[] args) {
        long result = 1;
        for(int i = 1; ; i++){
            if(Long.MAX_VALUE / result < i + 1){
                System.out.println("The factorial of " + i + " is out of range");
                break;
            }
            result *= i;
            System.out.println("The factorial of " + i + " is " + result);
        }
    }

}
