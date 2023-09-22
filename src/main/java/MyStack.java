import java.util.Stack;

public class MyStack {
    private int[] arr;
    private int top;
    private int size;

    public MyStack(int size) {
        this.size = size;
        this.top = -1;
        this.arr = new int[size];
    }

    public void push(int data) {
        if (!isFull()) {
            arr[++top] = data;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public int pop() {
        if (!isEmpty()) {
            int temp = arr[top];
            arr[top] = 0;
            top--;
            return temp;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public int peek() {
        if (!isEmpty()) {
            return arr[top];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }
}

class CharStack {
    private char[] arr;
    private int top;
    private int size;

    public CharStack(int size) {
        this.size = size;
        this.top = -1;
        this.arr = new char[size];
    }

    public void push(char data) {
        if (!isFull()) {
            arr[++top] = data;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public char pop() {
        if (!isEmpty()) {
            char temp = arr[top];
            arr[top] = 0;
            top--;
            return temp;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public char peek() {
        if (!isEmpty()) {
            return arr[top];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }
}

class StackRunner {

    public static  boolean isPalindrome(String word) {
        CharStack charStack = new CharStack(word.length());
        for (char i:word.toCharArray()) {
            charStack.push(i);
        }
        String reverse = "";
        while (!charStack.isEmpty()) {
            reverse = reverse + charStack.pop();
        }
        System.out.println(reverse);

        return word.equals(reverse);
    }

    public static boolean brackets(String expression) {
        CharStack charStack = new CharStack(expression.length());

        for (char i:expression.toCharArray()) {
            if (i == '(' || i == '[' || i == '{') {
                charStack.push(i);
            } else if (i == ')' || i == ']' || i == '}') {
                if (charStack.isEmpty()) {
                    return false;
                }

                char temp = charStack.pop();

                if (temp == '(' && i != ')') {
                    return false;
                } else if(temp == '[' && i != ']') {
                    return false;
                } else if(temp == '{' && i != '}') {
                    return false;
                }
            }
        }
        return charStack.isEmpty();
    }

    public static String infixToPostfix(String infix) {
        Stack<Character> stack = new Stack<>();
        String postfix = "";

        for (char i:infix.toCharArray()) {
            if (i == '+' || i == '-' || i == '*' || i == '/') {
                if (stack.isEmpty()) {
                    stack.push(i);
                } else if (i == '+'|| i == '-') {
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        postfix = postfix + stack.pop();
                    }
                    stack.push(i);
                } else if (i == '*'|| i == '/') {
                    char temp = stack.peek();
                    while (!stack.isEmpty() && temp != '+' && temp != '-' && temp != '(') {
                        postfix = postfix + stack.pop();
                    }
                    stack.push(i);
                }
            } else if (i == '(') {
                stack.push(i);
            } else if (i == ')') {
                while (stack.peek() != '(') {
                    postfix = postfix + stack.pop();
                }
                stack.pop();
            }
            else {
                postfix = postfix + i;
            }
        }

        while (!stack.isEmpty()) {
            postfix = postfix + stack.pop();
        }
        return postfix;
    }

//    public static String postfixToInfix(String postfix) {
//    }

    public static double evaluateExpression(String postfix) {
        Stack<String> stack = new Stack<>();

        for (char i:postfix.toCharArray()) {
            if (i == '+' || i == '-' || i == '*' || i == '/') {
                double operand2 = Double.parseDouble(stack.pop());
                double operand1 = Double.parseDouble(stack.pop());
                double result = 0;

                if (i == '+') {
                    result = operand1 + operand2;
                } else if (i == '-') {
                    result = operand1 - operand2;
                } else if (i == '*') {
                    result = operand1 * operand2;
                } else if (i == '/') {
                    result = operand1 / operand2;
                }
                stack.push(String.valueOf(result));
                System.out.println(result);
            } else {
                stack.push(String.valueOf(i));
            }
        }
        return Double.parseDouble(stack.pop());
    }



    public static void main(String[] args) {
//        System.out.println(isPalindrome("radar"));
//        System.out.println(brackets("{[(9 + 3)*4]/3)"));
        String exp = "2+5-(2*5+3)/5";
        System.out.println(infixToPostfix(exp));
        System.out.println(evaluateExpression(infixToPostfix(exp)));
    }

}
