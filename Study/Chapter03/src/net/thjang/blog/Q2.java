package net.thjang.blog;

import java.util.Scanner;

public class Q2 {
    static int seqSearch(int[] a, int n, int key) {

        for (int i = 0; i < n; i++){
            System.out.print("  | ");
            for (int starCount = 1; starCount <= i; starCount++){
                if (starCount < i)
                    System.out.print(" ");
                else
                    System.out.print("*");
            }
            System.out.println("");
            System.out.print(i + "| ");
            for (int arrayCount = 0; arrayCount < n; arrayCount++)
                System.out.print(a[arrayCount]);
            System.out.println("");
            System.out.println("|");

            if (a[i] == key)
                return i;
        }
        return -1;
    }

    public static void printTable(int num){
        System.out.print("  | ");
        for (int tColumn = 0; tColumn < num; tColumn++) {
            System.out.print(tColumn + " ");
        }
        System.out.println("");
        System.out.println("--+----------------");
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟수 : ");
        int num = stdIn.nextInt();
        int[] x = new int[num];

        for (int i = 0; i < num; i++){
            System.out.print("x[" + i + "] : ");
            x[i] = stdIn.nextInt();
        }

        System.out.print("검색할 값 : ");
        int ky = stdIn.nextInt();
        printTable(num);
        int idx = seqSearch(x, num, ky);
        if (idx == -1){
            System.out.println("그 값의 요소가 없습니다.");
        }else {
            System.out.println(ky + "은(는) x[" + idx + "]에 있습니다.");
        }
    }
}

