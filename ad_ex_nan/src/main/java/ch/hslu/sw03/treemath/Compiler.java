package ch.hslu.sw03.treemath;

import java.util.ArrayList;
import java.util.List;

import ch.hslu.sw02.stack.Command;

public class Compiler {

    public static List<Command> compile(ExpressionNode node) {
        List<Command> commands = new ArrayList<>();
        compileRec(node, commands);
        return commands;
    }

    // Post-Order-Traversierung
    private static void compileRec(ExpressionNode node, List<Command> commands) {
        if (node instanceof Number) {
            commands.add(Command.LOAD);
        } else if (node instanceof Add) {
            compileRec(((Add) node).getLeft(), commands);
            compileRec(((Add) node).getRight(), commands);
            commands.add(Command.ADD);
        } else if (node instanceof Mul) {
            compileRec(((Mul) node).getLeft(), commands);
            compileRec(((Mul) node).getRight(), commands);
            commands.add(Command.MUL);
        }
    }
}
