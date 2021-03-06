import java.util.Random;
import java.util.Scanner;

public class SeaBattle {
    public static void main(String[] args) {
        Player player1 = new Player();
        player1.setName(player1.inputName());
        Player player2 = new Player();
        player2.setName(player2.inputName());
        player1.generateBattlefield();
        player2.generateBattlefield();
        Random rand = new Random();
        if (rand.nextInt(2) + 1 == 1) {
            while (true) {
                if (player1.fight(player2)) return;
                if (player2.fight(player1)) return;
            }
        } else {
            while (true) {
                if (player2.fight(player1)) return;
                if (player1.fight(player2)) return;
            }
        }
    }

    public static int[] inputCoordinates(int decks) {
        int[] coordinates = new int[decks * 2];
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String line = scanner.nextLine();
            String[] splitLine = line.split("[,;]");
            if (splitLine.length != decks * 2) {
                System.out.println("Количество координат не соответствует кораблю");
                continue;
            }
            try {
                for (int i = 0; i < splitLine.length; i++) {
                    coordinates[i] = Integer.parseInt(splitLine[i]);
                }
            } catch (NumberFormatException e) {
                System.out.println("Вы ошиблись, формат ввода х1,у1;х2,у2.... например 0,1;0,2;0,3;0,4 \n Давайте попробуем ещё раз:");
                continue;
            }
            if (!validationCoordinates(coordinates)) {
                System.out.println("Координаты выходят за границы игрового поля, повторите ввод");
                continue;
            }
            return coordinates;
        }
    }

    private static boolean validationCoordinates(int[] coordinates) {
        boolean validate = true;
        for (int coordinate : coordinates) {
            if (coordinate < Battlefield.MIN_INDEX || coordinate > Battlefield.MAX_INDEX) {
                validate = false;
                break;
            }
        }
        return validate;
    }

}
