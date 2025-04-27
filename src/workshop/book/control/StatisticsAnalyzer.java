package workshop.book.control;

import java.util.HashMap;
import java.util.Map;

import workshop.book.entity.Magazine;
import workshop.book.entity.Novel;
import workshop.book.entity.Publication;
import workshop.book.entity.ReferenceBook;

public class StatisticsAnalyzer {
	
	// Ÿ�Ժ� ��� ���� ���
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

	// ���ǹ� ���� ���� ���
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
	
	// Ư�� ���� ���� ���
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
	
	// ���ǹ� Ÿ�� Ȯ��
	private String getPublicationType(Publication pub) {
		if(pub instanceof Novel) {
			return "�Ҽ�";
		}
		if(pub instanceof Magazine) {
			return "����";
		}
		if(pub instanceof ReferenceBook) {
			return "����";
		}
		return "��Ÿ";
	}
	
	// ��� ���� ���
	public void printStatistics(Publication[] pubs) {
		Map<String, Double> avgPrice = calculateAveragePriceByType(pubs);
        Map<String, Double> distribution = calculatePublicationDistribution(pubs);
        String year = "2007";
        double ratioByYear = calculatePublicationRatioByYear(pubs, year);
        
        	
        System.out.println("=== ��� ���� ===");
        for (String type : avgPrice.keySet()) {
            System.out.printf("%s: %.2f��%n", type, avgPrice.get(type));
        }

        System.out.println("\n=== ���ǹ� ���� ===");
        for (String type : distribution.keySet()) {
            System.out.printf("%s: %.2f%%%n", type, distribution.get(type));
        }
        
        System.out.println("\n=== " + year + "�⵵�� ���ǵ� ���ǹ� ���� ===");
        System.out.printf("%s�⵵ : %.2f%%", year, ratioByYear);
	}
}
