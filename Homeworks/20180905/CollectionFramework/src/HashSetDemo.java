import java.util.HashSet;
import java.util.Set;

public class HashSetDemo {

    public static void main(String args[]) {
        Set<String> hs = new HashSet<String>();

        hs.add("B");
        hs.add("A");
        hs.add("D");
        hs.add("E");
        hs.add("C");
        hs.add("F");

        System.out.println(hs);

    }
}