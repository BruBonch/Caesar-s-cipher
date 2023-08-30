package src;

import java.io.IOException;

public class Decryptor {
    public void decrypt(String filePath, String alphabet, int encryptKey) throws IOException {
        String stringForDecrypt = FileManager.readFile(filePath);
        char[] alphabetArray = alphabet.toCharArray();
        StringBuilder builder = new StringBuilder();

        for (char symb : stringForDecrypt.toCharArray()) {
            boolean isCapital = Character.isUpperCase(symb);

            for (int i = 0; i < alphabetArray.length; i++) {

                if (Character.toLowerCase(symb) == alphabetArray[i]) {
                    boolean isOffset = i < encryptKey;

                    int index = isOffset ? alphabetArray.length - (encryptKey - i) : i - encryptKey;

                    if (isCapital) {
                        builder.append(Character.toUpperCase(alphabetArray[index]));
                    } else {
                        builder.append((alphabetArray[index]));
                    }

                    break;
                }

            }
        }

        FileManager.writeFile(builder.toString().getBytes(), filePath, "decrypted");
    }

    public void brutForce(String filePath, String alphabet) throws IOException {
        int encryptSpaceCount = 0;
        int decryptSpaceCount = 0;
        String stringForBrutForce = FileManager.readFile(filePath);
        char[] alphabetArray = alphabet.toCharArray();
        StringBuilder builder = new StringBuilder();

        for (char symb : stringForBrutForce.toCharArray()) {
            if (symb == ' ') {
                encryptSpaceCount++;
            }
        }

        int key = 1;

        while (encryptSpaceCount >= decryptSpaceCount) {

            for (char symb : stringForBrutForce.toCharArray()) {
                boolean isCapital = Character.isUpperCase(symb);

                for (int i = 0; i < alphabetArray.length; i++) {

                    if (Character.toLowerCase(symb) == alphabetArray[i]) {
                        boolean isOffset = i < key;

                        int index = isOffset ? alphabetArray.length - (key - i) : i - key;

                        if (isCapital) {
                            builder.append(Character.toUpperCase(alphabetArray[index]));
                        } else {
                            builder.append((alphabetArray[index]));
                        }

                        break;
                    }

                }
            }

            key++;

            for (int i = 0; i < builder.length(); i++) {
                if (builder.charAt(i) == ' ') decryptSpaceCount++;
            }

            if (encryptSpaceCount >= decryptSpaceCount) {
                builder.delete(0, builder.length());
                decryptSpaceCount = 0;
            }
        }

        FileManager.writeFile(builder.toString().getBytes(), filePath, "brut_force");

    }
}
