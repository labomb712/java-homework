package mylab.bank.entity;

public abstract class Account {
    private int accountNumber;
    private String ownerName;
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
        if (amount <= 0) {
            throw new IllegalArgumentException("�Աݾ��� 0���� Ŀ�� �մϴ�.");
        }
        this.balance += amount;
    }

    public abstract void withdraw(double amount) throws Exception;

    @Override
    public String toString() {
        return "���¹�ȣ: " + accountNumber + ", ������: " + ownerName + ", �ܾ�: " + balance;
    }
}