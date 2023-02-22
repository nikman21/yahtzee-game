import java.util.ArrayList;

public class DiceCup {
    // an ArrayList to store the dice
    private ArrayList<Die> dice;

    // constructor that takes in the number of dice and initializes the DiceCup
    public DiceCup(int numOfDice) {
        // create an ArrayList to store the dice and add the specified number of dice
        this.dice = new ArrayList<Die>();
        for (int i = 0; i < numOfDice; i++) {
            dice.add(new Die());
        }
    }
    
    public DiceCup() {
        this(5); // default number of dice is 5
    }

    // method to get the ArrayList of dice
    public ArrayList<Die> getDice() {
        return dice;
    }
    // method to get the values of the dice in the ArrayList
    public int[] getDiceValues() {
        int[] diceValues = new int[dice.size()];
        for (int i = 0; i < dice.size(); i++) {
            diceValues[i] = dice.get(i).read();
        }
        return diceValues;
    }

    // method to roll all the dice in the ArrayList
    public void rollDice() {
        for (Die die : dice) {
            die.roll();
        }
    }
    public void holdDice(String diceToHold) {
        String[] diceIndexes = diceToHold.split(" ");
        for (String index : diceIndexes) {
            try {
                int dieIndex = Integer.parseInt(index) - 1;
                if (dieIndex >= 0 && dieIndex < dice.size()) {
                    dice.get(dieIndex).hold();
                } else {
                    System.out.println("Invalid die index: " + index);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input: " + index);
            }
        }
    }


    public void reset() {
        for (Die die : dice) {
            die.release();
        }
    }
    public void displayDice() {
        System.out.print("Dice: ");
        for (Die die : dice) {
            System.out.print(die.read() + " ");
        }
        System.out.println();
    }
}