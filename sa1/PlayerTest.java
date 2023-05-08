package sa1;

import java.util.*;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    public static void testSong(){
        Song s = new Song("Highway to Hell", "AC /", "DC", 207);
        assertEquals(s.toString(), "Highway to Hell, by AC / DC, runtime 207 seconds.");

    }

    public static void testPlaylist(){
        Song s = new Song("Highway to Hell", "AC /", "DC", 207);
		Song s2 = new Song("Stairway to Heaven", "Led", "Zepplin", 482);
		Playlist p = new Playlist();

		p.addSong(s);
		p.addSong(s2);

        assertEquals(p.toString(), "[Highway to Hell, by AC / DC, runtime 207 seconds.\nStairway to Heaven, by Led Zepplin, runtime 482 seconds.]");
        assertEquals(p.totalRunTime(), 689);
    }

    public static void testPlayer(){
        Song s = new Song("Highway to Hell", "AC /", "DC", 207);
	

		Song s2 = new Song("Stairway to Heaven", "Led", "Zepplin", 482);
		Playlist p = new Playlist();

		p.addSong(s);
		p.addSong(s2);

		Player y = new Player(p);
        assertEquals(y.getCurrentSong(), s);
        assertEquals(y.getAllSongs().toString(), "[Highway to Hell, by AC / DC, runtime 207 seconds., Stairway to Heaven, by Led Zepplin, runtime 482 seconds.]");
        assertEquals(y.getTotalRuntime(), 207);
        assertEquals(y.getRemainingRunTime(), 482);

        y.playNextSong();
        assertEquals(y.getCurrentSong(), s2);
        assertEquals(y.getAllSongs().toString(), "[Stairway to Heaven, by Led Zepplin, runtime 482 seconds.]");
        assertEquals(y.getTotalRuntime(), 689);
        assertEquals(y.getRemainingRunTime(), 0);
        
        y.clearQueue();
        y.addSong(s);
        assertEquals(y.getCurrentSong(), s);
        assertEquals(y.getAllSongs().toString(),"[Highway to Hell, by AC / DC, runtime 207 seconds.]");
        assertEquals(y.getTotalRuntime(), 896);
        assertEquals(y.getRemainingRunTime(), 0);

        y.addSong(s2);
        assertEquals(y.getCurrentSong(), s);
        assertEquals(y.getAllSongs().toString(), "[Highway to Hell, by AC / DC, runtime 207 seconds., Stairway to Heaven, by Led Zepplin, runtime 482 seconds.]");
        assertEquals(y.getTotalRuntime(), 896);
        assertEquals(y.getRemainingRunTime(), 482);

    }

    
    public static void main(String[] args){
        testSong();
        testPlaylist();
        testPlayer();
    }


}
