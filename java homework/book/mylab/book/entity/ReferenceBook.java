// mylab.book.entity ��Ű��
package mylab.book.entity;

/**
 * Publication�� ��ӹ޾� ���� ������ ǥ���ϴ� Ŭ�����Դϴ�.
 * ���� �о� �Ӽ��� �߰��� �����ϴ�.
 */
public class ReferenceBook extends Publication {
    // �ֿ� �Ӽ�
    private String field;

    // ������: �θ� �ʵ�� �ڽŸ��� �ʵ� �ʱ�ȭ
    public ReferenceBook(String title, String publishDate, int page, int price, String field) {
        super(title, publishDate, page, price);
        this.field = field;
    }

    // toString() �������̵�: ���� ���� �� ǥ��
    @Override
    public String toString() {
        return super.toString() + " [����] �о�:" + field + ", " + getPage() + "��, " + getPrice() + "��, ������:" + getPublishDate();
    }
}
