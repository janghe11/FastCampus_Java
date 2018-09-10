public class Q3 {

    static int min4(int a, int b, int c, int d){
        int min = a;
        if (a < min)
            min = a;
        if (b < min)
            min = b;
        if (c < min)
            min = c;
        if (d < min)
            min = d;

        return min;
    }

    public static void main(String[] args){
        System.out.println("min4(3,2,1,0) = " + min4(3, 2, 1, 0));
        System.out.println("min4(3,2,2,4) = " + min4(3, 2, 2, 4));
    }
}
