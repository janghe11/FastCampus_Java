import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// https://www.acmicpc.net/problem/1158
public class Main {
    public static void main(String[] args) {
        int totalNumber;
        int pointNumber;
        List<Integer> list = new ArrayList<>();
        List<Integer> outputList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        totalNumber = scanner.nextInt();
        pointNumber = scanner.nextInt();

        for (int arrayCount = 0; arrayCount < totalNumber; arrayCount++)
            list.add(arrayCount + 1);

        int removeCount = 0;
        int arrayCount = 0;
        while (!(list.isEmpty())) {
            if (arrayCount > (list.size() - 1))
                arrayCount = 0;

            if (removeCount >= (pointNumber - 1)) {
                outputList.add(list.get(arrayCount));
                list.remove(arrayCount);
                removeCount = -1;
                arrayCount--;
            }

            removeCount++;
            arrayCount++;
        }

        for (int output = 0; output < outputList.size(); output++) {
            System.out.println(outputList.get(output));
        }
    }
}
