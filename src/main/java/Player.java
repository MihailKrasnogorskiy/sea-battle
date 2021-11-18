import java.util.Scanner;

public class Player {
    private String name;
    private Battlefield myBattlefild;
    private Battlefield gameBattlefield;

    public Player() {
        this.name = name;
        myBattlefild = new Battlefield();
        gameBattlefield = new Battlefield();
    }

    public Battlefield getMyBattlefild() {
        return myBattlefild;
    }

    public Battlefield getGameBattlefield() {
        return gameBattlefield;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void generateBattlefield() {
        System.out.println(this.name + ", расставьте свои корабли");
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
        myBattlefild.print();
    }

    public boolean fight(Player player) {
        while (true) {
            System.out.println(this.name + ", ваш ход");
            int[] fightCoordinates = SeaBattle.inputCoordinates(1);
            String fight = String.valueOf(fightCoordinates[0]) + String.valueOf(fightCoordinates[1]);
            if (player.getMyBattlefild().getShipsHashMap().containsKey(fight)) {
                player.gameBattlefield.getPrintBattlefield()[fightCoordinates[0]][fightCoordinates[1]] = "\uD83D\uDD34";
                int[] shipCoordinates = player.getMyBattlefild().getShipsHashMap().get(fight).getCoordinates();
                player.getMyBattlefild().getShipsHashMap().remove(fight);
                boolean kill = true;
                for (int i = 0; i < shipCoordinates.length - 1; i = i + 2) {
                    if (shipCoordinates[i] == fightCoordinates[0] && shipCoordinates[i + 1] == fightCoordinates[1]) {
                        shipCoordinates[i] = -1;
                        shipCoordinates[i + 1] = -1;
                    }
                    if (shipCoordinates[i] == -1 && shipCoordinates[i + 1] == -1) {
                        kill = kill & true;
                    } else kill = false;
                }
                if (kill) {
                    System.out.println("Убил");
                    player.gameBattlefield.print();
                    if (player.getMyBattlefild().getShipsHashMap().size() == 0) {
                        System.out.println("Поздравляем, " + getName() + ", вы победили!");
                        return true;
                    }
                    continue;
                } else {
                    System.out.println("Ранил");
                    player.gameBattlefield.print();
                    continue;
                }
            } else {
                System.out.println("Мимо");
                player.gameBattlefield.getPrintBattlefield()[fightCoordinates[0]][fightCoordinates[1]] = "\u2B55";
                player.gameBattlefield.print();
                break;
            }
        }
        return false;
    }

    public String inputName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите своё имя");
        return scanner.nextLine();
    }
}
