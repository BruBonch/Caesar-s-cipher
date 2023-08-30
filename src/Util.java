package src;

public class Util {
    public static String getFileName(String path, String fileName) {
        int parentIndex = path.lastIndexOf("/");
        int dotIndex = path.lastIndexOf(".");
        return path.substring(0, parentIndex + 1) + fileName + path.substring(dotIndex);
    }

    public static void keySelection(String strForDecrypt, char[] alphabet, StringBuilder builder, int encryptKey) {
        for (char symb : strForDecrypt.toCharArray()) {
            boolean isCapital = Character.isUpperCase(symb);

            for (int i = 0; i < alphabet.length; i++) {

                if (Character.toLowerCase(symb) == alphabet[i]) {
                    boolean isOffset = i < encryptKey;

                    int index = isOffset ? alphabet.length - (encryptKey - i) : i - encryptKey;

                    if (isCapital) {
                        builder.append(Character.toUpperCase(alphabet[index]));
                    } else {
                        builder.append((alphabet[index]));
                    }

                    break;
                }

            }
        }
    }
}
