public class Player {
    private String name;
    private Battlefield myBattlefild;

    public Player(String name) {
        this.name = name;
        myBattlefild = new Battlefield(this);
    }

    public Battlefield getMyBattlefild() {
        return myBattlefild;
    }

    public void generateBattlefield() {
        Ship.generateShip(4, getMyBattlefild());
        Ship.generateShip(3, getMyBattlefild());
        Ship.generateShip(3, getMyBattlefild());
        Ship.generateShip(2, getMyBattlefild());
        Ship.generateShip(2, getMyBattlefild());
        Ship.generateShip(2, getMyBattlefild());
        Ship.generateShip(1, getMyBattlefild());
        Ship.generateShip(1, getMyBattlefild());
        Ship.generateShip(1, getMyBattlefild());
        Ship.generateShip(1, getMyBattlefild());
    }
}
