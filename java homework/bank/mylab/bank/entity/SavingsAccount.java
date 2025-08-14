package mylab.bank.entity;

public class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(int accountNumber, String ownerName, double balance, double interestRate) {
        super(accountNumber, ownerName, balance);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void applyInterest() {
        double interest = this.balance * this.interestRate;
        this.balance += interest;
        System.out.println(accountNumber + " 계좌에 이자 " + interest + "원 적용. 현재 잔액: " + balance + "원");
    }

    @Override
    public String toString() {
        return super.toString() + ", 이자율: " + (interestRate * 100) + "% (저축 계좌)";
    }
}