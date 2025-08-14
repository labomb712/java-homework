// mylab.book.entity 패키지
package mylab.book.entity;

/**
 * Publication을 상속받아 잡지 정보를 표현하는 클래스입니다.
 * 발행주기 속성을 추가로 가집니다.
 */
public class Magazine extends Publication {
    // 주요 속성
    private String publishPeriod;

    // 생성자: 부모 필드와 자신만의 필드 초기화
    public Magazine(String title, String publishDate, int page, int price, String publishPeriod) {
        super(title, publishDate, page, price);
        this.publishPeriod = publishPeriod;
    }

    // toString() 오버라이드: 잡지 정보 상세 표시
    @Override
    public String toString() {
        return super.toString() + " [잡지] 발행주기:" + publishPeriod + ", " + getPage() + "쪽, " + getPrice() + "원, 출판일:" + getPublishDate();
    }
}
