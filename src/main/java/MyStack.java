public class MyStack {

    private int[] arr;
    private int top;
    public int size;

    public MyStack(int size) {
        this.size = size;
        this.top = -1;
        this.arr = new int[size];
    }

    public void push(int item) {
        if (!isFull()) {
            top++;
            arr[top] = item;
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
        return top == size -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }
}

class CharStack {

    private char[] arr;
    private int top;
    public int size;

    public CharStack(int size) {
        this.size = size;
        this.top = -1;
        this.arr = new char[size];
    }

    public void push(char item) {
        if (!isFull()) {
            top++;
            arr[top] = item;
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

   public int peek() {
        if (!isEmpty()) {
            return arr[top];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }


    public boolean isFull() {
        return top == size -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }
}


class StackRun {

    public boolean isPalindrome(String word) {

        CharStack charStack = new CharStack(word.length());
        String reverseWord = "";
        for (char i : word.toCharArray()) {
            charStack.push(i);
        }

        while (!charStack.isEmpty()) {
            reverseWord = reverseWord + charStack.pop();
        }
        return word.equals((reverseWord));
    }

    public boolean brackets(String expression) {

        CharStack bracketStack = new CharStack(expression.length());

       for (char i : expression.toCharArray()) {
           if (i == '(' || i == '[' || i == '{') {
               bracketStack.push(i);
           } else if (i == ')' || i == ']' || i == '}') {
               if (bracketStack.isEmpty()) {
                   return false;
               } else {

                   char temp = bracketStack.pop();

                   if (i == ')' && temp != '(') {
                       return false;
                   } else if (i == ']' && temp != '[') {
                       return false;
                   } else if (i == '}' && temp != '{') {
                       return false;
                   }
               }
           }
       }

       if (bracketStack.isEmpty()) {
           return true;
       } else {
           return false;
       }

    }

















    public static void main(String[] args) {


        MyStack stack = new MyStack(10);

        stack.push(4);
        stack.push(15);
        stack.push(22);
        stack.push(56);
        stack.push(89);

        System.out.println(stack.peek());

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());



    }


}













