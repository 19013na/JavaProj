package lab.music.entity;

public abstract class MusicMedia {
	private String title;
	private String artist;
	
	public MusicMedia(String title, String artist) {
		this.title = title;
		this.artist = artist;
	}
	
	public String getTitle() {
		return title;
	}
	
	public abstract void play();
	
	public void displayInfo() {
		System.out.println("����: " + title + ", ��Ƽ��Ʈ: " + artist);
	}
}	
