package mylab.bank.control;

import mylab.bank.entity.Bank;
import mylab.bank.entity.SavingsAccount;
import mylab.bank.exception.AccountNotFoundException;
import mylab.bank.exception.InsufficientBalanceException;
import mylab.bank.exception.WithdrawalLimitExceededException;

public class BankDemo {
    public static void main(String[] args) {
        Bank bank = new Bank();

        System.out.println("은행 시스템 데모 시작");

        try {
            // 1. 계좌 생성
            System.out.println("\n--- 1. 계좌 생성 ---");
            bank.createSavingsAccount("김철수", 100000, 0.05);
            bank.createCheckingAccount("이영희", 50000, 10000);
            bank.printAllAccounts();

            // 2. 입금 및 출금
            System.out.println("\n--- 2. 입금 및 출금 ---");
            bank.deposit(1000, 50000);
            System.out.println("계좌번호 1000에 50000원 입금");
            bank.withdraw(1001, 10000);
            System.out.println("계좌번호 1001에서 10000원 출금");
            bank.printAllAccounts();

            // 3. 이자 적용
            System.out.println("\n--- 3. 이자 적용 ---");
            SavingsAccount savings = (SavingsAccount) bank.findAccount(1000);
            savings.applyInterest();
            System.out.println("계좌번호 1000에 이자 적용");
            bank.printAllAccounts();

            // 4. 계좌 이체
            System.out.println("\n--- 4. 계좌 이체 ---");
            bank.transfer(1000, 1001, 20000);
            System.out.println("계좌번호 1000에서 1001로 20000원 이체");
            bank.printAllAccounts();

            // 5. 예외 처리 테스트
            System.out.println("\n--- 5. 예외 처리 테스트 ---");
            
            // 존재하지 않는 계좌 조회
            System.out.println("\n[테스트] 존재하지 않는 계좌 조회:");
            bank.findAccount(9999);
            
            // 잔액 부족 테스트
            System.out.println("\n[테스트] 잔액 부족 테스트:");
            bank.withdraw(1001, 100000);
            
            // 출금 한도 초과 테스트
            System.out.println("\n[테스트] 출금 한도 초과 테스트:");
            bank.withdraw(1001, 20000);

        } catch (AccountNotFoundException e) {
            System.err.println("오류: " + e.getMessage());
        } catch (WithdrawalLimitExceededException e) {
            System.err.println("오류: " + e.getMessage());
        } catch (InsufficientBalanceException e) {
            System.err.println("오류: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("알 수 없는 오류: " + e.getMessage());
        }
    }
}