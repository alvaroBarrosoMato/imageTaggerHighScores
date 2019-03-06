package ImageTaggerHighScores.ImageTaggerHighScores;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    
    List<HighScore> highScores;
    
    public Controller() {
    	highScores = new ArrayList<HighScore>();
    	highScores.add(new HighScore("a", 1, "c", 1));
    	highScores.add(new HighScore("a", 1, "c", 1));
    	highScores.add(new HighScore("a", 1, "c", 1));
    	highScores.add(new HighScore("a", 1, "c", 1));
	}

	@RequestMapping("/highscore")
    public List<HighScore> greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return highScores;
    }
	@PostMapping(path = "/highscore", consumes = "application/json", produces = "application/json")
	public void addHighScore(@RequestBody HighScore hs) {
		highScores.add(hs);
	}
    
}
