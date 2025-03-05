package ch.hslu.sw02.stack;

import java.util.Stack;

/**
 * ENUMERATOR describing all commands needed in the StackMashine.
 *
 * @author Nicola Anghileri - nicola.anghileri@stud.hslu.ch
 * @version 04.03.2025
 */
public enum Command {
    LOAD {
        @Override
        void execute(Stack<Integer> stack, Integer value) {
            if (value != null) {
                stack.push(value);
            } else {
                throw new IllegalArgumentException("LOAD needs an argument!");
            }
        }
    },
    ADD {
        @Override
        void execute(Stack<Integer> stack, Integer value) {
            if (stack.size() >= 2) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(a + b);
            } else {
                throw new IllegalStateException("ADD need min 2 values in Stack");
            }
        }
    },
    MUL {
        @Override
        void execute(Stack<Integer> stack, Integer value) {
            if (stack.size() >= 2) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(a * b);
            } else {
                throw new IllegalStateException("MUL needs min 2 values in Stack");
            }
        }
    },
    PRINT {
        @Override
        void execute(Stack<Integer> stack, Integer value) {
            if (!stack.isEmpty()) {
                System.out.println(stack.pop());
            } else {
                throw new IllegalStateException("Stack is empty");
            }
        }
    },
    SUB {
        @Override
        void execute(Stack<Integer> stack, Integer value) {
            if (stack.size() >= 2) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(a - b);
            } else {
                throw new IllegalStateException("SUB needs min 2 values in Stack");
            }
        }
    },
    DIV {
        @Override
        void execute(Stack<Integer> stack, Integer value) {
            if (stack.size() >= 2){
                int a = stack.pop();
                int b = stack.pop();
                if(b > 0){
                    stack.push((int)(a / b));
                }else{
                    stack.push(b);
                    stack.push(a);
                    throw new ArithmeticException("Cannot divide by zero - elements were reloaded");
                }
            }
        }
        
    };

    abstract void execute(Stack<Integer> stack, Integer value);
}
