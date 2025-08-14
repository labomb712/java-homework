package mylab.bank.entity;

import mylab.bank.exception.InsufficientBalanceException;

public abstract class Account {
    protected int accountNumber;
    protected String ownerName;
    protected double balance;

    public Account(int accountNumber, String ownerName, double balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println(accountNumber + " 계좌에 " + amount + "원 입금. 현재 잔액: " + balance + "원");
        }
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > this.balance) {
            throw new InsufficientBalanceException("잔액이 부족합니다. 현재 잔액: " + this.balance + "원");
        }
        this.balance -= amount;
        System.out.println(accountNumber + " 계좌에서 " + amount + "원 출금. 현재 잔액: " + balance + "원");
    }
    
    @Override
    public String toString() {
        return "계좌번호: " + accountNumber + ", 소유자: " + ownerName + ", 잔액: " + balance;
    }
}