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
            System.out.println(accountNumber + " ���¿� " + amount + "�� �Ա�. ���� �ܾ�: " + balance + "��");
        }
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > this.balance) {
            throw new InsufficientBalanceException("�ܾ��� �����մϴ�. ���� �ܾ�: " + this.balance + "��");
        }
        this.balance -= amount;
        System.out.println(accountNumber + " ���¿��� " + amount + "�� ���. ���� �ܾ�: " + balance + "��");
    }
    
    @Override
    public String toString() {
        return "���¹�ȣ: " + accountNumber + ", ������: " + ownerName + ", �ܾ�: " + balance;
    }
}