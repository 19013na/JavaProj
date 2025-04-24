package workshop.animal.entity;

public class Spider extends Animal {

	public Spider(int legs) {
		super(8);
	}

	@Override
	public void eat() {
		System.out.println("SpiderÀº ÀÛÀº ¹ú·¹¸¦ ¸Ô¾î¿ä");
	}
}
