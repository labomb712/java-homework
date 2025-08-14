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
        System.out.println(accountNumber + " ���¿� ���� " + interest + "�� ����. ���� �ܾ�: " + balance + "��");
    }

    @Override
    public String toString() {
        return super.toString() + ", ������: " + (interestRate * 100) + "% (���� ����)";
    }
}