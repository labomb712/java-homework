// mylab.book.entity 패키지
package mylab.book.entity;

/**
 * Publication을 상속받아 소설 정보를 표현하는 클래스입니다.
 * 저자와 장르 속성을 추가로 가집니다.
 */
public class Novel extends Publication {
    // 주요 속성
    private String author;
    private String genre;

    // 생성자: 부모 필드와 자신만의 필드 초기화
    public Novel(String title, String publishDate, int page, int price, String author, String genre) {
        super(title, publishDate, page, price);
        this.author = author;
        this.genre = genre;
    }

    // toString() 오버라이드: 소설 정보 상세 표시
    @Override
    public String toString() {
        return super.toString() + " [소설] 저자:" + author + ", 장르:" + genre + ", " + getPage() + "쪽, " + getPrice() + "원, 출판일:" + getPublishDate();
    }
}
