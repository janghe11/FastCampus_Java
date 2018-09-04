package examples.first;

public class MathTest {
    public static void main(String args[]) {
        // Math는 생성자가 없다. 실제코드에는 private 생성자만 있다.
        // 생성자가 없는 클래스는 static 한 메소드가 있는지 살펴본다.
        // static 한 메소드는 인스턴스를 만들지 않고 클래스명.메소드명()으로 사용할 수 있다.
        int value = Math.abs(-1);
        System.out.println(value);
    }
}
