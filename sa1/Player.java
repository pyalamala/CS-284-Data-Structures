package sa1;
//Pranav Yalamala
//I pledge my honor that I have abided by the Steven's Honors System.
import java.util.*;

public class Player {

	private static class Node<F> {
		private F data;
		private Node<F> next;
		
		public Node(F data, Node<F> next) {
			super();
			this.data = data;
			this.next = next;
		}
		
		public Node(F data) {
			super();
			this.data = data;
		}
	}
	
	private Node<Song> currentSong;	//The currently playing / first song in the queue
	private Node<Song> lastSong;	//The last song in the queue
	private int playQueueSize;		//The total amount of songs in the play queue
	private int totalRunTime;		//The amount of time the player has played; intended to only go up

	public Player() {
		currentSong = null;
		lastSong = null;
		playQueueSize = 0;
		totalRunTime = 0;
	}
	
	public Player(Playlist plist) {
		if(plist.getSize() == 0){
			throw new IllegalArgumentException("Error: playlist is empty");
		}
		else if(plist.getSize() ==1){
			currentSong = new Node<Song>(plist.getAt(0));
			lastSong = currentSong;
			playQueueSize = 1;
		}
		else{
			currentSong= new Node<Song>(plist.getAt(0));
			lastSong= new Node<Song>(plist.getAt(plist.getSize() - 1));
			playQueueSize = plist.getSize();
			totalRunTime = plist.getAt(0).getRunTime();

			Node<Song> prev = currentSong;

			int i = 1;
			while(i < playQueueSize - 1){
				Node<Song> link = new Node<Song>(plist.getAt(i));
				prev.next = link;
				prev = link;
				i += 1;
			}
			prev.next = lastSong;
		}
	}
	
	public int getTotalRuntime() {
		return totalRunTime;
	}
	
	public int getPlayQueueSize() {
		return playQueueSize;
	}
	
	public Song getCurrentSong() {
		if(currentSong.data == null){
			throw new IllegalArgumentException("Error: no song currently palying");
		}
		else{
			return currentSong.data;
		}
	}

	public ArrayList<Song> getAllSongs(){
		if(playQueueSize == 0){
			throw new IllegalArgumentException("Error: no songs in queue");
		}
		else{
			ArrayList<Song> songs = new ArrayList<>();
			Node<Song> current = currentSong;
			int i = 0;
			while(i < playQueueSize){
				songs.add(current.data);
				current = current.next;
				i += 1;
			}
			return songs;

		}
	}
	
	public int getRemainingRunTime() {
		if(playQueueSize == 0){
			throw new IllegalArgumentException("Error: no songs in queue");
		}
		else if(currentSong.equals(lastSong)) {
			return 0;
		}
		else{
			int remainingRunTime = 0;
			Node<Song> nextSong = currentSong.next;
			while(nextSong != null){
				remainingRunTime += nextSong.data.getRunTime();
				nextSong = nextSong.next;
			}
			return remainingRunTime;
		}
	}
	
	public void playNextSong() {
		if(currentSong == null){
			throw new IllegalArgumentException("Error: no song currently playing");

		}
		else{
			if(currentSong.next != null){
				totalRunTime += currentSong.next.data.getRunTime();
				currentSong = currentSong.next;
				playQueueSize -= 1;
			}
			
		}
	}
	
	public void clearQueue() {
		currentSong = null;
		lastSong = null;
		playQueueSize = 0;
	}
	
	public void addSong(Song song) {
		if(currentSong == null){
			Node<Song> temp = new Node<Song>(song);
			currentSong= temp;
			lastSong = temp;
			playQueueSize = 1;
			totalRunTime += song.getRunTime();
		}
		else{
			Node<Song> last = new Node<Song>(song);
			lastSong.next = last;
			lastSong = last;
			playQueueSize += 1;
		}
	}

	public static void main(String[] args){

		Song s = new Song("Highway to Hell", "AC /", "DC", 207);
	

		Song s2 = new Song("Stairway to Heaven", "Led", "Zepplin", 482);
		Playlist p = new Playlist(s);

		p.addSong(s2);

	

		Player y = new Player(p);
		System.out.println(y.getCurrentSong());
		System.out.println("Total runtime: " + y.getTotalRuntime());
		System.out.println("Remaining runtime: " + y.getRemainingRunTime());

		
		y.addSong(s2);
		System.out.println(y.getAllSongs());
		System.out.println("Total runtime: " + y.getTotalRuntime());
		System.out.println("Remaining runtime: " + y.getRemainingRunTime());

		y.playNextSong();
		System.out.println(y.getCurrentSong());
		System.out.println(y.getAllSongs());
		System.out.println("Total runtime: " + y.getTotalRuntime());
		System.out.println("Remaining runtime: " + y.getRemainingRunTime());
		
		y.playNextSong();
		System.out.println(y.getCurrentSong());
		System.out.println(y.getAllSongs());
		System.out.println("Total runtime: " + y.getTotalRuntime());
		System.out.println("Remaining runtime: " + y.getRemainingRunTime());

		y.playNextSong();

		


	}
}
