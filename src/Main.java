package src;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final String ALPHABET_STRING = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя.,\":-!? \n";
        final int ENCRYPT_KEY = 3;
        final String GREETING = "Добро пожаловать в небольшую программу по шифрованию и расшифровке файлов.";

        final String OPTIONS = """
                Введите одну из предложенных ниже команд:
                 * 1 -- шифрование файла
                 * 2 -- расшифровка файла
                 * 3 -- брут-форс расшифровка
                """;

        final String CONTINUE = """
                Для продолжения выберите одну из следующих команд:
                 * 0 -- выход
                 * 1 -- начать / продолжить работу
                """;

        Encryptor encryptor = new Encryptor();
        Decryptor decryptor = new Decryptor();

        Scanner scan = new Scanner(System.in);

        try {
            System.out.println(GREETING);
            System.out.println(CONTINUE);

            while (scan.nextInt() != 0) {
                System.out.println(OPTIONS);
                int choice = scan.nextInt();

                // Новый сканер, чтобы пропустить пробел и не завалиться на ошибке
                Scanner scanner = new Scanner(System.in);


                switch (choice) {
                    case 1 -> {
                        System.out.println("Введите путь к файлу");
                        encryptor.encrypt(scanner.nextLine(), ALPHABET_STRING, ENCRYPT_KEY);
                        System.out.println("Файл успешно зашифрован\n");
                    }
                    case 2 -> {
                        System.out.println("Введите путь к файлу");
                        decryptor.decrypt(scanner.nextLine(), ALPHABET_STRING, ENCRYPT_KEY);
                        System.out.println("Файл успешно расшифрован\n");
                    }
                    case 3 -> {
                        System.out.println("Введите путь к файлу");
                        decryptor.brutForce(scanner.nextLine(), ALPHABET_STRING);
                        System.out.println("Файл расшифрован с помощью брут форс\n");
                    }
                }

                System.out.println(CONTINUE);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}