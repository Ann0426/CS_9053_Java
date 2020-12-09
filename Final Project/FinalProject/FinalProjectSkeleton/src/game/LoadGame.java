package game;

public class LoadGame {
	String loadname;
	int score_id;
	public LoadGame() {
		this.loadname = "ann";
		this.score_id = 0;
		
	}
	public LoadGame(String loadname,int score_id) {
		this.loadname = loadname;
		this.score_id = score_id;
		
	}
	public String getLoadname() {
		return loadname;
	}
	public void setLoadname(String loadname) {
		this.loadname = loadname;
	}
	public int getScore_id() {
		return score_id;
	}
	public void setScore_id(int score_id) {
		this.score_id = score_id;
	}
}
