import java.util.ArrayList;
import java.util.List;

public class ArrayListToArray {

    public static void main(String agrs[]) {
        List<Integer> al = new ArrayList<Integer>();

        al.add(new Integer(1));
        al.add(new Integer(2));
        al.add(new Integer(3));
        al.add(new Integer(4));
        System.out.println("Contents of al: " + al);

        Object ia[] = al.toArray();
        int sum = 0;

        for (int i = 0; i < ia.length; i++){
            sum += ((Integer) ia[i]).intValue();
        }

        System.out.println("Sum is: " + sum);
    }
}
