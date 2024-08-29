import java.util.Scanner;

class p11 {

    static int top = -1;
    static int[] stack;

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter your postfix expression:");
        String exp = s.nextLine();
        stack = new int[exp.length()]; 

        try {
            System.out.println("Postfix evaluation: " + evalPostfix(exp));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static int evalPostfix(String expression) {
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (Character.isDigit(ch)) {
                int value = 0; 
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) { 
                    value = value * 10 + (expression.charAt(i) - '0');
                    i++;
                }
                i--;
                stack[++top] = value;
            } else if (ch == ' ') {
                continue;
            } else {
                int value2 = stack[top--];
                int value1 = stack[top--];
                switch (ch) {
                    case '^':  
                           stack[++top]=(int) Math.pow(value1,value2);
                           break;
                    case '+':
                        stack[++top] = value1 + value2;
                        break;
                    case '-':
                        stack[++top] = value1 - value2;
                        break;
                    case '*':
                        stack[++top] = value1 * value2;
                        break;
                    case '/':
                        if (value2 == 0) {
                            throw new ArithmeticException("Division by zero");
                        }
                        stack[++top] = value1 / value2;
                        break;
                    default:
                        throw new RuntimeException("Invalid operator: " + ch);
                }
            }
        }
        return stack[top];
    }
}

