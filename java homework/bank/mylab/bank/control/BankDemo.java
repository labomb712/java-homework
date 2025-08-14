package mylab.bank.control;

import mylab.bank.entity.Bank;
import mylab.bank.entity.SavingsAccount;
import mylab.bank.exception.AccountNotFoundException;
import mylab.bank.exception.InsufficientBalanceException;
import mylab.bank.exception.WithdrawalLimitExceededException;

public class BankDemo {
    public static void main(String[] args) {
        Bank bank = new Bank();

        System.out.println("--- 1. 계좌 생성 테스트 ---");
        bank.createSavingsAccount("홍길동", 100000, 0.05);
        bank.createCheckingAccount("김철수", 50000, 20000);
        bank.printAllAccounts();

        System.out.println("\n--- 2. 입금/출금 테스트 ---");
        try {
            System.out.println("\n홍길동 계좌에 50000원 입금");
            bank.deposit(1000, 50000);
            
            System.out.println("\n김철수 계좌에서 10000원 출금");
            bank.withdraw(1001, 10000);
            
            System.out.println("\n김철수 계좌에서 한도 초과 금액 출금 시도");
            bank.withdraw(1001, 30000);
        } catch (WithdrawalLimitExceededException e) {
            System.out.println("오류 발생: " + e.getMessage());
        } catch (InsufficientBalanceException e) {
            System.out.println("오류 발생: " + e.getMessage());
        } catch (AccountNotFoundException e) {
            System.out.println("오류 발생: " + e.getMessage());
        }
        bank.printAllAccounts();

        System.out.println("\n--- 3. 이자 적용 테스트 ---");
        try {
            bank.applyInterest(1000);
            bank.applyInterest(1001); // 체킹 계좌에 이자 적용 시도
        } catch (AccountNotFoundException e) {
            System.out.println("오류 발생: " + e.getMessage());
        }
        bank.printAllAccounts();

        System.out.println("\n--- 4. 계좌 이체 테스트 ---");
        try {
            bank.transfer(1000, 1001, 30000);
        } catch (InsufficientBalanceException e) {
            System.out.println("오류 발생: " + e.getMessage());
        } catch (AccountNotFoundException e) {
            System.out.println("오류 발생: " + e.getMessage());
        }
        bank.printAllAccounts();
        
        System.out.println("\n--- 5. 예외 처리 테스트 ---");
        try {
        	System.out.println("\n없는 계좌번호로 조회 시도");
        	bank.findAccount(2000);
        } catch (AccountNotFoundException e) {
        	System.out.println("오류 발생: " + e.getMessage());
        }
        
        try {
            System.out.println("\n잔액 초과 출금 시도");
            bank.withdraw(1000, 500000);
        } catch (InsufficientBalanceException e) {
            System.out.println("오류 발생: " + e.getMessage());
        } catch (AccountNotFoundException e) {
            System.out.println("오류 발생: " + e.getMessage());
        }
    }
}