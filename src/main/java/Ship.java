public class Ship {
    private int[] coordinates;
    private Battlefield battlefield;

    public Battlefield getBattlefield() {
        return battlefield;
    }

    public int[] getCoordinates() {
        return coordinates;
    }

    public Ship(Battlefield battlefield, int[] coordinates) {
        this.coordinates = coordinates;
        this.battlefield = battlefield;
    }

    private static boolean validation(int[] shipCoordinates, int a) {
        boolean validation = true;
        for (int i = a; i <= shipCoordinates.length - 4 + a; i = i + 2) {
            if (shipCoordinates[i] != shipCoordinates[i + 2]) {
                validation = false;
            }
        }
        if (!validation) {
            a++;
            if (a > 1) return false;
            return validation(shipCoordinates, a);
        }
        return lineValidation(shipCoordinates, (a + 3) % 2);
    }

    private static boolean lineValidation(int[] shipCoordinates, int a) {
        for (int i = a; i <= (shipCoordinates.length - 4 + a); i = i + 2) {
            if (Math.abs(shipCoordinates[i] - shipCoordinates[i + 2]) != 1) return false;
        }
        return true;
    }

    public static int[] inputCoordinatesShip(int deks, Battlefield battlefield) {
        int[] shipCoordinates = new int[deks * 2];
        String[] shipsName = {"одно", "двух", "трёх", "четырёх"};
        while (true) {
            System.out.println("Введите координаты " + shipsName[deks - 1] + "палубного корабля (формат: х,у;х,у и т.д.)");
            shipCoordinates = SeaBattle.inputCoordinates(deks);
            // при первом вызове метода validation, который проверяет "линейность" ввода координат,
            // аргументу "а" присваивается значение 0 в обязательном порядке
            if (validation(shipCoordinates, 0)) {
                if (validationInHalo(shipCoordinates, battlefield)) {
                    System.out.println("Ваш корабль заходит на ореол другого, давайте попробуем ещё раз");
                    continue;
                }
                return shipCoordinates;
            }
            System.out.println("Вы ошиблись, давайте поробуем ещё раз");
        }
    }

    private static void generateHalo(Ship ship) {
        int[] haloCoordinates = new int[2];
        boolean condition = false;
        if (ship.getCoordinates().length > 2) {
            condition = ship.getCoordinates()[0] == ship.getCoordinates()[2];
        }
        if (ship.getCoordinates().length == 2 || condition) {
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < ship.getCoordinates().length / 2 + 1; j++) {
                    haloCoordinates[0] = ship.getCoordinates()[0] + i;
                    if (haloCoordinates[0] < Battlefield.MIN_INDEX || haloCoordinates[0] > Battlefield.MAX_INDEX)
                        continue;
                    haloCoordinates[1] = ship.getCoordinates()[1] + j;
                    if (haloCoordinates[1] < Battlefield.MIN_INDEX || haloCoordinates[1] > Battlefield.MAX_INDEX)
                        continue;
                    Halo halo = new Halo(ship, haloCoordinates);
                    String stringHaloCoordinates = String.valueOf(haloCoordinates[0]) + String.valueOf(haloCoordinates[1]);
                    ship.battlefield.getHaloHashMap().put(stringHaloCoordinates, halo);
                    boolean shipPosition = ship.battlefield.getPrintBattlefield()[haloCoordinates[0]][haloCoordinates[1]].equals(ship.toString());
                    if (!shipPosition) {
                        ship.battlefield.getPrintBattlefield()[haloCoordinates[0]][haloCoordinates[1]] = halo.toString();
                    }
                }
            }
        } else {
            for (int i = -1; i < ship.getCoordinates().length / 2 + 1; i++) {
                for (int j = -1; j < 2; j++) {
                    haloCoordinates[0] = ship.getCoordinates()[0] + i;
                    if (haloCoordinates[0] < Battlefield.MIN_INDEX || haloCoordinates[0] > Battlefield.MAX_INDEX)
                        continue;
                    haloCoordinates[1] = ship.getCoordinates()[1] + j;
                    if (haloCoordinates[1] < Battlefield.MIN_INDEX || haloCoordinates[1] > Battlefield.MAX_INDEX)
                        continue;
                    Halo halo = new Halo(ship, haloCoordinates);
                    String stringHaloCoordinates = String.valueOf(haloCoordinates[0]) + String.valueOf(haloCoordinates[1]);
                    ship.battlefield.getHaloHashMap().put(stringHaloCoordinates, halo);
                    boolean shipPosition = ship.battlefield.getPrintBattlefield()[haloCoordinates[0]][haloCoordinates[1]].equals(ship.toString());
                    if (!shipPosition) {
                        ship.battlefield.getPrintBattlefield()[haloCoordinates[0]][haloCoordinates[1]] = halo.toString();
                    }
                }
            }
        }
    }

    // Если метод возвращает true, то корабль попадает в ореол другого корабля
    private static boolean validationInHalo(int[] shipCoordinates, Battlefield battlefield) {
        boolean validation = false;
        for (int i = 0; i < shipCoordinates.length - 1; i = i + 2) {
            String validationCoordinates = String.valueOf(shipCoordinates[i]) + String.valueOf(shipCoordinates[i + 1]);
            validation = battlefield.getHaloHashMap().containsKey(validationCoordinates);
        }
        return validation;
    }

    public static void generateShip(int deсks, Battlefield battlefield) {
        int[] shipCoordinates = inputCoordinatesShip(deсks, battlefield);
        Ship ship = new Ship(battlefield, shipCoordinates);
        for (int i = 0; i < shipCoordinates.length - 1; i = i + 2) {
            String deckCoordinates = String.valueOf(shipCoordinates[i]) + String.valueOf(shipCoordinates[i + 1]);
            battlefield.getShipsHashMap().put(deckCoordinates, ship);
            battlefield.getPrintBattlefield()[shipCoordinates[i]][shipCoordinates[i + 1]] = ship.toString();
        }
        generateHalo(ship);
    }

    public String toString() {
        return "\u26F5";
    }
}
