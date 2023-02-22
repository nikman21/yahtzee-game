import java.util.Random;

public class Die {
    private int sides;
    private int value;
    private Random random = new Random();
    private boolean isHeld;

    // default constructor for 6-sided die
    public Die() {
        this.sides = 6;
        this.value = random.nextInt(sides) + 1;
        this.isHeld = false;
    }

    // parameterized constructor for any sided die
    public Die(int sides) {
        this.sides = sides;
        this.value = random.nextInt(sides) + 1;
        this.isHeld = false;
    }

    // method to roll the die
    public void roll() {
        if(!isHeld) {
        	this.value = random.nextInt(sides) + 1;
        }
    }

    // method to read the current value of the die
    public int read() {
        return value;
    }
    // method to hold
    public void hold() {
        this.isHeld = true;
    }
    // method to release the die
    public void release() {
        isHeld = false;
    }
    public boolean isHeld() {
    	return this.isHeld;
    }
}