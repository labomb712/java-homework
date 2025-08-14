// mylab.book.control ��Ű��
package mylab.book.control;

import java.util.ArrayList;
import java.util.List;

import mylab.book.entity.Magazine;
import mylab.book.entity.Novel;
import mylab.book.entity.Publication;
import mylab.book.entity.ReferenceBook;

/**
 * ���ǹ� ���� �ý����� ��ٱ��� ����� ������ Ŭ�����Դϴ�.
 * ��ٱ��Ͽ� ���ǹ��� �߰�/�����ϰ�, ���� �� ��� ������ ����մϴ�.
 */
public class ShoppingCart {
    private List<Publication> items; // ArrayList�� ���� ũ�� ����

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    // ��ٱ��Ͽ� ���ǹ� �߰�
    public void addItem(Publication item) {
        items.add(item);
        System.out.println(item.getTitle() + "��(��) ��ٱ��Ͽ� �߰��Ǿ����ϴ�.");
    }

    // �������� ���ǹ� ����
    public boolean removeItem(String title) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getTitle().equals(title)) {
                Publication removed = items.remove(i);
                System.out.println(removed.getTitle() + "��(��) ��ٱ��Ͽ��� ���ŵǾ����ϴ�.");
                return true; // ���������� ���ŵ�
            }
        }
        System.out.println("�ش� ������ ���ǹ��� ã�� �� �����ϴ�.");
        return false; // ���� ����
    }

    // ��ٱ��� ���� ���
    public void displayCart() {
        System.out.println("====== ��ٱ��� ���� ======");
        if (items.isEmpty()) {
            System.out.println("��ٱ��ϰ� ��� �ֽ��ϴ�.");
            return;
        }
        for (Publication item : items) {
            System.out.println("- " + item.toString());
        }
        System.out.println("-------------------------");
        System.out.println("�� ����: " + calculateTotalPrice() + "��");
        System.out.println("���� ���� ����: " + calculateDiscountedPrice() + "��");
        System.out.println("=========================");
    }

    // ��ٱ��Ͽ� �ִ� ��� ���ǹ��� ���� ������ �ջ�
    public int calculateTotalPrice() {
        int total = 0;
        for (Publication item : items) {
            total += item.getPrice();
        }
        return total;
    }

    // ���ǹ� Ÿ�Կ� ���� �ٸ� �������� �����Ͽ� �� ���ΰ� ���
    public int calculateDiscountedPrice() {
        int total = 0;
        for (Publication item : items) {
            if (item instanceof Magazine) {
                total += item.getPrice() * 0.9; // 10% ����
            } else if (item instanceof Novel) {
                total += item.getPrice() * 0.85; // 15% ����
            } else if (item instanceof ReferenceBook) {
                total += item.getPrice() * 0.8; // 20% ����
            } else {
                total += item.getPrice(); // �⺻ ���ǹ��� ���� ����
            }
        }
        return total;
    }

    // ��ٱ��Ͽ� ��� ���ǹ����� Ÿ�Ժ� ���(����)�� ���
    public void printStatistics() {
        int magazineCount = 0;
        int novelCount = 0;
        int referenceBookCount = 0;
        for (Publication item : items) {
            if (item instanceof Magazine) {
                magazineCount++;
            } else if (item instanceof Novel) {
                novelCount++;
            } else if (item instanceof ReferenceBook) {
                referenceBookCount++;
            }
        }
        // ��� ���
        System.out.println("====== ��ٱ��� ��� ======");
        System.out.println("����: " + magazineCount + "��");
        System.out.println("�Ҽ�: " + novelCount + "��");
        System.out.println("����: " + referenceBookCount + "��");
        System.out.println("�� ���ǹ�: " + items.size() + "��");
    }
}
