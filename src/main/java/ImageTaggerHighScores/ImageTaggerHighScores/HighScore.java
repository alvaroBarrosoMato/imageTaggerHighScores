package ImageTaggerHighScores.ImageTaggerHighScores;

import java.io.Serializable;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
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
	public String mac;
	
	public HighScore(String name, int points, String date, int cortes, String Mac) {
		super();
		this.name = name;
		Points = points;
		Date = date;
		Cortes = cortes;
		mac = Mac;
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
