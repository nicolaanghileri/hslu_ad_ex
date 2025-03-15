package ch.hslu.sw03.treemath;

/**
 * Class for Testing the other Classes.
 * @author Nicola Anghileri - nicola.anghileri@stud.hslu.ch
 * @version 10.03.2025 
 */
public class Main {

    public static void main(String[] args) {
        
        ExpressionNode n = new Mul(
                new Add(
                        new Number(4),
                        new Mul(
                                new Number(5),
                                new Number(2)
                        )
                ),
                new Add(
                        new Number(3),
                        new Number(6)
                )
        );

        System.out.println(n);
        System.out.println(n.getValue());   

        /* 
        ExpressionNode expression = new Mul(
            new Add(new Number(2), new Number(3)),
            new Number(4)
        );

        // Kompilieren des Ausdrucks in eine Liste von Befehlen
        List<Command> commands = Compiler.compile(expression);

        // StackMachine erstellen und Befehle ausführen
        StackMachine machine = new StackMachine();
        for (Command command : commands) {
            if (command == Command.LOAD) {
                // Sonderfall: Für LOAD brauchen wir einen Wert
                machine.execute(command, expression.getValue());
            } else {
                machine.execute(command);
            }
        }

        // Endergebnis ausgeben
        machine.execute(Command.PRINT);  // Erwartet: 20*/
    }
}
