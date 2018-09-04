package examples.first;

/**
 * 간단한 계산기
 */
public class Calc {
    // 필드(속성)를 선언
    private int value;

    // 기본생성자
    public Calc() {
        this.value = 0;
    }

    // 생성자
    public Calc(int value) {
        // 필드 value를 파다미터 value로 초기화한다.
        this.value = value;
    }

    /**
     *  plusVale를 받아서 누적한다.
     * @param plusValue
     */
    public void plus(int plusValue){
        this.value = this.value + plusValue;
    }

    public void sub(int minusValue){
        this.value = this.value - minusValue;
    }

    public void mul(int mulValue){
        this.value = this.value * mulValue;
    }

    public void div(int divValue){
        if (divValue == 0)
            System.out.println("0으로 나눌 수 없습니다.");
        else
            this.value = this.value / divValue;
    }

    public void clear(){
        this.value = 0;
    }

    /**
     * 내부적인 값을 반환한다.
     * @return
     */
    public int getValue(){
        return this.value;
    }

    public static void main(String args[]) {

    }
}
