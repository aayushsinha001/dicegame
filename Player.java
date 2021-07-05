package gamedice;

public class Player {
    private int playerNumber;
    private int playerRank;
    private int playerPoint;
    private boolean skipTurnFlag;
    private int lastDiceValue;
    private boolean playerStatusActive;

    public Player(int playerNumber, int playerRank, int playerPoint, boolean skipTurnFlag, int lastDiceValue, boolean playerStatusActive) {
        this.playerNumber = playerNumber;
        this.playerRank = playerRank;
        this.playerPoint = playerPoint;
        this.skipTurnFlag = skipTurnFlag;
        this.lastDiceValue = lastDiceValue;
        this.playerStatusActive = playerStatusActive;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    public int getPlayerRank() {
        return playerRank;
    }

    public void setPlayerRank(int playerRank) {
        this.playerRank = playerRank;
    }

    public int getPlayerPoint() {
        return playerPoint;
    }

    public void setPlayerPoint(int playerPoint) {
        this.playerPoint = playerPoint;
    }

    public boolean isSkipTurnFlag() {
        return skipTurnFlag;
    }

    public void setSkipTurnFlag(boolean skipTurnFlag) {
        this.skipTurnFlag = skipTurnFlag;
    }

    public int getLastDiceValue() {
        return lastDiceValue;
    }

    public void setLastDiceValue(int lastDiceValue) {
        this.lastDiceValue = lastDiceValue;
    }

    public boolean isPlayerStatusActive() {
        return playerStatusActive;
    }

    public void setPlayerStatusActive(boolean playerStatusActive) {
        this.playerStatusActive = playerStatusActive;
    }
}
