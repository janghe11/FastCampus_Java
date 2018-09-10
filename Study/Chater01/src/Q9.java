import java.util.Scanner;

public class Q9 {
    static int sumof(int a, int b){
        int sum = 0;

        for (int count = a; count <= b; count++){
            sum += count;
        }

        return sum;
    }

    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);
        System.out.println("첫 번째 정수 입력: ");
        int a = stdIn.nextInt();
        System.out.println("두 번째 정수 입력: ");
        int b = stdIn.nextInt();

        int result = sumof(a, b);

        System.out.println("두 숫자 사이의 합: " + result);
    }
}
