// mylab.book.control ��Ű��
package mylab.book.control;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import mylab.book.entity.Magazine;
import mylab.book.entity.Novel;
import mylab.book.entity.Publication;
import mylab.book.entity.ReferenceBook;

/**
 * ���ǹ� �迭�� �м��Ͽ� �پ��� ��� ������ ����ϰ� ����ϴ� Ŭ�����Դϴ�.
 */
public class StatisticsAnalyzer {
    /**
     * ���ǹ� �迭�� �м��Ͽ� ���ǹ� Ÿ�Ժ� ��� ������ ����մϴ�.
     */
    public Map<String, Double> calculateAveragePriceByType(Publication[] publications) {
        Map<String, Double> averagePrices = new HashMap<>();
        Map<String, Integer> priceSum = new HashMap<>();
        Map<String, Integer> count = new HashMap<>();

        for (Publication pub : publications) {
            String type = getPublicationType(pub);
            priceSum.put(type, priceSum.getOrDefault(type, 0) + pub.getPrice());
            count.put(type, count.getOrDefault(type, 0) + 1);
        }

        for (String type : priceSum.keySet()) {
            averagePrices.put(type, (double) priceSum.get(type) / count.get(type));
        }

        return averagePrices;
    }

    /**
     * ���ǹ� �迭�� �м��Ͽ� �� Ÿ�Ժ� ����(�����)�� ����մϴ�.
     */
    public Map<String, Double> calculatePublicationDistribution(Publication[] publications) {
        Map<String, Double> distribution = new HashMap<>();
        Map<String, Integer> count = new HashMap<>();
        int totalCount = publications.length;

        for (Publication pub : publications) {
            String type = getPublicationType(pub);
            count.put(type, count.getOrDefault(type, 0) + 1);
        }

        for (String type : count.keySet()) {
            distribution.put(type, (double) count.get(type) / totalCount * 100);
        }

        return distribution;
    }

    /**
     * �Է¹��� ������ ���ǵ� ���ǹ��� ������ ����մϴ�.
     */
    public double calculatePublicationRatioByYear(Publication[] publications, String year) {
        int count = 0;
        for (Publication pub : publications) {
            if (pub.getPublishDate().startsWith(year)) {
                count++;
            }
        }
        return (double) count / publications.length * 100;
    }

    /**
     * ���ǹ� ��ü�� ���� Ÿ���� Ȯ���Ͽ� �ش��ϴ� �ѱ� Ÿ�Ը��� ��ȯ�մϴ�.
     */
    private String getPublicationType(Publication pub) {
        if (pub instanceof Novel) {
            return "�Ҽ�";
        } else if (pub instanceof Magazine) {
            return "����";
        } else if (pub instanceof ReferenceBook) {
            return "����";
        }
        return "��Ÿ";
    }

    /**
     * �پ��� ��� �޼��带 ȣ���Ͽ� ���ǹ��� ���� �������� ��� ������ ����մϴ�.
     */
    public void printStatistics(Publication[] publications) {
        DecimalFormat df = new DecimalFormat("#,###.##");
        
        System.out.println("====== ���� ��� �м� ======");

        // 1. Ÿ�Ժ� ��� ����
        Map<String, Double> avgPrices = calculateAveragePriceByType(publications);
        System.out.println("\n- Ÿ�Ժ� ��� ����:");
        for (Map.Entry<String, Double> entry : avgPrices.entrySet()) {
            System.out.println("  " + entry.getKey() + ": " + df.format(entry.getValue()) + "��");
        }

        // 2. ���ǹ� ���� ����
        Map<String, Double> distribution = calculatePublicationDistribution(publications);
        System.out.println("\n- ���ǹ� ���� ����:");
        for (Map.Entry<String, Double> entry : distribution.entrySet()) {
            System.out.println("  " + entry.getKey() + ": " + df.format(entry.getValue()) + "%");
        }

        // 3. 2007�⵵ ���ǹ� ����
        double ratio2007 = calculatePublicationRatioByYear(publications, "2007");
        System.out.println("\n- 2007�⵵ ���ǹ� ����: " + df.format(ratio2007) + "%");
        
        System.out.println("=========================");
    }
}
