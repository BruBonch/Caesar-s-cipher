package src;

import java.io.IOException;

public class Decryptor {
    public void decrypt(String filePath, String alphabet, int encryptKey) throws IOException {
        String stringForDecrypt = FileManager.readFile(filePath);
        char[] alphabetArray = alphabet.toCharArray();
        StringBuilder builder = new StringBuilder();

        Util.keySelection(stringForDecrypt, alphabetArray, builder, encryptKey);

        FileManager.writeFile(builder.toString().getBytes(), filePath, "decrypt");
    }

    public void brutForce(String filePath, String alphabet) throws IOException {
        int encryptSpaceCount = 0;
        int decryptSpaceCount = 0;
        int key = 1;

        String stringForBrutForce = FileManager.readFile(filePath);
        char[] alphabetArray = alphabet.toCharArray();
        StringBuilder builder = new StringBuilder();

        for (char symb : stringForBrutForce.toCharArray()) {
            if (symb == ' ') {
                encryptSpaceCount++;
            }
        }

        while (encryptSpaceCount >= decryptSpaceCount) {
            Util.keySelection(stringForBrutForce, alphabetArray, builder, key);

            for (int i = 0; i < builder.length(); i++) {
                if (builder.charAt(i) == ' ') decryptSpaceCount++;
            }

            if (encryptSpaceCount >= decryptSpaceCount) {
                builder.delete(0, builder.length());
                decryptSpaceCount = 0;
            }

            key++;
        }

        FileManager.writeFile(builder.toString().getBytes(), filePath, "brut_force");

    }
}
