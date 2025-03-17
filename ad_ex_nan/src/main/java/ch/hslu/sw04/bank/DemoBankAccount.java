package ch.hslu.sw04.bank;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Demo class for Bank Account demonstration.
 *
 * @author Nicola Anghileri - nicola.anghileri@stud.hslu.ch
 * @version 17.03.2025
 */
public class DemoBankAccount {

    private static final Logger LOG = LoggerFactory.getLogger(DemoBankAccount.class);

    public static void main(String[] args) {

        // EX: LOG.info(" finished {}", self.getName());
        List<BankAccount> sourceBankAccounts = new ArrayList<>();
        List<BankAccount> targetBankAccounts = new ArrayList<>();

        int number = 20;
        int amount = 1;

        for (int i = 0; i < number; i++) {
            sourceBankAccounts.add(new BankAccount(1000000000));
            targetBankAccounts.add(new BankAccount());
        }

        final Thread[] threads = new Thread[number * 2];
        for (int i = 0; i < number; i++) {
            threads[i] = new Thread(new AccountTask(
                    sourceBankAccounts.get(i), targetBankAccounts.get(i), amount));
            threads[i + number] = new Thread(new AccountTask(
                    targetBankAccounts.get(i), sourceBankAccounts.get(i), amount));
        }

        for (final Thread thread : threads) {
            thread.start();
        }

        // Warten, bis alle Threads beendet sind
        for (final Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                LOG.error("Thread interrupted: " + e.getMessage());
            }
        }

        // Logging finale balances
        LOG.info("Bank accounts after transfers");
        for (int i = 0; i < number; i++) {
            LOG.info("source(" + i + ") = " + sourceBankAccounts.get(i).getBalance()
                    + "; target(" + i + ") = " + targetBankAccounts.get(i).getBalance() + ";");
        }
        LOG.info("----------------------------------------------");
    }
}
