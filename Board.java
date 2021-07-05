package gamedice;

import java.util.Map;
import java.util.Scanner;

public class Board {
    private Map<Integer, Player> playersMap;
    private int currentMaxRank;
    int numberOfPlayers;
    int minimumScoreRequired;
    Dice dice;

    public Board(int numberOfPlayers, int minimumScoreRequired, Map<Integer, Player> playersMap) {
        this.numberOfPlayers = numberOfPlayers;
        this.minimumScoreRequired = minimumScoreRequired;
        this.playersMap = playersMap;
        dice = new Dice();
        currentMaxRank = 0;
    }

    private void makeMoveForPlayer(int playerNumber, int diceValue) {
       if(playerNumber >= 1 && playerNumber <= numberOfPlayers) {
           if(playersMap.get(playerNumber).isPlayerStatusActive()) {
               int point = playersMap.get(playerNumber).getPlayerPoint();
               if(point + diceValue >= minimumScoreRequired) {
                   System.out.println(String.format("Congratulations Player %d, you have won. You current score is %d and rank is %d ", playerNumber, (point + diceValue), ++currentMaxRank));
                   playersMap.get(playerNumber).setPlayerRank(currentMaxRank);
                   playersMap.get(playerNumber).setPlayerStatusActive(false);
               }
               playersMap.get(playerNumber).setPlayerPoint(point + diceValue);
               playersMap.get(playerNumber).setLastDiceValue(diceValue);
           }
       }
       else {
           System.out.println("Invalid Player number " + playerNumber);
           System.exit(-1);
       }
    }

    private boolean isGameValid() {
        return currentMaxRank == numberOfPlayers ? false : true;
    }

    public void startGame() {
        while(isGameValid()) {
            for(int i = 1; i<= numberOfPlayers; i++) {
                    if(playersMap.get(i).isPlayerStatusActive() && playersMap.get(i).isSkipTurnFlag()) {
                        System.out.println(String.format("Skipping Player %d Turn due to penalty of two consecutive 1s", i));
                        playersMap.get(i).setSkipTurnFlag(false);
                        playersMap.get(i).setLastDiceValue(0);
                    }
                    if(playersMap.get(i).isPlayerStatusActive()) {
                        System.out.println(String.format("Player %d, it is your Turn. Press r to roll the dice", i));
                        if(getUserInput()) {
                            int diceValue = dice.rollDice();
                            System.out.println(String.format("Player %d, your dice roll value : %d ", i, diceValue));
                            checkConsecutiveOnePenality(diceValue, i);
                            if(diceValue == 6) {
                                System.out.println(String.format("Player %d You got a 6. You will be given another turn", i));
                                makeMoveForPlayer(i, diceValue);
                                i--;
                            }
                            else makeMoveForPlayer(i, diceValue);
                            displayPointsTable();
                        }
                    }
                    else if(!playersMap.get(i).isPlayerStatusActive()) continue;
            }
        }
        if(!isGameValid()) {
            System.out.println("************* Game Over ! **************");
            displayPointsTable();
        }
    }

    private void displayPointsTable() {
        System.out.println("*********** Points Table ****************");
        for(Map.Entry<Integer, Player> entry : playersMap.entrySet()) {
            System.out.println(String.format("Player %d | Points %d | Rank %d |", entry.getKey(), entry.getValue().getPlayerPoint(), entry.getValue().getPlayerRank()));
        }
        System.out.println("******************************************");
    }

    private boolean getUserInput() {
        Scanner sc = new Scanner(System.in);
        char ch;
        while(true) {
            ch = sc.next().charAt(0);
            if(ch != 'r') {
                System.out.println("Invalid User input Please press r to roll the dice");
            }
            if(ch == 'r')
                break;
        }
        return (ch == 'r');
    }

    private boolean checkConsecutiveOnePenality(int diceValue, int playerNumber) {
        if(diceValue == 1) {
            if(playersMap.get(playerNumber).getLastDiceValue() == 1) {
                System.out.println(String.format("Player %d You are penalized for getting two consecutive 1. You will be forced to skip the next turn"));
                playersMap.get(playerNumber).setLastDiceValue(diceValue);
                playersMap.get(playerNumber).setSkipTurnFlag(true);
                return true;
            }
        }
        return false;
    }
}
