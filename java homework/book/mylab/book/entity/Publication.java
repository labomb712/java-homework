// mylab.book.entity 패키지
package mylab.book.entity;

/**
 * 모든 출판물의 기본이 되는 클래스입니다.
 * title, publishDate, page, price 속성을 가집니다.
 */
public class Publication {
    // 주요 속성
    private String title;
    private String publishDate;
    private int page;
    private int price;

    // 기본 생성자
    public Publication() {}

    // 모든 필드를 초기화하는 생성자
    public Publication(String title, String publishDate, int page, int price) {
        this.title = title;
        this.publishDate = publishDate;
        this.page = page;
        this.price = price;
    }

    // toString() 메서드를 오버라이드하여 제목만 반환
    @Override
    public String toString() {
        return title;
    }

    // Getter 및 Setter 메서드
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getPublishDate() { return publishDate; }
    public void setPublishDate(String publishDate) { this.publishDate = publishDate; }
    public int getPage() { return page; }
    public void setPage(int page) { this.page = page; }
    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }
}
