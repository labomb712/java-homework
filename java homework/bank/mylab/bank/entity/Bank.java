package mylab.bank.entity;

import java.util.ArrayList;
import java.util.List;

import mylab.bank.exception.AccountNotFoundException;
import mylab.bank.exception.InsufficientBalanceException;
import mylab.bank.exception.WithdrawalLimitExceededException;

public class Bank {
    private List<Account> accounts;
    private int nextAccountNumber;

    public Bank() {
        this.accounts = new ArrayList<>();
        this.nextAccountNumber = 1000;
    }

    public Account createSavingsAccount(String ownerName, double initialDeposit, double interestRate) {
        SavingsAccount newAccount = new SavingsAccount(nextAccountNumber++, ownerName, initialDeposit, interestRate);
        accounts.add(newAccount);
        return newAccount;
    }

    public Account createCheckingAccount(String ownerName, double initialDeposit, double withdrawalLimit) {
        CheckingAccount newAccount = new CheckingAccount(nextAccountNumber++, ownerName, initialDeposit, withdrawalLimit);
        accounts.add(newAccount);
        return newAccount;
    }

    public Account findAccount(int accountNumber) throws AccountNotFoundException {
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        throw new AccountNotFoundException("계좌번호 " + accountNumber + "를 찾을 수 없습니다.");
    }

    public void deposit(int accountNumber, double amount) throws AccountNotFoundException {
        Account account = findAccount(accountNumber);
        account.deposit(amount);
    }

    public void withdraw(int accountNumber, double amount) throws AccountNotFoundException, InsufficientBalanceException {
        Account account = findAccount(accountNumber);
        account.withdraw(amount);
    }

    public void transfer(int fromAccountNumber, int toAccountNumber, double amount) throws AccountNotFoundException, InsufficientBalanceException {
        Account fromAccount = findAccount(fromAccountNumber);
        Account toAccount = findAccount(toAccountNumber);
        fromAccount.withdraw(amount);
        toAccount.deposit(amount);
    }

    public void applyInterest(int accountNumber) throws AccountNotFoundException {
        Account account = findAccount(accountNumber);
        if (account instanceof SavingsAccount) {
            ((SavingsAccount) account).applyInterest();
        } else {
            System.out.println("저축 계좌에만 이자를 적용할 수 있습니다.");
        }
    }

    public void printAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("등록된 계좌가 없습니다.");
            return;
        }
        System.out.println("--- 전체 계좌 목록 ---");
        for (Account account : accounts) {
            System.out.println(account.toString());
        }
        System.out.println("--------------------");
    }
}