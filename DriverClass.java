package gamedice;

public class DriverClass {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        System.out.println(" *********************** Staring Game of Dice *********** ");
        System.out.println(String.format("Number of Players : %d    Minimum Number of Points : %d", n, m));
        GameDice gameDice = new GameDice(n ,m);
        gameDice.initGame();
    }
}
