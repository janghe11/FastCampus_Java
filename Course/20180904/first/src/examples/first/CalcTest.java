package examples.first;

public class CalcTest {
    public static void main(String args[]){
        Calc cal1 = new Calc(500);

        System.out.println(cal1.getValue());

        cal1.plus(50);

        System.out.println(cal1.getValue());

        cal1.plus(100);

        System.out.println(cal1.getValue());

        cal1.sub(100);

        System.out.println(cal1.getValue());

        cal1.mul(10);

        System.out.println(cal1.getValue());

        cal1.div(0);

        System.out.println(cal1.getValue());

        cal1.div(20);

        System.out.println(cal1.getValue());

        cal1.clear();

        System.out.println(cal1.getValue());
    }
}
