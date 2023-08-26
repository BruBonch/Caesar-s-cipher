package src;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

public class Encryptor {
    public void encrypt (String filePath, String alphabet, int encryptKey) throws IOException {
        String stringForEncrypt = FileManager.readFile(filePath);
        char[] alphabetArray = alphabet.toCharArray();
        StringBuilder builder = new StringBuilder();

        for (char symb : stringForEncrypt.toCharArray()) {
            boolean isCapital = Character.isUpperCase(symb);

            for (int i = 0; i < alphabetArray.length; i++) {

                if (Character.toLowerCase(symb) == alphabetArray[i]) {
                    boolean isOffset = (alphabetArray.length - i - 1) < encryptKey;

                    int index = isOffset ? encryptKey - (alphabetArray.length - i - 1) - 1 : i + encryptKey;

                    if (isCapital) {
                        builder.append(Character.toUpperCase(alphabetArray[index]));
                    } else {
                        builder.append((alphabetArray[index]));
                    }
                    break;
                }
            }
        }

        FileManager.writeFile(builder.toString().getBytes(), filePath, "encrypted");
    };
}
