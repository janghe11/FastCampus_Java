import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static int[] getSevenTalls(int[] talls, int firstNum, int secondNum) {
        int[] sevenTalls = new int[7];

        int inputCount = 0;
        for (int newArrCnt = 0; newArrCnt < talls.length; newArrCnt++) {
            if ((talls[newArrCnt] != talls[firstNum])
                    && (talls[newArrCnt] != talls[secondNum])) {
                sevenTalls[inputCount] = talls[newArrCnt];
                inputCount++;
            }
        }

        return sevenTalls;
    }

    public static void main(String[] args) {
        int allSum = 0;
        int minusedSum = 0;
        int[] talls = new int[9];
        int[] sevenTalls = new int[7];

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < talls.length; i++) {
            talls[i] = scanner.nextInt();
        }

        // 9개에서 2개를 빼는데 2개의 요소가 올 수 있는 조합
        // 8 X 7 = 56
        // 2개 빼고 7개 더한게 100
        // == 다 더해서 2개 뺀게 100
        for (int count = 0; count < talls.length; count++) {
            allSum += talls[count];
        }

        Loop1:
        for (int firstNum = 8; firstNum >= 0; firstNum--) {
            for (int secondNum = 7; secondNum >= 0; secondNum--) {
                minusedSum = allSum - talls[firstNum] - talls[secondNum];

                if (minusedSum == 100) {
                    sevenTalls = getSevenTalls(talls, firstNum, secondNum);
                    break Loop1;
                }
            }
        }

        Arrays.sort(sevenTalls);
        for (int outCnt = 0; outCnt < sevenTalls.length; outCnt++) {
            System.out.print(sevenTalls[outCnt] + " ");
        }
    }
}
