import java.util.Map;
import java.util.HashMap;

public class Player {
  
  private String name;
  private int score;
  private ScoreSheet scoreSheet;
  private Map<String, Integer> scores = new HashMap<>();
  
  // constructor with name parameter
  public Player(String name) {
    this.name = name;
    this.score = 0;
    this.scoreSheet = new ScoreSheet();
    
  }
  
  // getters and setters
  public String getName() {
    return name;
  }
  
  public int getScore() {
    return score;
  }
  
  public void setScore(int score) {
    this.score = score;
  }
  
  public ScoreSheet getScoreSheet() {
    return scoreSheet;
  }
  
  // method to update player's score
  public void updateScore(int score, String category) {
	  this.scores.put(category, score);
	  this.score += score;
	}
  
  //method to reset player's score
  public void resetScore() {
    this.score = 0;
    this.scoreSheet.resetScoreSheet();
    scores.clear();
  }
  
  //method to display player's score
  public void displayScore() {
	  System.out.println("Name: " + name);
	  if (!scores.isEmpty()) {
	    for (Map.Entry<String, Integer> entry : scores.entrySet()) {
	      System.out.println(entry.getKey() + ": " + entry.getValue());
	    }
	  } else {
	    System.out.println("No scores recorded yet.");
	  }
	}
}