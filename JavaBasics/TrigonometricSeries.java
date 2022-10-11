public class TrigonometricSeries {
    public static void main(String[] args) {
        int x = 30;
        System.out.println(sin(x,100000000));
        System.out.println(cos(x, 100));
    }

    public static double sin(double x, int numTerms){
        x = Math.toRadians(x);
        double temp = 1.0;
        double res = 0.0;
        for(int i = 1;  i <= numTerms; i++){
            temp *=(x/i);

            if(i % 4 == 3) res -= temp;
            if(i % 4 == 1) res += temp;
        }
        return res;
    }

    public static double cos(double x, int numTerms){
        x = Math.toRadians(x);
        double temp = 1.0;
        double res = 0.0;
        for(int i = 1;  i <= numTerms; i++) {
            temp *=(x/i);

            if(i % 4 == 2) res -= temp;
            if(i % 4 == 0) res += temp;
        }
        return res;
    }
}
