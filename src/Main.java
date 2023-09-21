import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Програма для створення квадратної матриці і збереження її у файлі.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Запит на введення розміру матриці
        System.out.print("Введіть розмір квадратної матриці: ");
        int n = scanner.nextInt();

        String filler1, filler2;
        do {
            // Запит на введення символів-заповнювачів
            System.out.print("Введіть символ-заповнювач 1 (символ довжиною 1): ");
            filler1 = scanner.next();
            System.out.print("Введіть символ-заповнювач 2 (символ довжиною 1): ");
            filler2 = scanner.next();

            if (filler1.length() != 1 || filler2.length() != 1) {
                System.out.println("Символи-заповнювачі мають бути лише одним символом кожен.");
            }
        } while (filler1.length() != 1 || filler2.length() != 1);

        char fillerChar1 = filler1.charAt(0);
        char fillerChar2 = filler2.charAt(0);

        // Створення та заповнення матриці
        char[][] matrix = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i >= j && i + j >= n - 1) {
                    matrix[i][j] = fillerChar1; // Перший символ
                } else if (i <= j && i + j <= n - 1) {
                    matrix[i][j] = fillerChar2; // Другий символ
                } else {
                    matrix[i][j] = ' '; // Нічого (пробіл)
                }
            }
        }

        try {
            // Запис матриці у файл
            FileWriter writer = new FileWriter("matrix.txt");
            PrintWriter printWriter = new PrintWriter(writer);

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    printWriter.print(matrix[i][j] + " ");
                    System.out.print(matrix[i][j] + " ");
                }
                printWriter.println();
                System.out.println();
            }

            printWriter.close();
            System.out.println("Матриця збережена у файлі 'matrix.txt'.");
        } catch (IOException e) {
            // Обробка помилок при збереженні матриці у файлі
            System.err.println("Помилка при збереженні матриці у файлі.");
            e.printStackTrace();
        }

        scanner.close();
    }
}