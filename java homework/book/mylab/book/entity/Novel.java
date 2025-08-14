// mylab.book.entity ��Ű��
package mylab.book.entity;

/**
 * Publication�� ��ӹ޾� �Ҽ� ������ ǥ���ϴ� Ŭ�����Դϴ�.
 * ���ڿ� �帣 �Ӽ��� �߰��� �����ϴ�.
 */
public class Novel extends Publication {
    // �ֿ� �Ӽ�
    private String author;
    private String genre;

    // ������: �θ� �ʵ�� �ڽŸ��� �ʵ� �ʱ�ȭ
    public Novel(String title, String publishDate, int page, int price, String author, String genre) {
        super(title, publishDate, page, price);
        this.author = author;
        this.genre = genre;
    }

    // toString() �������̵�: �Ҽ� ���� �� ǥ��
    @Override
    public String toString() {
        return super.toString() + " [�Ҽ�] ����:" + author + ", �帣:" + genre + ", " + getPage() + "��, " + getPrice() + "��, ������:" + getPublishDate();
    }
}
