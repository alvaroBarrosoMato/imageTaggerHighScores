package ImageTaggerHighScores.ImageTaggerHighScores;

import java.io.Serializable;
import java.util.List;

public class HighScores implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public List<HighScore> highScores;

	public HighScores(List<HighScore> highScores) {
		super();
		this.highScores = highScores;
	}

	public HighScores() {
	}
	
}
