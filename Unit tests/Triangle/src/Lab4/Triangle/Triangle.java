package Lab4.Triangle;

public class Triangle {
    public static void Triangle(String[] args) {
        System.out.println(isAvaliable(1,1,1));
    }
    public static boolean isAvaliable(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return false;
        }
        return a + b > c && a + c > b && b + c > a;
    }
}
