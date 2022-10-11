import java.util.Scanner;

public class SpecialSeries {
    public static void main(String[] args) {
        series();
    }
    public static double specialSeries(double x, int numTerms) {
        if (numTerms == 0)
            return 0;
        if (numTerms == 1)
            return x;
        double result = x;
        double temp = x;
        for (int i = 3; i <= 2 * numTerms - 1; i += 2) {
            temp *= ((i - 2) * (x * x)) / (i - 1);
            result += temp / i;
        }
        return result;
    }
    public static void series(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter x: ");
        double x = sc.nextDouble();
        System.out.print("Enter number of terms: ");
        int numTerms = sc.nextInt();
        System.out.println(specialSeries(x,numTerms));
    }
}
