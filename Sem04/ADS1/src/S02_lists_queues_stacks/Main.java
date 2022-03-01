package S02_lists_queues_stacks;

public class Main {
    public static void main(String[] args) {

        String expression = "(w * [x + y] / z)";

        char[] chars = expression.toCharArray();
        boolean b = hasBalanceParentheses(chars);
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
}
