package sa1;
//Pranav Yalamala
//I pledge my honor that I have abided by the Steven's Honor System
public class Playlist{
	
	private SLL<Song> songs;
	
	public Playlist(){
		songs = new SLL<>();
	}
	
	public Playlist(Song song){
		songs = new SLL<>();
		songs.addFirst(song);	
	}
	
	public int getSize() {
		return songs.getSize();
	}
	
	public Song getAt(int index) {
		if(index >= songs.getSize()){
			throw new IllegalArgumentException("Error: index out of bounds");
		}
		else{
			return songs.getAt(index);
		}
	}
	
	public void addSong(Song song) {
		songs.add(song, songs.getSize());
	}
	
	public int totalRunTime() {
		if (songs.getSize() == 0){
			throw new IllegalArgumentException("Error: no songs in playlist");
		}
		else{
			int totalRunTime = 0;
			for(int i = 0; i < songs.getSize(); i++){
				totalRunTime += songs.getAt(i).getRunTime();
			}
			return totalRunTime;
		}
	}
	
	public Song longestSong() {
		if (songs.getSize() == 0){
			throw new IllegalArgumentException("Error: no songs in playlist");
		}
		else{
			Song longestSong = songs.getAt(0);
			for(int i = 1; i < songs.getSize(); i++){
				if(songs.getAt(i).getRunTime() > longestSong.getRunTime()){
					longestSong = songs.getAt(i);
				}
			}
			return longestSong;
		}
	}
	
	
	public String toString() {
		return songs.toString();
	}
}
