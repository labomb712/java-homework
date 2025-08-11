package mylab.bank.entity;

import java.util.ArrayList;
import java.util.List;
import mylab.bank.exception.AccountNotFoundException;
import mylab.bank.exception.InsufficientBalanceException;

public class Bank {
    private List<Account> accounts;
    private int nextAccountNumber;

    public Bank() {
        this.accounts = new ArrayList<>();
        this.nextAccountNumber = 1000;
    }

    public Account createSavingsAccount(String ownerName, double balance, double interestRate) {
        Account newAccount = new SavingsAccount(nextAccountNumber++, ownerName, balance, interestRate);
        accounts.add(newAccount);
        return newAccount;
    }

    public Account createCheckingAccount(String ownerName, double balance, double withdrawalLimit) {
        Account newAccount = new CheckingAccount(nextAccountNumber++, ownerName, balance, withdrawalLimit);
        accounts.add(newAccount);
        return newAccount;
    }

    public Account findAccount(int accountNumber) throws AccountNotFoundException {
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        throw new AccountNotFoundException("���¸� ã�� �� �����ϴ�: " + accountNumber);
    }

    public void deposit(int accountNumber, double amount) throws AccountNotFoundException {
        Account account = findAccount(accountNumber);
        account.deposit(amount);
    }

    public void withdraw(int accountNumber, double amount) throws Exception {
        Account account = findAccount(accountNumber);
        account.withdraw(amount);
    }

    public void transfer(int fromAccountNumber, int toAccountNumber, double amount) throws Exception {
        Account fromAccount = findAccount(fromAccountNumber);
        Account toAccount = findAccount(toAccountNumber);

        if (fromAccount.getBalance() < amount) {
            throw new InsufficientBalanceException("��ü�� ������ �ܾ��� �����մϴ�.");
        }

        fromAccount.withdraw(amount);
        toAccount.deposit(amount);
    }

    public void printAllAccounts() {
        System.out.println("--- ��� ���� ���� ---");
        for (Account account : accounts) {
            System.out.println(account);
        }
        System.out.println("-----------------------");
    }
}