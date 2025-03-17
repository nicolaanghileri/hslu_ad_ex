package ch.hslu.sw04.bank;

/**
 * Simple Bank Account with a balance.
 *
 * @author Nicola Anghileri - nicola.anghileri@stud.hslu.ch
 * @version 17.03.2025
 */
public class BankAccount {

    private int balance;

    /**
     * Instances Bank Account with a starting balance.
     *
     * @param balance starting balance.
     */
    public BankAccount(final int balance) {
        this.balance = balance;
    }

    /**
     * Default Constructor for Bank Account, balance = zero.
     */
    public BankAccount() {
        this(0);
    }

    /**
     * Getter for current balance.
     *
     * @return balance.
     */
    public int getBalance() {
        return this.balance;
    }

    /**
     * Effects a deposit on the Bank Account, increments the balance.
     *
     * @param amount the added number.
     */
    public void deposite(final int amount) {
        synchronized (this) {
            this.balance += amount;
        }
    }

    /**
     * Effects a transaction to a target Bank Account. With a selected amount.
     *
     * @param target the Bank Account receiving the money.
     * @param amount the amount beeing transfered.
     */
    public void transfer(final BankAccount target, final int amount) {
        synchronized (this) {
            this.balance -= amount;
            target.deposite(amount);
        }
    }
}
