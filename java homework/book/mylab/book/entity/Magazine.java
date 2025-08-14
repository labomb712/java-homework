// mylab.book.entity ��Ű��
package mylab.book.entity;

/**
 * Publication�� ��ӹ޾� ���� ������ ǥ���ϴ� Ŭ�����Դϴ�.
 * �����ֱ� �Ӽ��� �߰��� �����ϴ�.
 */
public class Magazine extends Publication {
    // �ֿ� �Ӽ�
    private String publishPeriod;

    // ������: �θ� �ʵ�� �ڽŸ��� �ʵ� �ʱ�ȭ
    public Magazine(String title, String publishDate, int page, int price, String publishPeriod) {
        super(title, publishDate, page, price);
        this.publishPeriod = publishPeriod;
    }

    // toString() �������̵�: ���� ���� �� ǥ��
    @Override
    public String toString() {
        return super.toString() + " [����] �����ֱ�:" + publishPeriod + ", " + getPage() + "��, " + getPrice() + "��, ������:" + getPublishDate();
    }
}
