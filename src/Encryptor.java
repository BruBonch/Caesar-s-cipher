package src;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Encryptor {
    public void encrypt (String filePath, String alphabet, int encryptKey) throws IOException {
        String stringForEncrypt = readFile(filePath);

        char[] alphabetArray = alphabet.toCharArray();

        StringBuilder builder = new StringBuilder();


        for (char symb : stringForEncrypt.toCharArray()) {
            boolean isCapital = Character.isUpperCase(symb);

            for (int i = 0; i < alphabetArray.length; i++) {

                if (Character.toLowerCase(symb) == alphabetArray[i]) {
                    boolean isOffset = (alphabetArray.length - i - 1) <= encryptKey;

                    int index = isOffset ? encryptKey - (alphabetArray.length - i) : i + encryptKey;


                    if (isCapital) {
                        builder.append(Character.toUpperCase(alphabetArray[index]));
                    } else {
                        builder.append((alphabetArray[index]));
                    }
                    break;
                }
            }
        }

        writeFile(builder.toString().getBytes(), filePath);
    };
    private String readFile (String filePath) throws IOException {
        try (var channel = FileChannel.open(Path.of(filePath))) {
            ByteBuffer buff = ByteBuffer.allocate(200);
            int bytesRead = channel.read(buff);

            while (bytesRead != -1) {
                buff.clear();
                bytesRead = channel.read(buff);
            }
            return new String(buff.array(), StandardCharsets.UTF_8);
        }
    }

    private void writeFile(byte[] encryptedString, String parentPath) throws IOException {
        String path = Util.getFileName(parentPath, "encrypted");

        try (
                var channel = FileChannel.open(Path.of(path), StandardOpenOption.WRITE, StandardOpenOption.CREATE_NEW)
        ) {
            ByteBuffer buff = ByteBuffer.wrap(encryptedString);
            channel.write(buff);
        }
    }
}
