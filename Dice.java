package gamedice;

import java.util.Random;

public class Dice {
    int diceValue;

    public int rollDice() {
        Random random = new Random();
        diceValue = random.nextInt(6) + 1;
        return diceValue;
    }
}
