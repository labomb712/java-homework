// mylab.book.control 패키지
package mylab.book.control;

import mylab.book.entity.Magazine;
import mylab.book.entity.Novel;
import mylab.book.entity.Publication;
import mylab.book.entity.ReferenceBook;

/**
 * 출판물 관리 시스템의 주요 실행 클래스로, 객체 생성과 관리, 통계 분석을 수행합니다.
 */
public class ManageBook {
    public static void main(String[] args) {
        System.out.println("--- 1. 출판물 배열 생성 및 초기화 ---");
        // 다형성을 활용하여 Publication 타입의 배열에 다양한 하위 클래스 객체 저장
        Publication[] publications = {
            new Magazine("마이크로소프트", "2007-10-01", 328, 9900, "매월"),
            new Magazine("경영과컴퓨터", "2007-10-03", 316, 9000, "매월"),
            new Novel("빠삐용", "2007-07-01", 396, 9800, "베르나르베르베르", "현대소설"),
            new Novel("남한산성", "2007-04-14", 383, 11000, "김훈", "대하소설"),
            new ReferenceBook("실용주의프로그래머", "2007-01-14", 496, 25000, "소프트웨어공학"),
            new Novel("소년이온다", "2014-05-01", 216, 15000, "한강", "장편소설"),
            new Novel("작별하지않는다", "2021-09-09", 332, 15120, "한강", "장편소설")
        };

        System.out.println("\n--- 2. 출판물 정보 출력 ---");
        for (int i = 0; i < publications.length; i++) {
            System.out.println((i + 1) + ". " + publications[i].toString());
        }

        System.out.println("\n--- 3. 3번째 출판물 가격 변경 및 출력 ---");
        int originalPrice = publications[2].getPrice();
        modifyPrice(publications[2]);
        int newPrice = publications[2].getPrice();
        System.out.println("기존 가격: " + originalPrice + "원, 변경 후 가격: " + newPrice + "원, 차액: " + (originalPrice - newPrice) + "원");

        System.out.println("\n--- 4. 통계 분석 실행 ---");
        StatisticsAnalyzer analyzer = new StatisticsAnalyzer();
        analyzer.printStatistics(publications);
        
        System.out.println("\n--- 5. 장바구니 테스트 ---");
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(publications[0]);
        cart.addItem(publications[2]);
        cart.addItem(publications[5]);
        
        cart.displayCart();
        cart.printStatistics();
        
        cart.removeItem("빠삐용");
        
        cart.displayCart();
    }

    /**
     * 출판물 객체의 타입에 따라 다른 할인율을 적용합니다.
     */
    public static void modifyPrice(Publication publication) {
        int currentPrice = publication.getPrice();
        // instanceof로 실제 객체 타입 확인 후 차별적 할인 적용
        if (publication instanceof Magazine) {
            publication.setPrice((int)(currentPrice * 0.6)); // 40% 할인
        } else if (publication instanceof Novel) {
            publication.setPrice((int)(currentPrice * 0.8)); // 20% 할인
        } else if (publication instanceof ReferenceBook) {
            publication.setPrice((int)(currentPrice * 0.9)); // 10% 할인
        }
    }
}
