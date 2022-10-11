package NumberTheory;

public class GreatestCommonDivisor {
    public static void main(String[] args) {
        System.out.println("gcd(12605,500) = " + gcd(12605,500));
        System.out.println("gcd(5376,4532) = " + gcd(5376,4532));
        System.out.println("gcd(4318,8622) = " + gcd(4318,8622));

        System.out.println("gcd(99,88) = " + gcdRecursive(99,88));
        System.out.println("gcd(9124,676) = " + gcdRecursive(9124,676));
    }
    public static int gcd(int a, int b){
        int temp;
        if( a < b){
            temp = a;
            a = b;
            b = temp;
        }
        while( b != 0){
            temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }
    public static int gcdRecursive(int a, int b) {
        if (b == 0) return a;

        int temp;
        if (a < b) {
            temp = a;
            a = b;
            b = temp;
        }
        return gcdRecursive(b, a % b);
    }
}
