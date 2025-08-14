// mylab.book.control ��Ű��
package mylab.book.control;

import mylab.book.entity.Magazine;
import mylab.book.entity.Novel;
import mylab.book.entity.Publication;
import mylab.book.entity.ReferenceBook;

/**
 * ���ǹ� ���� �ý����� �ֿ� ���� Ŭ������, ��ü ������ ����, ��� �м��� �����մϴ�.
 */
public class ManageBook {
    public static void main(String[] args) {
        System.out.println("--- 1. ���ǹ� �迭 ���� �� �ʱ�ȭ ---");
        // �������� Ȱ���Ͽ� Publication Ÿ���� �迭�� �پ��� ���� Ŭ���� ��ü ����
        Publication[] publications = {
            new Magazine("����ũ�μ���Ʈ", "2007-10-01", 328, 9900, "�ſ�"),
            new Magazine("�濵����ǻ��", "2007-10-03", 316, 9000, "�ſ�"),
            new Novel("���߿�", "2007-07-01", 396, 9800, "����������������", "����Ҽ�"),
            new Novel("���ѻ꼺", "2007-04-14", 383, 11000, "����", "���ϼҼ�"),
            new ReferenceBook("�ǿ��������α׷���", "2007-01-14", 496, 25000, "����Ʈ�������"),
            new Novel("�ҳ��̿´�", "2014-05-01", 216, 15000, "�Ѱ�", "����Ҽ�"),
            new Novel("�ۺ������ʴ´�", "2021-09-09", 332, 15120, "�Ѱ�", "����Ҽ�")
        };

        System.out.println("\n--- 2. ���ǹ� ���� ��� ---");
        for (int i = 0; i < publications.length; i++) {
            System.out.println((i + 1) + ". " + publications[i].toString());
        }

        System.out.println("\n--- 3. 3��° ���ǹ� ���� ���� �� ��� ---");
        int originalPrice = publications[2].getPrice();
        modifyPrice(publications[2]);
        int newPrice = publications[2].getPrice();
        System.out.println("���� ����: " + originalPrice + "��, ���� �� ����: " + newPrice + "��, ����: " + (originalPrice - newPrice) + "��");

        System.out.println("\n--- 4. ��� �м� ���� ---");
        StatisticsAnalyzer analyzer = new StatisticsAnalyzer();
        analyzer.printStatistics(publications);
        
        System.out.println("\n--- 5. ��ٱ��� �׽�Ʈ ---");
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(publications[0]);
        cart.addItem(publications[2]);
        cart.addItem(publications[5]);
        
        cart.displayCart();
        cart.printStatistics();
        
        cart.removeItem("���߿�");
        
        cart.displayCart();
    }

    /**
     * ���ǹ� ��ü�� Ÿ�Կ� ���� �ٸ� �������� �����մϴ�.
     */
    public static void modifyPrice(Publication publication) {
        int currentPrice = publication.getPrice();
        // instanceof�� ���� ��ü Ÿ�� Ȯ�� �� ������ ���� ����
        if (publication instanceof Magazine) {
            publication.setPrice((int)(currentPrice * 0.6)); // 40% ����
        } else if (publication instanceof Novel) {
            publication.setPrice((int)(currentPrice * 0.8)); // 20% ����
        } else if (publication instanceof ReferenceBook) {
            publication.setPrice((int)(currentPrice * 0.9)); // 10% ����
        }
    }
}
