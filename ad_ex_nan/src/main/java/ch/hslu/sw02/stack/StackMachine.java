package ch.hslu.sw02.stack;

import java.util.Stack;

/**
 * Stackmashine - basic Calculator commands with Stack.
 *
 * @author Nicola Anghileri - nicola.anghileri@stud.hslu.ch
 * @version 04.03.2025
 */
public class StackMachine {

    private final Stack<Integer> stack = new Stack<>();

    public void execute(Command command, Integer value) {
        command.execute(stack, value);
    }

    public void execute(Command command) {
        execute(command, null);
    }

    public static void main(String[] args) {
        StackMachine machine = new StackMachine();

        machine.execute(Command.LOAD, 2);
        machine.execute(Command.LOAD, 3);
        machine.execute(Command.ADD);
        machine.execute(Command.LOAD, 4);
        machine.execute(Command.MUL);
        machine.execute(Command.LOAD, 5);
        machine.execute(Command.SUB);
        machine.execute(Command.PRINT);  // Ausgabe: 20

    }

}
