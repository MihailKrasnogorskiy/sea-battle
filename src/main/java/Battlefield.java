import java.util.HashMap;

public class Battlefield {
    public static final int MIN_INDEX = 0;
    public static final int MAX_INDEX = 9;
    private HashMap<String, Halo> haloHashMap = new HashMap<>();
    private HashMap<String, Ship> shipsHashMap = new HashMap<>();
    private String[][] printBattlefield = new String[MAX_INDEX + 1][MAX_INDEX + 1];

    public Battlefield() {
        for (int i = 0; i < printBattlefield.length; i++) {
            for (int j = 0; j < printBattlefield.length; j++) {
                printBattlefield[i][j] = "\u2B1C";
            }
        }
    }

    public HashMap<String, Halo> getHaloHashMap() {
        return haloHashMap;
    }

    public HashMap<String, Ship> getShipsHashMap() {
        return shipsHashMap;
    }

    public String[][] getPrintBattlefield() {
        return printBattlefield;
    }

    public void print() {
        for (int i = 0; i < this.printBattlefield.length; i++) {
            for (int j = 0; j < this.printBattlefield.length; j++) {
                System.out.print(getPrintBattlefield()[i][j] + " ");
            }
            System.out.println();
        }
    }
}
