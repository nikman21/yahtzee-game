import java.util.HashMap;

public class ScoreSheet {
	// HashMap to store the score for each category
    private HashMap<String, Integer> scores;
    private final String[] categories = new String[] {
        "Ones", "Twos", "Threes", "Fours", "Fives", "Sixes",
        "Three of a Kind", "Four of a Kind", "Full House",
        "Small Straight", "Large Straight", "Yahtzee", "Chance"
    };

    public ScoreSheet() {
        scores = new HashMap<>();
        for (String category : categories) {
            scores.put(category, 0);
        }
    }

    // Method to calculate the score for a given category
    public int calculateScore(String category, int[] dice) {
        int score = 0;
        int[] counts = new int[7];
        // switch statement to implement the scoring rules for each category
        switch (category) {
        	case "Ones":
        		// Total the number of ones rolled
        		for (int die : dice) {
        			if (die == 1) {
        				score += 1;
        				
        			}
        		}
        		break;
        	case "Twos":
        		// Total the number of twos rolled
        		for (int die : dice) {
        			if (die == 2) {
        				score += 2;
        				
        			}
        		}
        		break;
        	case "Threes":
        		// Total the number of threes rolled
        		for (int die : dice) {
        			if (die == 3) {
        				score += 3;
        			}
        		}
        		break;
        	case "Fours":
        		// Total the number of fours rolled
        		for (int die : dice) {
        			if (die == 4) {
        				score += 4;
        			}
        		}
        		break;
        	case "Fives":
        		// Total the number of fives rolled
        		for (int die : dice) {
        			if (die == 5) {
        				score += 5;
        			}
        		}
        		break;
        	case "Sixes":
        		// Total the number of sixes rolled
        		for (int die : dice) {
        			if (die == 6) {
        				score += 6;
        			}
        		}
        		break;
        	case "Three of a Kind":
        		// Total of all dice if three or more are the same
        		counts = new int[7];
        		for (int die : dice) {
        			counts[die]++;
        		}
        		for (int i = 1; i <= 6; i++) {
        			if (counts[i] >= 3) {
        				for (int die : dice) {
        					score += die;
        				}
        				break;
        			}
        		}
        		break;
        	case "Four of a Kind":
        		// Total of all dice if four or more are the same
        		counts = new int[7];
        		for (int die : dice) {
        			counts[die]++;
        		}
        		for (int i = 1; i <= 6; i++) {
        			if (counts[i] >= 4) {
        				for (int die : dice) {
        					score += die;
        				}
        				break;
        			}
        		}
        		break;
            case "Full House":
                // Create an array to store the count of each number rolled
            	counts = new int[7];
                // Count the number of occurrences of each number
                for (int die : dice) {
                    counts[die]++;
                }
                // Check if there is a three of a kind and a pair
                boolean threeOfAKind = false;
                boolean twoOfAKind = false;
                for (int i = 1; i <= 6; i++) {
                    if (counts[i] == 3) {
                        threeOfAKind = true;
                    } else if (counts[i] == 2) {
                        twoOfAKind = true;
                    }
                }
                // If both a three of a kind and a pair are found, score 25
                if (threeOfAKind && twoOfAKind) {
                    score = 25;
                    
                }
                break;
            case "Small Straight":
                // Check if the dice are in a sequential order
            	counts = new int[7];
                boolean straight = false;
                for (int i = 1; i <= 3; i++) {
                    if (counts[i] == 1 && counts[i + 1] == 1 && counts[i + 2] == 1 && counts[i + 3] == 1) {
                        straight = true;
                        break;
                    }
                }
                // If four dice are in sequential order, score 30
                if (straight) {
                    score = 30;
                }
                break;
            case "Large Straight":
                // Check if the dice are in a sequential order
            	counts = new int[7];
                straight = false;
                for (int i = 1; i <= 2; i++) {
                    if (counts[i] == 1 && counts[i + 1] == 1 && counts[i + 2] == 1 && counts[i + 3] == 1 && counts[i + 4] == 1) {
                        straight = true;
                        break;
                    }
                }
                // If five dice are in sequential order, score 40
                if (straight) {
                    score = 40;
                }
                break;
            case "Yahtzee":
                // Check if all five dice are the same
            	counts = new int[7];
            	for (int die : dice) {
            		counts[die]++;
            	   }
            	   for (int i = 1; i <= 6; i++) {
            	      if (counts[i] == 5) {
            	         score = 50;
            	         break;
            	      }
            	   }
            	   break;
            case "Chance":
                // Total of all dice
                for (int die : dice) {
                    score += die;
                }
                break;
                default:
                	System.out.println("Invalid category selected");
                	break;
        }
        scores.put(category, score);
        return score;
    }
    
	public String getCategory(int index) {
	    if (scores.isEmpty()) {
	        return "The scores map is empty";
	    } else if (index > categories.length) {
	        return "The index is out of bounds";
	    } else {
	        return categories[index-1];
	    }
	}


	// Method to reset the score sheet
    public void resetScoreSheet() {
        scores.clear();
    }
    //Displays the scoring options
    public void displayScoreOptions() {
        System.out.println("1. Ones");
        System.out.println("2. Twos");
        System.out.println("3. Threes");
        System.out.println("4. Fours");
        System.out.println("5. Fives");
        System.out.println("6. Sixes");
        System.out.println("7. Three of a Kind");
        System.out.println("8. Four of a Kind");
        System.out.println("9. Full House");
        System.out.println("10. Small Straight");
        System.out.println("11. Large Straight");
        System.out.println("12. Yahtzee");
        System.out.println("13. Chance");
    }
}

