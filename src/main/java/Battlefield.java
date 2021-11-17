import java.util.HashMap;

public class Battlefield {
    public static final int MIN_INDEX = 0;
    public static final int MAX_INDEX = 9;
    private HashMap<String, Object> haloHashMap = new HashMap<>();
    private HashMap<String, Object> shipsHashMap = new HashMap<>();
    private Player player;

    public Battlefield(Player player) {
        this.player = player;
    }

    public HashMap<String, Object> getHaloHashMap() {
        return haloHashMap;
    }

    public HashMap<String, Object> getShipsHashMap() {
        return shipsHashMap;
    }
}
