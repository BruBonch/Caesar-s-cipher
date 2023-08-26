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
}
