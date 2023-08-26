package src;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        String ALPHABET_STRING = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя.,\":-!? \n";
        int ENCRYPT_KEY = 3;

        Encryptor encryptor = new Encryptor();
        Decryptor decryptor = new Decryptor();

        try {
            encryptor.encrypt("D:/file_1.txt", ALPHABET_STRING, ENCRYPT_KEY);
            decryptor.decrypt("D:/encrypted.txt", ALPHABET_STRING, ENCRYPT_KEY);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}