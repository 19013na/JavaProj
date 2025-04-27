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
	
	// ��ٱ��� �߰�
	public void addItem(Publication item) {
		items.add(item);
		System.out.println("���� " + item.getTitle() + "�� ��ٱ��Ͽ� �߰��Ǿ����ϴ�.");
	}
	
	// ��ٱ��� ����
	public boolean removeItem(String title) {
		for(Publication item : items) {
			if(item.getTitle().equals(title)) {
				items.remove(item);
				return true;
			}
		}
		return false;
	}
	
	// ��ٱ��� ���
	public void displayCart() {
		for(Publication item : items) {
			System.out.println(item.getTitle());
		}
		calculateTotalPrice();
		calculateDiscountedPrice();
	}
	
	// �� ���� ���
	public int calculateTotalPrice() {
		int totalPrice = 0;
		for(Publication item : items) {
			totalPrice += item.getPrice();
		}
		return totalPrice;
	}
	
	// ���ε� �� ���� ���
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
	
	// ���
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
				System.out.println("-�Ҽ� : " + count + "��");
			if(type.equals("Magazine"))
				System.out.println("-���� : " + count + "��");
			if(type.equals("ReferenceBook"))
				System.out.println("-���� : " + count + "��");
		}
		
	}
	
	
}
