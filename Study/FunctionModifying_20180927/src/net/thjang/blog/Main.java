package net.thjang.blog;

import java.util.Scanner;

public class Main {
    public void solution() {

    }

    public static void main(String[] args){
        int progresses[] = new int[100];
        int speeds[] = new int[100];
        int temp = 0;
        int cursor = 0;
        int cursor2 = 1;
        int max = 0;
        int speedCount = 1;
        int deployNum = 0;
        int deploySum[] = new int[100];
        int deployDate[] = new int[100];

        // 입력
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("그만 입력하고 싶으면 -1 입력");
            System.out.print((cursor + 1) + "번째 작업 진도 입력(0~99) : ");
            temp = scanner.nextInt();
            if (temp == -1) {
                max = cursor;
                break;
            }

            if (temp > 99)
                System.out.println("잘못 입력 하셨습니다. 0 ~ 99 숫자를 입력");
            else {
                progresses[cursor] = temp;
                temp = 0;

                System.out.print(cursor + "번째 작업 속도 입력 : ");
                temp = scanner.nextInt();
                if (temp > 100)
                    System.out.println("잘못 입력 하셨습니다. 0 ~ 99 숫자를 입력");
                else {
                    speeds[cursor] = temp;
                    cursor++;
                }
            }
        }
        cursor = 0;

        // 배포일 계산
        while (true){
            deploySum[cursor] = progresses[cursor] + speedCount*speeds[cursor];

            if (cursor == max)
                break;

            if (deploySum[cursor] > 100){
                deployDate[cursor] = speedCount;
                speedCount = 1;
                cursor++;
            } else
                speedCount++;
        }
        cursor = 0;

        // 배포 일자 계산
        while (true) {
            if (cursor2 > max)
                break;

            if (deployDate[cursor] < deployDate[cursor2]){
                deployNum++;
                cursor2++;

            } else if (deployDate[cursor] == deployDate[cursor2]) {
                deployNum++;
                System.out.println(deployDate[cursor2] + "일째에 "
                        + deployNum + "개의 기능이 배포됩니다.");
                deployNum = 1;
                cursor = cursor2 + 1;
                cursor2++;
            } else {
                System.out.println(deployDate[cursor2] + "일째에 "
                        + deployNum + "개의 기능이 배포됩니다.");
                deployNum = 1;
                cursor = cursor2 + 1;
                cursor2++;
            }
        }
    }
}
