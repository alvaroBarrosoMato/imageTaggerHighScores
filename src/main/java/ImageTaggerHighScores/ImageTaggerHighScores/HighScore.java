package ImageTaggerHighScores.ImageTaggerHighScores;

import java.io.Serializable;
import java.util.List;

public class HighScore implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String name;
	public int Points;
	public String Date;
	public int Cortes;
	public long id;
	public HighScore(String name, int points, String date, int cortes) {
		super();
		this.name = name;
		Points = points;
		Date = date;
		Cortes = cortes;
	}
	public HighScore(long incrementAndGet) {
		id = incrementAndGet;
	}
	public String toTable() {
		return "<tr>\n" + 
				"    <td>" + name + "</td>\n" + 
				"    <td> " + Points + "</td>\n" + 
				"    <td>\" + Date + \"</td>\n" + 
				"    <td>\" + Cortes + \"</td>\n" + 
				"  </tr>";
	}
	
}

