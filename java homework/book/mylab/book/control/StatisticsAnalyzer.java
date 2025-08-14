// mylab.book.control 패키지
package mylab.book.control;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import mylab.book.entity.Magazine;
import mylab.book.entity.Novel;
import mylab.book.entity.Publication;
import mylab.book.entity.ReferenceBook;

/**
 * 출판물 배열을 분석하여 다양한 통계 정보를 계산하고 출력하는 클래스입니다.
 */
public class StatisticsAnalyzer {
    /**
     * 출판물 배열을 분석하여 출판물 타입별 평균 가격을 계산합니다.
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
     * 출판물 배열을 분석하여 각 타입별 비율(백분율)을 계산합니다.
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
     * 입력받은 연도에 출판된 출판물의 비율을 계산합니다.
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
     * 출판물 객체의 실제 타입을 확인하여 해당하는 한글 타입명을 반환합니다.
     */
    private String getPublicationType(Publication pub) {
        if (pub instanceof Novel) {
            return "소설";
        } else if (pub instanceof Magazine) {
            return "잡지";
        } else if (pub instanceof ReferenceBook) {
            return "참고서";
        }
        return "기타";
    }

    /**
     * 다양한 통계 메서드를 호출하여 출판물에 대한 종합적인 통계 정보를 출력합니다.
     */
    public void printStatistics(Publication[] publications) {
        DecimalFormat df = new DecimalFormat("#,###.##");
        
        System.out.println("====== 종합 통계 분석 ======");

        // 1. 타입별 평균 가격
        Map<String, Double> avgPrices = calculateAveragePriceByType(publications);
        System.out.println("\n- 타입별 평균 가격:");
        for (Map.Entry<String, Double> entry : avgPrices.entrySet()) {
            System.out.println("  " + entry.getKey() + ": " + df.format(entry.getValue()) + "원");
        }

        // 2. 출판물 유형 분포
        Map<String, Double> distribution = calculatePublicationDistribution(publications);
        System.out.println("\n- 출판물 유형 분포:");
        for (Map.Entry<String, Double> entry : distribution.entrySet()) {
            System.out.println("  " + entry.getKey() + ": " + df.format(entry.getValue()) + "%");
        }

        // 3. 2007년도 출판물 비율
        double ratio2007 = calculatePublicationRatioByYear(publications, "2007");
        System.out.println("\n- 2007년도 출판물 비율: " + df.format(ratio2007) + "%");
        
        System.out.println("=========================");
    }
}
