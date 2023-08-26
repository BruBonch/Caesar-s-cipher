package src;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FileManager {
    public static String readFile (String filePath) throws IOException {
        try (var channel = FileChannel.open(Path.of(filePath))) {
            ByteBuffer buff = ByteBuffer.allocate((int) channel.size());

            channel.read(buff);
            return new String(buff.array(), StandardCharsets.UTF_8);
        }
    }

    public static void writeFile(byte[] fileData, String parentPath, String fileName) throws IOException {
        Path path = Path.of(Util.getFileName(parentPath, fileName));

        if (Files.notExists(path)) {
            Files.createFile(path);
        }
        try (
                var channel = FileChannel.open(path, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING)
        ) {
            ByteBuffer buff = ByteBuffer.wrap(fileData);
            channel.write(buff);
        }
    }
}
