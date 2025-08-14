// mylab.book.entity ��Ű��
package mylab.book.entity;

/**
 * ��� ���ǹ��� �⺻�� �Ǵ� Ŭ�����Դϴ�.
 * title, publishDate, page, price �Ӽ��� �����ϴ�.
 */
public class Publication {
    // �ֿ� �Ӽ�
    private String title;
    private String publishDate;
    private int page;
    private int price;

    // �⺻ ������
    public Publication() {}

    // ��� �ʵ带 �ʱ�ȭ�ϴ� ������
    public Publication(String title, String publishDate, int page, int price) {
        this.title = title;
        this.publishDate = publishDate;
        this.page = page;
        this.price = price;
    }

    // toString() �޼��带 �������̵��Ͽ� ���� ��ȯ
    @Override
    public String toString() {
        return title;
    }

    // Getter �� Setter �޼���
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getPublishDate() { return publishDate; }
    public void setPublishDate(String publishDate) { this.publishDate = publishDate; }
    public int getPage() { return page; }
    public void setPage(int page) { this.page = page; }
    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }
}
