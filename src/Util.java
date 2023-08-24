package src;

public class Util {
    public static String getFileName(String path, String fileName) {
        int parentIndex = path.lastIndexOf("/");
        int dotIndex = path.lastIndexOf(".");
        return path.substring(0, parentIndex + 1) + fileName + path.substring(dotIndex);
    }
}
