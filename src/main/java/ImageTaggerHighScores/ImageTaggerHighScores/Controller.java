package ImageTaggerHighScores.ImageTaggerHighScores;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
	String filename;
    List<HighScore> highScores;
    
    public Controller() {
    	filename = "highScores.ser";
    	highScores = new ArrayList<HighScore>();
    	highScores.add(new HighScore("a", 1, "c", 1));
    	highScores.add(new HighScore("a", 1, "c", 1));
    	highScores.add(new HighScore("a", 1, "c", 1));
    	highScores.add(new HighScore("a", 1, "c", 1));
	}

	@RequestMapping("/highscore")
    public List<HighScore> greeting(@RequestParam(value="name", defaultValue="World") String name) throws IOException, ClassNotFoundException {
		
        FileInputStream file = new FileInputStream(filename); 
        ObjectInputStream in = new ObjectInputStream(file);
        highScores = (List<HighScore>)in.readObject(); 
        in.close(); 
        file.close(); 
        
        return highScores;
    }
	@PostMapping(path = "/highscore", consumes = "application/json", produces = "application/json")
	public void addHighScore(@RequestBody HighScore hs) {
		
		highScores.add(hs);
		
		try {
			FileOutputStream file = new FileOutputStream(filename); 
			ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(highScores); 
            out.close(); 
            file.close(); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
    
}
