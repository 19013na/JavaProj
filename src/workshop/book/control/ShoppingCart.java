package workshop.book.control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import workshop.book.entity.Publication;

public class ShoppingCart {
	
	public List<Publication> items;
	
	public ShoppingCart() {
		items = new ArrayList<>();
	}
	
	// 장바구니 추가
	public void addItem(Publication item) {
		items.add(item);
		System.out.println("도서 " + item.getTitle() + "이 장바구니에 추가되었습니다.");
	}
	
	// 장바구니 제거
	public boolean removeItem(String title) {
		for(Publication item : items) {
			if(item.getTitle().equals(title)) {
				items.remove(item);
				return true;
			}
		}
		return false;
	}
	
	// 장바구니 출력
	public void displayCart() {
		for(Publication item : items) {
			System.out.println(item.getTitle());
		}
		calculateTotalPrice();
		calculateDiscountedPrice();
	}
	
	// 총 가격 계산
	public int calculateTotalPrice() {
		int totalPrice = 0;
		for(Publication item : items) {
			totalPrice += item.getPrice();
		}
		return totalPrice;
	}
	
	// 할인된 총 가격 계산
	public int calculateDiscountedPrice() {
		for(Publication item : items) {
			ManageBook.modifyPrice(item);
		}
		
		int totalPrice = 0;
		for (Publication item : items) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
	}
	
	// 통계
	public void printStatistics() {
		Map<String, Integer> typeCount = new HashMap<>();
		
		for(Publication item : items) {
			String type = item.getClass().getSimpleName();
			typeCount.put(type, typeCount.getOrDefault(type, 0) + 1);
		}
		
		for(Map.Entry<String, Integer> entry : typeCount.entrySet()) {
			String type = entry.getKey();
			int count = entry.getValue();
			if(type.equals("Novel"))
				System.out.println("-소설 : " + count + "개");
			if(type.equals("Magazine"))
				System.out.println("-잡지 : " + count + "개");
			if(type.equals("ReferenceBook"))
				System.out.println("-참고서 : " + count + "개");
		}
		
	}
	
	
}
