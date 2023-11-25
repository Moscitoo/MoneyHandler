import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Adatok betöltése fájlból");
            System.out.println("2. Adatok mentése fájlba");
            System.out.println("3. Új kategória létrehozása");
            System.out.println("4. Új tranzakció létrehozása");
            System.out.println("5. Tranzakciók listázása");
            System.out.println("6. Kategóriák listázása");
            System.out.println("7. Kategória szerkesztése");
            System.out.println("0. Kilépés");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 0:
                    System.out.println("Kilépés...");
                    System.exit(0);
                default:
                    System.out.println("Érvénytelen választás.");
            }
        }
    }
}