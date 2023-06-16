import java.util.Stack;

public class controller {
    model model = new model();

    protected double calculator(String equation) {
        double result = resultRPN(reversePolishNotation(equation));
        return result;
    }

    private String reversePolishNotation(String equation) {
        StringBuilder value = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int priority;

        for (int i = 0; i < equation.length(); i++) {
            priority = getP(equation.charAt(i));
            if (priority == -1) {
                value.append(' ');
                while (getP(stack.peek()) != 1) {
                    value.append(stack.pop());
                }
            }
            if (priority == 0) {
                value.append(equation.charAt(i));
            }
            if (priority == 1) {
                stack.push(equation.charAt(i));
            }
            if (priority > 1) {
                value.append(' ');
                while (!stack.empty()) {
                    if (getP(stack.peek()) >= priority) {
                        value.append(stack.pop());
                    } else {
                        break;
                    }
                }
                stack.push(equation.charAt(i));
            }
        }

        while (!stack.empty()) {
            value.append(stack.pop());
        }
        return value.toString();
    }

    private double resultRPN(String RPN) {
        StringBuilder value = new StringBuilder();
        Stack<Double> stack = new Stack<>();

        for (int i = 0; i < RPN.length(); i++) {
            if (RPN.charAt(i) == ' ') {
                continue;
            }
            if (getP(RPN.charAt(i)) == 0) {
                while
                    (RPN.charAt(i) != ' ' && getP(RPN.charAt(i)) == 0) {
                    value.append(RPN.charAt(i++));
                    if (i == RPN.length()) {
                        break;
                    }
                }

                stack.push(Double.parseDouble(String.valueOf(value)));
                value = new StringBuilder();
            }
            if (getP(RPN.charAt(i)) > 1) {
                double a = stack.pop(), b = stack.pop();
                if (RPN.charAt(i) == '+') stack.push(b+a);
                if (RPN.charAt(i) == '-') stack.push(b-a);
                if (RPN.charAt(i) == '*') stack.push(b*a);
                if (RPN.charAt(i) == '/') stack.push(b/a);
                if (RPN.charAt(i) == '^') stack.push(Math.pow (b,a));
                if (RPN.charAt(i) == '%') stack.push(b%a);
            }

        }

        return stack.pop();
    }

    protected int getP(char Token) {
        if (Token == '*' || Token == '/' || Token == '^' || Token == '%')   return 3;
            else if (Token == '+' || Token == '-')                          return 2;
            else if (Token == '(')                                          return 1;
            else if (Token == ')')                                          return -1;
            else                                                            return 0;
    }
}

