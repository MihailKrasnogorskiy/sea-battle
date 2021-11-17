import java.util.Scanner;

public class SeaBattle {
    public static void main(String[] args) {
        //System.out.println(Ship.inputCoordinatesShip(4));
        Player player1 = new Player("Sasha");
        player1.generateBattlefield();

    }

    public static int[] inputCoordinates(int decks) {
        int[] coordinates = new int[decks * 2];
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String line = scanner.nextLine();
            String[] splitLine = line.split(",|;");
            if (splitLine.length != decks * 2) {
                System.out.println("Количество координат не соответствует кораблю");
                continue;
            }
            for (int i = 0; i < splitLine.length; i++) {
                coordinates[i] = Integer.parseInt(splitLine[i]);
            }
            if (!validationCoordinates(coordinates, decks)) {
                System.out.println("Координаты выходят за границы игрового поля, повторите ввод");
                continue;
            }
            return coordinates;
        }
    }

    private static boolean validationCoordinates(int[] coordinates, int decks) {
        boolean validate = true;
        for (int i = 0; i < coordinates.length; i++) {
            if (coordinates[i] < Battlefield.MIN_INDEX || coordinates[i] > Battlefield.MAX_INDEX) {
                validate = false;
            }
        }
        return validate;
    }

}
