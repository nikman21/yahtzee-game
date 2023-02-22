import java.util.Scanner;
import java.util.ArrayList;

public class Game {
  
  private int numPlayers;
  private ArrayList<Player> players;
  private DiceCup diceCup;
  private Scanner input;
  
  public Game() {
    input = new Scanner(System.in);
    diceCup = new DiceCup();
    players = new ArrayList<>();
  }
  
  public void startGame() {
    System.out.println("Welcome to Yahtzee!");
    System.out.println("How many players are there? (1-6)");
    numPlayers = input.nextInt();
    input.nextLine(); // to consume the new line character
    
    for (int i = 1; i <= numPlayers; i++) {
      System.out.println("Enter player " + i + " name: ");
      String name = input.nextLine();
      Player player = new Player(name);
      players.add(player);
    }
    
    // Game play
    for (int i = 0; i < 13; i++) {
      System.out.println("\nRound " + (i + 1));
      playRound();
    }
    
    // End game and display scores
    System.out.println("\nYahtzee Game Over!");
    System.out.println("Final Scores:");
    
    for (Player player : players) {
      player.displayScore();
    }
  }
  
  private void playRound() {
	  for (Player player : players) {
	    System.out.println("\n" + player.getName() + "'s turn");
	    int throwCount = 0;
	    while (throwCount < 3) {
	      System.out.println("Throw " + (throwCount + 1));
	      diceCup.rollDice();
	      diceCup.displayDice();
	      System.out.println("Which dice do you want to hold? (Enter index separated by space)");
	      String hold = input.nextLine();
	      diceCup.holdDice(hold);
	      throwCount++;
	    }
	    // Show options for scoring
	    System.out.println("\n" + player.getName() + ", Choose a category to score points:");
	    player.getScoreSheet().displayScoreOptions();
	    int choice = input.nextInt();
	    input.nextLine(); // added line to consume the new line character
	    String category = player.getScoreSheet().getCategory(choice);
	    int[] diceValues = diceCup.getDiceValues();
	    int score = player.getScoreSheet().calculateScore(category, diceValues);
	    player.updateScore(score, category);
	    player.displayScore();
	    diceCup.reset();
	  }
	}
}