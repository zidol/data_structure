package Stack;

import java.util.ArrayList;

public class Stack<T> {

    ArrayList<T> stack = new ArrayList<>();

    public T push(T item) {
        stack.add(item);
        return item;
    }

    public T pop() {
        if (stack.isEmpty()) {
            return null;
        } else {
            return stack.remove(stack.size() - 1);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
