package mylab.bank.control;

import mylab.bank.entity.Bank;
import mylab.bank.entity.SavingsAccount;
import mylab.bank.exception.AccountNotFoundException;
import mylab.bank.exception.InsufficientBalanceException;
import mylab.bank.exception.WithdrawalLimitExceededException;

public class BankDemo {
    public static void main(String[] args) {
        Bank bank = new Bank();

        System.out.println("--- 1. ���� ���� �׽�Ʈ ---");
        bank.createSavingsAccount("ȫ�浿", 100000, 0.05);
        bank.createCheckingAccount("��ö��", 50000, 20000);
        bank.printAllAccounts();

        System.out.println("\n--- 2. �Ա�/��� �׽�Ʈ ---");
        try {
            System.out.println("\nȫ�浿 ���¿� 50000�� �Ա�");
            bank.deposit(1000, 50000);
            
            System.out.println("\n��ö�� ���¿��� 10000�� ���");
            bank.withdraw(1001, 10000);
            
            System.out.println("\n��ö�� ���¿��� �ѵ� �ʰ� �ݾ� ��� �õ�");
            bank.withdraw(1001, 30000);
        } catch (WithdrawalLimitExceededException e) {
            System.out.println("���� �߻�: " + e.getMessage());
        } catch (InsufficientBalanceException e) {
            System.out.println("���� �߻�: " + e.getMessage());
        } catch (AccountNotFoundException e) {
            System.out.println("���� �߻�: " + e.getMessage());
        }
        bank.printAllAccounts();

        System.out.println("\n--- 3. ���� ���� �׽�Ʈ ---");
        try {
            bank.applyInterest(1000);
            bank.applyInterest(1001); // üŷ ���¿� ���� ���� �õ�
        } catch (AccountNotFoundException e) {
            System.out.println("���� �߻�: " + e.getMessage());
        }
        bank.printAllAccounts();

        System.out.println("\n--- 4. ���� ��ü �׽�Ʈ ---");
        try {
            bank.transfer(1000, 1001, 30000);
        } catch (InsufficientBalanceException e) {
            System.out.println("���� �߻�: " + e.getMessage());
        } catch (AccountNotFoundException e) {
            System.out.println("���� �߻�: " + e.getMessage());
        }
        bank.printAllAccounts();
        
        System.out.println("\n--- 5. ���� ó�� �׽�Ʈ ---");
        try {
        	System.out.println("\n���� ���¹�ȣ�� ��ȸ �õ�");
        	bank.findAccount(2000);
        } catch (AccountNotFoundException e) {
        	System.out.println("���� �߻�: " + e.getMessage());
        }
        
        try {
            System.out.println("\n�ܾ� �ʰ� ��� �õ�");
            bank.withdraw(1000, 500000);
        } catch (InsufficientBalanceException e) {
            System.out.println("���� �߻�: " + e.getMessage());
        } catch (AccountNotFoundException e) {
            System.out.println("���� �߻�: " + e.getMessage());
        }
    }
}