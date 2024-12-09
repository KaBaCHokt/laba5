import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class Fileread {
    public static void main(String[] args) {
        String filePath = "C:/Users/hamst/Desktop/zadanie7 2.txt"; //путь к файлу

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            List<Person> people = new ArrayList<>(); 

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2 && !parts[1].isEmpty()) {
                    String name = capitalizeName(parts[0]);
                    int number = Integer.parseInt(parts[1]);

                    // Добавляем объект Person в список
                    people.add(new Person(name, number));
                }
            }

            // Группировка имен по номеру с использованием списка объектов Person
            Map<Integer, Set<String>> groupPeople = new TreeMap<>(Comparator.reverseOrder());
            for (Person person : people) {
                groupPeople.computeIfAbsent(person.getNumber(), k -> new LinkedHashSet<>()).add(person.getName());
            }

           
            System.out.println(groupPeople);

        } catch (IOException e) {
            System.out.println("С файлом какие то проблемы");
        }
    }

    // Метод для приведения имени к нужному формату
    private static String capitalizeName(String name) {
        if (name == null || name.isEmpty()) {
            return name;
        }
        return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
    }

    public Set<Character> findUniqueCharsInSingleWords() throws IOException {
        String filePath = "C:/Users/hamst/Desktop/zadanie5 10.txt";
        // Чтение всего текста из файла
        String text = new String(Files.readAllBytes(Paths.get(filePath)));
        System.out.println("Строка из текстового документа: " + text);

        // Разделение текста на слова
        String[] words = text.split("\\s+");

        // Создание карты для хранения символов и слов
        Map<Character, Set<String>> charWords = new HashMap<>();

        // Заполнение карты
        for (String word : words) {
            Set<Character> unique = new HashSet<>();
            for (char c : word.toCharArray()) {
                unique.add(c);
            }
            for (char c : unique) {
                charWords.computeIfAbsent(c, k -> new HashSet<>()).add(word);
            }
        }

        // Символы только в одном слове
        return charWords.entrySet().stream()
                .filter(entry -> entry.getValue().size() == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }

}
