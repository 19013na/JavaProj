package lab.music.control;

import lab.music.entity.MP3;
import lab.music.entity.MusicMedia;
import lab.music.entity.Playable;
import lab.music.entity.Vinyl;

public class MusicPlayerTest {
	public static void main(String[] args) {
		
		MusicMedia media1 = new MP3("Dynamite", "BTS", 5);
		MusicMedia media2 = new Vinyl("Yesterday", "The Beatles", 33);
		MusicMedia media3 = new MP3("Butter", "BTS", 4);
		
		System.out.println("==== ���� ��� �ý��� �׽�Ʈ ====");
		System.out.println("\n--- MP3 �׽�Ʈ ---");
		media1.displayInfo();
		media1.play();
		
		mp3SetVolume(media1, 8);
		media1.play();
		mp3Stop(media1);
		
		System.out.println("\n---Vinyl �׽�Ʈ---");
		media2.displayInfo();
		media2.play();
		((Vinyl) media2).clean();
		
		System.out.println("\n---������ �׽�Ʈ---");
		media3.displayInfo();
		media3.play();
		
		System.out.println("\n---ĳ���� �׽�Ʈ---");
		mp3SetVolume(media3, 3);
		media3.play();
		mp3SetVolume(media3, 7);
		mp3Stop(media3);
	}
	
	private static void mp3SetVolume(MusicMedia media, int volume) {
		if (media instanceof Playable) {
		    ((Playable) media).setVolume(volume);
		}
	}
	
	private static void mp3Stop(MusicMedia media) {
		if (media instanceof Playable) {
		    ((Playable) media).stop();
		}
	}
}
