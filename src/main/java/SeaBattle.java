import java.util.Scanner;

public class SeaBattle {
    public static void main(String[] args) {
        System.out.println(Ship.inputCoordinatesShip(4));
    }

    public static int[] inputCoordinates(int deks) {
        int[] coordinates = new int[deks * 2];
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String line = scanner.nextLine();
            String[] splitLine = line.split(",|;");
            for (int i = 0; i < splitLine.length; i++) {
                coordinates[i] = Integer.parseInt(splitLine[i]);
            }
            if (!validationCoordinates(coordinates, deks)) {
                System.out.println("Ввод не корректен, повторите ввод");
                continue;}
            return coordinates;
        }
    }

    private static boolean validationCoordinates(int[] coordinates, int deks){
        if (coordinates.length != deks * 2){
            return false;
        }
        boolean validate = true;
        for (int i = 0; i < coordinates.length; i++) {
            if (coordinates[i] < Battlefield.MIN_INDEX || coordinates[i] > Battlefield.MAX_INDEX) validate = false;
        }
        return validate;
    }

}
