package sa1;
//Pranav Yalamala
//I pledge my honor that I have abided by the Steven's Honors System.
public class Song {
	
	private String name;			//Name of the song
	private String artistFirstName;	//Artist's first name
	private String artistLastName;	//Artist's last name
	private int runTime;			//Run time of the song in seconds
	
	public Song(String name, String artistFirstName, String artistLastName, int runTime) {
		if(name.equals("")){
			throw new IllegalArgumentException("Error: name is empty");
		}
		else if(artistFirstName.equals("")){
			throw new IllegalArgumentException("Error: artistFirstName is empty");
		}
		else if(artistLastName.equals("")){
			throw new IllegalArgumentException("Error: artistLastName is empty");
		}
		else if(runTime <= 0){
			throw new IllegalArgumentException("Error: runtime is invalid");
		}
		else{
		this.name = name;
		this.artistFirstName = artistFirstName;
		this.artistLastName = artistLastName;
		this.runTime = runTime;
		}
	}

	public String getName() {
		return name;
	}

	public String getArtistFirstName() {
		return artistFirstName;
	}

	public String getArtistLastName() {
		return artistLastName;
	}
	
	public int getRunTime() {
		return runTime;
	}
	
	public String toString() {
		return this.name + ", by " + this.artistFirstName + " " + this.artistLastName + ", runtime " + this.runTime + " seconds.";
	}
}
