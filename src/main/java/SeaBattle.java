import java.util.Scanner;

public class SeaBattle {
    public static void main(String[] args) {
        System.out.println(Ship.inputCoordinatesShip(4));
    }

    public static int[] validationCoordinates(int deks) {
        int[] coordinates = new int[deks * 2];
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String line = scanner.nextLine();
            String[] splitLine = line.split(",|;");
            if (splitLine.length != deks * 2){
                System.out.println("Ввод не корректен, повторите ввод");
                continue;
            }
            boolean validate = false;
            for (int i = 0; i < splitLine.length; i++) {
                coordinates[i] = Integer.parseInt(splitLine[i]);
                if (coordinates[i] < 0 || coordinates[i] > 9) validate = true;
            }
            if (validate) {
                System.out.println("Ввод не корректен, повторите ввод");
                continue;}
            return coordinates;
        }
    }

}
