package src;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String ALPHABET_STRING = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя.,\":-!? ";
        int ENCRYPT_KEY = 3;

        Encryptor encryptor = new Encryptor();

        try {
            encryptor.encrypt("D:/file.txt", ALPHABET_STRING, ENCRYPT_KEY);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
//
//        for (char symb : StringForDecrypt.toCharArray()) {
//            boolean isCapital = Character.isUpperCase(symb);
//
//            for (int i = 0; i < alphabetArray.length; i++) {
//
//                if (Character.toLowerCase(symb) == alphabetArray[i]) {
//                    boolean isOffset = i < encryptKey;
//
//                    int index = isOffset ? alphabetArray.length - (encryptKey - i) : i - encryptKey;
//
//                    if (isCapital) {
//                        builder.append(Character.toUpperCase(alphabetArray[index]));
//                    } else {
//                        builder.append((alphabetArray[index]));
//                    }
//
//                    break;
//                }
//
//            }

}