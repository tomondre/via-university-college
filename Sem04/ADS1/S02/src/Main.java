public class Main {
    public static void main(String[] args) {
        String expression = "(w * [x + y] /) z)";

        char[] chars = expression.toCharArray();
        boolean b = hasBalanceParenthesesAscii(chars);
        System.out.println(b);
    }

    public static boolean hasBalanceParentheses(char[] arr) {
        StackADT<Character> stack = new StackImpl<Character>();

        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];

            Character pop;
            switch (c) {
                case '(':
                case '{':
                case '[':
                    stack.push(c);
                    break;
                case ')':
                    try {
                        pop = stack.pop();
                    } catch (Exception e) {
                        return false;
                    }
                    if (pop != '(') {
                        return false;
                    }
                    break;
                case '}':
                    try {
                        pop = stack.pop();
                    } catch (Exception e) {
                        return false;
                    }
                    if (pop != '{') {
                        return false;
                    }
                    break;
                case ']':
                    try {
                        pop = stack.pop();
                    } catch (Exception e) {
                        return false;
                    }
                    if (pop != '[') {
                        return false;
                    }
                    break;
            }
        }

        return true;
    }


    public static boolean hasBalanceParenthesesAscii(char[] arr) {
        StackADT<Character> stack = new StackImpl<Character>();

        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            Character pop;

            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                try {
                    pop = stack.pop();
                } catch (Exception e) {
                    return false;
                }
                int popAscii = pop;
                int currAscii = c;
                if (currAscii == 41 && currAscii - 1 != popAscii) {
                    return false;
                } else if ((currAscii == 93 || currAscii == 125) && currAscii - 2 != popAscii) {
                    return false;
                }
            }
        }
        return true;
    }
}
