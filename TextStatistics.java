import java.io.*;
import java.util.StringTokenizer;

public class TextStatistics {
    public static void main(String[] args) {
        String input = "input.txt"; // Укажите путь к вашему текстовому файлу
        String output = "output.txt"; // Укажите путь к выходному файлу

        try {
            // Читаем текст из файла
            String text = read(input);

            // Вычисляем статистику
            int totalCharacters = text.length();
            int charactersBesProbelov = text.replaceAll("\\s", "").length();
            int word = countWords(text);

            // Выводим статистику в консоль
            System.out.println("Статистика текста:");
            System.out.println("Количество символов: " + totalCharacters);
            System.out.println("Количество символов без пробелов: " + charactersBesProbelov);
            System.out.println("Количество слов: " + word);

            // Записываем статистику в файл
            writeStatisticsToFile(output, totalCharacters, charactersBesProbelov, word);

            System.out.println("Статистика сохранена в файл: " + output);
        } catch (IOException e) {
            System.err.println("Ошибка при работе с файлом: " + e.getMessage());
        }

    }

    private static String read(String filePath) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
        }
        return sb.toString().trim();
    }

    private static int countWords(String text) {
        StringTokenizer tokenizer;
        tokenizer = new StringTokenizer(text);
        return tokenizer.countTokens();
    }

    private static void writeStatisticsToFile(String filePath, int totalCharacters, int charactersWithoutSpaces, int wordCount) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            writer.println("Статистика текста:");
            writer.println("Количество символов: " + totalCharacters);
            writer.println("Количество символов без пробелов: " + charactersWithoutSpaces);
            writer.println("Количество слов: " + wordCount);
        }
    }
}
