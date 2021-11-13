public class Ship {
    private int[] coordinates;

    public int[] getCoordinates() {
        return coordinates;
    }

    private static boolean validation(int[] shipCoordinates, int a) {
        boolean validation = true;
        for (int i = a; i <= shipCoordinates.length - 4 + a; i = i + 2) {
            if (shipCoordinates[i] != shipCoordinates[i + 2]) {
                validation = false;
            }
        }
        if (validation == false) {
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

    public static int[] inputCoordinatesShip(int deks) {
        int[] shipCoordinates = new int[deks * 2];
        String[] shipsName = {"одно", "двух", "трёх", "четырёх"};
        while (true) {
            System.out.println("Введите координаты " + shipsName[deks - 1] + "палубного корабля (формат: х,у;х,у и т.д.)");
            shipCoordinates = SeaBattle.validationCoordinates(deks);
            // при первом вызове метода validation, который проверяет "линейность" ввода координат,
            // аргументу "а" присваивается значение 0 в обязательном порядке
            if (validation(shipCoordinates, 0)) {
                return shipCoordinates;
            }
            System.out.println("Вы ошиблись, давайте поробуем ещё раз");
        }
    }

    private static void generateHalo(Ship ship) {
        int[] haloCoordinates = new int[2];
        if (ship.getCoordinates()[0] == ship.getCoordinates()[2] || ship.getCoordinates().length == 2) {
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < ship.getCoordinates().length + 1; j++) {
                    haloCoordinates[0] = ship.getCoordinates()[0] + i;
                    if (haloCoordinates[0] < 0 || haloCoordinates[0] > 9) continue;
                    haloCoordinates[1] = ship.getCoordinates()[1] + j;
                    if (haloCoordinates[1] < 0 || haloCoordinates[1] > 9) continue;
                    Halo halo = new Halo(ship, haloCoordinates);
                    halo.getHaloHashMap().put(haloCoordinates, halo);
                }
            }
        } else {
            for (int i = -1; i < ship.getCoordinates().length + 1; i++) {
                for (int j = -1; j < 2; j++) {
                    haloCoordinates[0] = ship.getCoordinates()[0] + i;
                    if (haloCoordinates[0] < 0 || haloCoordinates[0] > 9) continue;
                    haloCoordinates[1] = ship.getCoordinates()[1] + j;
                    if (haloCoordinates[1] < 0 || haloCoordinates[1] > 9) continue;
                    Halo halo = new Halo(ship, haloCoordinates);
                    halo.getHaloHashMap().put(haloCoordinates, halo);
                }
            }
        }
    }
}
