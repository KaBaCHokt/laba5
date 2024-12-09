import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner cot = new Scanner(System.in);
        List<Cat> cats = new ArrayList<>();
        int numCats;
        System.out.println("          Задание 2.1");
        System.out.print("Количество котов: ");
        numCats = cot.nextInt();
        cot.nextLine();
        for (int i = 0; i < numCats; i++) {
            System.out.print("Введите имя кота " + (i + 1) + ": ");
            String catName = cot.nextLine();
            cats.add(new Cat(catName));
        }
        Funs.meowsCare(scanner, cats.toArray(new Meowable[0]));
        for (Cat cat : cats) {
            System.out.println(cat.getName() + " мяукал: " + cat.getMeowCount() + " раз");
        }

        System.out.println("          Задание 3.10");

        System.out.println("Введите числа через пробел:");
        String input = scanner.nextLine();

        // Разделение строки на числа
        String[] parts = input.split(" ");
        List<Integer> list = new ArrayList<>();

        // Преобразование строк в числа и добавление их в список
        for (String part : parts) {
            try {
                int number = Integer.parseInt(part);
                list.add(number);
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат ввода: " + part);
            }
        }

        // Используем LinkedHashSet для удаления дубликатов и сохранения порядка
        Set<Integer> uniqueElements = new LinkedHashSet<>(list);

        // Преобразуем Set обратно в List
        List<Integer> resultList = uniqueElements.stream().collect(Collectors.toList());

        // Вывод результата
        System.out.println("Список с первыми вхождениями: " + resultList);

        System.out.println("          Задание 5.10");
        try {
            // Создание объекта FileRead
            Fileread fileRead = new Fileread();

            // Получение уникальных символов, встречающихся в одном и только в одном слове
            Set<Character> unique = fileRead.findUniqueCharsInSingleWords();

            // Вывод результата
            System.out.println("Символы, встречающиеся в одном и только в одном слове: " + unique);

        } catch (IOException e) {
            System.out.println("С файлом какие то проблемы");
        }


        System.out.println("          Задание 7.1");
        Scanner scanner2 = new Scanner(System.in);
        List<Point> points = new ArrayList<>();

        System.out.println("Введите координаты 5 точек в формате 'x y':");

        for (int i = 0; i < 5; i++) {
            System.out.print("Точка " + (i + 1) + ": ");
            String input2 = scanner2.nextLine();
            String[] parts2 = input2.split(" ");
            if (parts2.length == 2) {
                try {
                    int x = Integer.parseInt(parts2[0]);
                    int y = Integer.parseInt(parts2[1]);
                    points.add(new Point(x, y));
                } catch (NumberFormatException e) {
                    System.out.println("Неверный формат ввода. Попробуйте снова.");
                    i--; // Повторить ввод для текущей точки
                }
            } else {
                System.out.println("Неверный формат ввода. Попробуйте снова.");
                i--; // Повторить ввод для текущей точки
            }
        }

        // Обработка точек с помощью Stream API
        List<Point> processedPoints = points.stream()
                .distinct() // Убираем дубликаты
                .sorted(Comparator.comparing(Point::getX)) // Сортируем по X
                .map(p -> new Point(p.getX(), Math.abs(p.getY()))) // Делаем Y положительным
                .collect(Collectors.toList());

        // Создание линий для ломаной
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < processedPoints.size() - 1; i++) {
            lines.add(new Line(processedPoints.get(i), processedPoints.get(i + 1)));
        }

        // Создание ломаной
        Polyline polyline = new Polyline(lines);

        // Вывод результата
        System.out.println(polyline);


        System.out.println("          Задание 7.2");
        Fileread.main(args);
    }
}