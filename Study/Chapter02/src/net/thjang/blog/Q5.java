package net.thjang.blog;

import java.util.Scanner;

public class Q5 {
    static void rcopy(int[] a, int[] b) {
        for (int count = 0; count < b.length; count++) {
            a[b.length - count - 1] = b[count];
        }
    }

    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);

        System.out.print("배열 b의 요솟수 : ");
        int nb = stdIn.nextInt();

        int[] b = new int[nb];
        int[] a = new int[b.length];

        for (int i = 0; i < nb; i++) {
            System.out.print("b[" + i + "] : ");
            b[i] = stdIn.nextInt();
        }

        rcopy(a, b);

        System.out.print("배열 b의 요소 : ");
        for (int i = 0; i < b.length; i++) {
            System.out.print("b[" + i + "] : " + b[i]);
        }
        System.out.println("");

        System.out.print("배열 a의 요소 : ");
        for (int i = 0; i < a.length; i++) {
            System.out.print("a[" + i + "] : " + a[i]);
        }
        System.out.println("");
    }
}
