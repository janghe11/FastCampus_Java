import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int n = 0;
        System.out.print("0부터 16까지의 숫자를 입력하십시요 : ");
        for ( ; ;) {
            n = stdIn.nextInt();
            if (n > 17)
                System.out.print("0부터 16까지의 수로 다시 입력하십시요. : ");
            else
                break;
        }
        int arr1[] = new int[n];
        int arr2[] = new int[n];
        int combined[] = new int[n];
        String outArr[] = new String[n];

        for (int column = 0; column < n; column++){
            System.out.print("지도 1의 [" + column + "]번 숫자 입력 : ");
            arr1[column] = Integer.parseInt(Integer.toBinaryString(stdIn.nextInt()));
        }

        for (int column = 0; column < n; column++){
            System.out.print("지도 2의 [" + column + "]번 숫자 입력 : ");
            arr2[column] = Integer.parseInt(Integer.toBinaryString(stdIn.nextInt()));
        }

        for (int column = 0; column < n; column++) {
            // 2진수가 아니어도 10진수로 바로 2bit 연산(bitwise) 가능
           combined[column]  = arr1[column]|arr2[column];
        }

        for (int column = 0; column < n; column++) {
            outArr[column] = String.valueOf(combined[column]);
            for (int count = 0; count < outArr[column].length(); count++){

            }
        }
    }
}
