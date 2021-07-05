package gamedice;

import java.util.HashMap;
import java.util.Map;

public class GameDice {
    Board b;
    int n;
    int m;
    Map<Integer, Player> playerMap;

    public GameDice(int n, int m) {
        this.n = n;
        this.m = m;
        generatePlayers();
    }

    private void generatePlayers() {
        playerMap = new HashMap<Integer, Player>();
        for(int i=1; i<=n; i++) {
            Player player = new Player(i, 0, 0, false, 0, true);
            playerMap.put(i, player);
        }
    }

    public void initGame() {
        b = new Board(n, m, playerMap);
        b.startGame();
    }
}
