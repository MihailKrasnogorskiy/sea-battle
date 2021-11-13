import java.util.HashMap;

public class Halo {
    private int[] haloCoordinates;
    private Ship ship;
    private static HashMap<int[], Halo> haloHashMap;

    public static HashMap<int[], Halo> getHaloHashMap() {
        return haloHashMap;
    }

    public Halo(Ship ship, int[] haloCoordinates) {
        this.ship = ship;
        this.haloCoordinates = haloCoordinates;
    }

}
