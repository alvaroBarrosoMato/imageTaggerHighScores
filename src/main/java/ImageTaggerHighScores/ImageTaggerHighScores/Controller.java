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
    HighScores highScores;
    
    
    public Controller() {
    	filename = "highScores.ser";
    	highScores.highScores = new ArrayList<HighScore>();
    	
	}

	@RequestMapping("/highscore")
    public HighScores greeting() throws IOException, ClassNotFoundException {
		
        FileInputStream file = new FileInputStream(filename); 
        ObjectInputStream in = new ObjectInputStream(file);
        highScores.highScores = (List<HighScore>)in.readObject(); 
        in.close(); 
        file.close(); 
        
        return highScores;
    }
	@PostMapping(path = "/highscore", consumes = "application/json", produces = "application/json")
	public void addHighScore(@RequestBody HighScore hs) {
		
		highScores.highScores.add(hs);
		
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
