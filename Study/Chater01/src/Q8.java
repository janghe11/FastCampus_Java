import java.util.Scanner;

public class Q8 {

    public static void main(String[] args){
        Scanner stdInt = new Scanner(System.in);
        System.out.print("1부터 n의 값을 구합니다. n의 값 : ");
        int n = stdInt.nextInt();
        int sum = 0;
        float med = n / 2;

        sum = (int)((1 + n) * med);

        System.out.println("1부터 " + n + "까지의 합: " + sum);
    }
}
