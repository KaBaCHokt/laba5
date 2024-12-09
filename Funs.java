import java.util.Scanner;
public class Funs {
    public static void meowsCare(Scanner scanner, Meowable... meowables) {
        for (Meowable m : meowables) {
            System.out.print("Сколько раз должен мяукнуть " + ((Cat) m).getName() + "? ");
            int numMeows = scanner.nextInt();
            scanner.nextLine();
            for (int i = 0; i < numMeows; i++) {
                m.meow();
            }
        }
    }
}

