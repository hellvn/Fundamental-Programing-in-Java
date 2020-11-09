public class snippet3_12 {
    public static void main(String[] args) {
        int i = 55/22;
        System.out.printf("52/22 = %d %n",i);
        double q = 1.0/2.0;
        System.out.printf("1.0/2.0 = %09.3f %n",q);
        q = 5000.0/3.0;
        System.out.printf("5000/3.0 = %7.2e%n",q);
        q = -10.0/0.0;
        System.out.printf("-10.0/0.0 = %7.2e %n",q);
        System.out.printf("pi = %5.3f, e = %5.4f %n", Math.PI,Math.E);
    }
}
