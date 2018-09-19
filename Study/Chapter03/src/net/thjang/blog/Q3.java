package net.thjang.blog;

import com.sun.javafx.image.IntPixelGetter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q3 {
    static List<Integer> seqSearch(int[] a, int n, int key) {
        List<Integer> idx = new ArrayList<Integer>();
        for (int i = 0; i < n; i++)
            if (a[i] == key){
                idx.add(i);
            }
        return idx;
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
        List <Integer> idx = new ArrayList<Integer>(seqSearch(x, num, ky));
        if (idx == null){
            System.out.println("그 값의 요소가 없습니다.");
        }else {
            System.out.println(ky + "은(는) " + idx.size() + "개가 있습니다.");
        }
    }
}
