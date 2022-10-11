public class Recursive {
    public static void main(String[] args) {
        System.out.println("factorial: ");
        System.out.println(factorial(0));
        System.out.println(factorial(5));
        System.out.println(factorial(12));

        System.out.println("Fibonacci: ");
        System.out.println(fibonacci(0));
        System.out.println(fibonacci(6));
        System.out.println(fibonacci(12));
        System.out.println(fibonacci(30));
        System.out.println(fibonacci(36));

        System.out.println("function Len(n): ");
        System.out.println(len(1));
        System.out.println(len(2));
        System.out.println(len(3));
        System.out.println(len(9));
        System.out.println(len(10));
        System.out.println(len(11));
        System.out.println(len(12));
        System.out.println(len(13));

        System.out.println("GCD recursive");
        System.out.println(gcd(12, 5));
        System.out.println(gcd(120, 36));

    }

    public static int factorial(int n) {
        if (n == 0) return 1;
        return factorial(n - 1) * n;
    }

    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static int len(int n) {
        if (n == 1) return 1;
        return len(n - 1) + String.valueOf(n).length();
    }

    public static int gcd(int a, int b) {
        if (b == 0) return a;

        int temp;
        if (a < b) {
            temp = a;
            a = b;
            b = temp;
        }
        return gcd(b, a % b);
    }
}
