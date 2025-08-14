// mylab.book.entity 패키지
package mylab.book.entity;

/**
 * Publication을 상속받아 참고서 정보를 표현하는 클래스입니다.
 * 전문 분야 속성을 추가로 가집니다.
 */
public class ReferenceBook extends Publication {
    // 주요 속성
    private String field;

    // 생성자: 부모 필드와 자신만의 필드 초기화
    public ReferenceBook(String title, String publishDate, int page, int price, String field) {
        super(title, publishDate, page, price);
        this.field = field;
    }

    // toString() 오버라이드: 참고서 정보 상세 표시
    @Override
    public String toString() {
        return super.toString() + " [참고서] 분야:" + field + ", " + getPage() + "쪽, " + getPrice() + "원, 출판일:" + getPublishDate();
    }
}
