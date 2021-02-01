package HomeWork10;
public class MathProg {

    public static double x1;
    public static double x2;

    public static void main(String[] args) {
        roots(3,13,-10);
        System.out.println("Первый корень : " + MathProg.x1);
        System.out.println("Второй корень : " + MathProg.x2);
    }

    public static void roots(double a, double b, double c) {
        double d=(b*b)-(4*a*c);
        if(d<0){
            System.out.println("Корней нет");
        }
        if(d==0){
            x1=(-b)/(2*a);
            System.out.println(x1);
            x2=x1;
        }
        else {
            x1 = ((-b) + Math.sqrt((d))) / (2 * a);
            x2 = ((-b) - Math.sqrt((d))) / (2 * a);
        }

    }
}
