import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        int sum = 0;
        int numberTemp = 0;
        int bracketPoint = 0;
        boolean isNested = false;
        int max = 0;
        Stack<Character> stack = new Stack<>();

        char openedBracket = 0;
        String brackets = "(()[[]])([])";
        String[] bracketArray = brackets.split("");
        char[] bracketChars = brackets.toCharArray();

        System.out.print("받은 괄호 : ");
        for (int i = 0; i < bracketChars.length; i++)
            System.out.print(bracketChars[i]);
        max = bracketChars.length;

        for (int i = 0; i< bracketChars.length; i++) {
            // 시작 괄호는 stack에 push한다.
            if ((bracketChars[i] == '(') || (bracketChars[i] == '[')) {
                stack.push(bracketChars[i]);

                // 다음 괄호에 괄호로 싸여 있는지 검사
                if ((bracketChars[i + 1] == '(') || (bracketChars[i + 1] == '[')) {
                    bracketPoint++;
                    isNested = true;
                }

            // 끝 괄호는 stack에서 pop 하여 비교한다.
            } else if ((bracketChars[i] == ')') || (bracketChars[i] == ']')) {
                if (!stack.isEmpty()) {
                    openedBracket = stack.pop();
                }
                if ((openedBracket == '(') && (bracketChars[i] == ')')) {
                    numberTemp += 2;
                } else if ((openedBracket == '[') && (bracketChars[i] == ']')) {
                    numberTemp += 3;
                }

                // 괄호가 괄호에 싸여 있는지 검사
                if (i + 1 < max) {
                    if ((bracketChars[i + 1] == ')') || (bracketChars[i + 1] == ']')) {
                        bracketPoint--;

                        if (bracketPoint != 0) {
                            isNested = true;
                        } else {
                            isNested = false;
                        }

                        if (isNested == true) {
                            openedBracket = stack.pop();
                            if ((openedBracket == '(') && (bracketChars[i + 1] == ')')) {
                                numberTemp *= 2;
                            } else if ((openedBracket == '[') && (bracketChars[i + 1] == ']')) {
                                numberTemp *= 3;
                            }
                        }
                    }
                }

            // 괄호 규칙에 해당하지 않으면 0으로 처리한다.
            } else {
//                sum = 0;
//                break;
            }
        }

        sum += numberTemp;

        System.out.println("계산 결과 : " + sum);
    }
}
