import java.util.Scanner;

class Stack {
    char arr[];
    int top;

    Stack(int size) {
        arr = new char[size];
        top = -1;
    }

    public void push(char value) {
        if (top == arr.length - 1) {
            System.out.println("Stack Overflow");
        } else {
            arr[++top] = value;
        }
    }

    public char pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
            return 0;
        } else {
            return arr[top--];
        }
    }

    public char peek() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return 0;
        } else {
            return arr[top];
        }
    }

    public boolean isEmpty() {
        return top == -1;
    }
}

public class p10 {

    public static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }

    public static String infixToPostfix(String exp) {
        Stack operator = new Stack(exp.length());
        String postfix = ""; 

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                postfix += ch;
            } else if (ch == '(') {
                operator.push(ch);
            } else if (ch == ')') {
                while (!operator.isEmpty() && operator.peek() != '(') {
                    postfix += operator.pop();
                }
                operator.pop();
                if (operator.isEmpty()) {
                    return "Invalid Expression: Extra closing parenthesis";
                }
            } else if (isOperator(ch)) {
                while (!operator.isEmpty() && precedence(ch) <= precedence(operator.peek())) {
                    postfix += operator.pop();
                }
                operator.push(ch);
            } else {
                return "Invalid Expression: Unknown character";
            }
        }

        while (!operator.isEmpty()) {
            if (operator.peek() == '(') {
                return "Invalid Expression: Missing closing parenthesis";
            }
            postfix += operator.pop();
        }

        return postfix;
    }

    public static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^';
    }

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter your Expression");
        String exp = s.nextLine();
        String postfix = infixToPostfix(exp);

        if (postfix.startsWith("Invalid")) {
            System.out.println(postfix);
        } else {
            System.out.println("Postfix Expression: " + postfix);
        }
    }
}

