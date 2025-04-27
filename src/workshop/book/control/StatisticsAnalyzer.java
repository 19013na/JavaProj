package workshop.book.control;

import java.util.HashMap;
import java.util.Map;

import workshop.book.entity.Magazine;
import workshop.book.entity.Novel;
import workshop.book.entity.Publication;
import workshop.book.entity.ReferenceBook;

public class StatisticsAnalyzer {
	
	// 타입별 평균 가격 계산
	public Map<String, Double> calculateAveragePriceByType(Publication[] pubs){
		Map<String, Integer> typeSum = new HashMap<>();
		Map<String, Integer> typeCount = new HashMap<>();
		
		for(Publication pub : pubs) {
			String type = getPublicationType(pub);
			typeSum.put(type, typeSum.getOrDefault(type,  0) + pub.getPrice());
			typeCount.put(type, typeCount.getOrDefault(type, 0) + 1);
		}
		
		int total = pubs.length;
		Map<String, Double> result = new HashMap<>();
		for(String type : typeCount.keySet()) {
			result.put(type, (typeCount.get(type) / (double) total) * 100);
		}
		return result;
	}

	// 출판물 유형 분포 계산
	public Map<String, Double> calculatePublicationDistribution(Publication[] pubs){
		Map<String, Integer> typeCount = new HashMap<>();
        
        for (Publication pub : pubs) {
            String type = getPublicationType(pub);
            typeCount.put(type, typeCount.getOrDefault(type, 0) + 1);
        }
        
        int total = pubs.length;
        Map<String, Double> result = new HashMap<>();
        for (String type : typeCount.keySet()) {
            result.put(type, (typeCount.get(type) / (double) total) * 100);
        }
        
        return result;
	}
	
	// 특정 연도 비율 계산
	public double calculatePublicationRatioByYear(Publication[] publications, String year) {
		int total = publications.length;
		int count = 0;
		for(Publication pub : publications) {
			String pubYear = pub.getPublishingDate().split("-")[0];
			if(year.equals(pubYear))
				count++;
		}
		return (count / (double) total) * 100;
	}
	
	// 출판물 타입 확인
	private String getPublicationType(Publication pub) {
		if(pub instanceof Novel) {
			return "소설";
		}
		if(pub instanceof Magazine) {
			return "잡지";
		}
		if(pub instanceof ReferenceBook) {
			return "참고서";
		}
		return "기타";
	}
	
	// 통계 정보 출력
	public void printStatistics(Publication[] pubs) {
		Map<String, Double> avgPrice = calculateAveragePriceByType(pubs);
        Map<String, Double> distribution = calculatePublicationDistribution(pubs);
        String year = "2007";
        double ratioByYear = calculatePublicationRatioByYear(pubs, year);
        
        	
        System.out.println("=== 평균 가격 ===");
        for (String type : avgPrice.keySet()) {
            System.out.printf("%s: %.2f원%n", type, avgPrice.get(type));
        }

        System.out.println("\n=== 출판물 비율 ===");
        for (String type : distribution.keySet()) {
            System.out.printf("%s: %.2f%%%n", type, distribution.get(type));
        }
        
        System.out.println("\n=== " + year + "년도에 출판된 출판물 비율 ===");
        System.out.printf("%s년도 : %.2f%%", year, ratioByYear);
	}
}
