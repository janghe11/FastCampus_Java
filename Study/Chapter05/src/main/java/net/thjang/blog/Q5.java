package net.thjang.blog;

import java.util.Scanner;

/**
 * recur3 메서드를 비재귀적으로 구현하세요.
 * 이 문제는 하노이의 탑 문제가 아니라 5-2절의 문제입니다.
 *
 * static void recur3(int n) {
 *     if(n > 0) {
 *         recur3(n - 1);
 *         recur3(n - 2);
 *         System.out.println(n);
 *     }
 * }
 */
public class Q5 {

    static void recur3(int n) {
        int[] nstk = new int[100];
        int[] sstk = new int[100];
        int ptr = -1;
        int sw = 0;

        while (true) {
            if (n > 0) {
                ptr++;
                nstk[ptr] = n;
                sstk[ptr] = sw;

                if (sw == 0)
                    n = n - 1;
                else if (sw == 1) {
                    n = n - 2;
                    sw = 0;
                }
                continue;
            }
            do {
                n = nstk[ptr];
                sw = sstk[ptr--] + 1;

                if (sw == 2) {
                    System.out.println(n);
                    if (ptr < 0)
                        return;
                }
            } while (sw == 2);
        }
    }
//    static void recur3(int n) {
//        IntStack intStack = new IntStack(n);
//
//        while (true) {
//            if(n > 0) {
//                intStack.push(n);
//                n = n - 1;
//                continue;
//            }
//            if(intStack.isEmpty() != true) {
//                intStack.pop();
//                n = n - 2;
//                System.out.println(n);
//                continue;
//            }
//        }
// }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("정수를 입력하세요. : ");
        int x = stdIn.nextInt();

        recur3(x);
    }
}
