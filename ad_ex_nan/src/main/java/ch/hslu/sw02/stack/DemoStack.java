package ch.hslu.sw02.stack;

public class DemoStack {

    public static void main(String[] args) {
        Stack<String> stack = new ArrayStack<>(3);

        stack.push("toll");
        stack.push("sind");
        stack.push("Datenstrukturen");

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
