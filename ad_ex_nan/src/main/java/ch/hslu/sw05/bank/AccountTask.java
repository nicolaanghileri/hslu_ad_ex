package ch.hslu.sw05.bank;

/**
 * Task for Thread - Exection of bank transfer.
 *
 * @author Nicola Anghileri - nicola.anghileri@stud.hslu.ch
 * @version 17.03.2025
 */
public class AccountTask implements Runnable{

    private final BankAccount source;

    private final BankAccount target;

    private final int amount;
    
    public AccountTask(BankAccount source, BankAccount target, int amount){
        this.source = source;
        this.target = target;
        this.amount = amount;
    }

    @Override
    public void run() {
        this.source.transfer(this.target, this.amount);    
    }
    
}
