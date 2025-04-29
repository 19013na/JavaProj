package lab.music.entity;

public class DigitalMedia extends MusicMedia {

	private String format;
	
	public DigitalMedia(String title, String artist, String format) {
		super(title, artist);
		this.format = format;
	}
	
	public DigitalMedia(String title, String artist) {
		super(title, artist);
	}
	
	@Override
	public void play() {
		System.out.println(format + " ������ '" + getTitle() + "'��(��) �����з� ����˴ϴ�.");
	}

	@Override
	public void displayInfo() {
		super.displayInfo();
		System.out.println("����: " + format);
	}
}
