package net.thjang.blog;

import java.util.Scanner;

/**
 * 실습 5-6을 숫자가 아닌 문자열로 기둥 이름을 출력하도록 프로그램을 수정하세요.
 * 예를 들어 'A 기둥', 'B 기둥', 'C 기둥'과 같이 출력하면 됩니다.
 */
public class Q6 {
    static void move(int no, int x, int y) {
        String column1 = null;
        String column2 = null;

        if (no > 1)
            move(no - 1, x, 6 - x - y);

        column1 = Character.toString((char)(x + 0x40));
        column2 = Character.toString((char)(y + 0x40));
        System.out.printf("원반[%d]을 %s 기둥에서 %s 기둥으로 옮김", no, column1, column2);
        System.out.println();

        if (no > 1)
            move(no - 1, 6 - x - y, y);
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("하노이의 탑");
        System.out.print("원반 개수 : ");
        int n = stdIn.nextInt();

        move(n, 1, 3);
    }
}
