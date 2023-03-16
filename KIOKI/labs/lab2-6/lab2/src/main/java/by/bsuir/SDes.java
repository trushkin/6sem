package by.bsuir;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

public class SDes {
    private static final String SOURCE_MESSAGE = "C:\\Univer\\FKP\\6sem\\KIOKI\\labs\\lab2-6\\lab2\\src\\main\\resources\\sourceMessage.txt";
    private static final String ENCRYPTED_MESSAGE = "C:\\Univer\\FKP\\6sem\\KIOKI\\labs\\lab2-6\\lab2\\src\\main\\resources\\encryptedMessage.txt";
    private static final String DECRYPTED_MESSAGE = "C:\\Univer\\FKP\\6sem\\KIOKI\\labs\\lab2-6\\lab2\\src\\main\\resources\\decryptedMessage.txt";
    private static final String KEY = "1100001101";
    private static final int[] P_10 = new int[]{3, 5, 2, 7, 4, 10, 1, 9, 8, 6};
    private static final int[] P_8 = new int[]{6, 3, 7, 4, 8, 5, 10, 9};
    private static final int[] P_4 = new int[]{2, 4, 3, 1};
    private static final int[] IP = new int[]{2, 6, 3, 1, 4, 8, 5, 7};
    private static final int[] IP_MINUS1 = new int[]{4, 1, 3, 5, 7, 2, 8, 6};
    private static final int[] E_P = new int[]{4, 1, 2, 3, 2, 3, 4, 1};
    private static final int[][] S_BOX_1 = new int[][]{{1, 0, 3, 2}, {3, 2, 1, 0}, {0, 2, 1, 3}, {3, 1, 3, 2}};
    private static final int[][] S_BOX_2 = new int[][]{{0, 1, 2, 3}, {2, 0, 1, 3}, {3, 0, 1, 0}, {2, 1, 0, 3}};

    private static String[] readFileIntoBinaryArrays(String fileName) throws IOException {
        byte[] array = Files.readAllBytes(Paths.get(fileName));
        String[] resultBinArray = new String[array.length];
        for (int i = 0; i < array.length; i++) {
            StringBuilder s = new StringBuilder(Integer.toBinaryString((array[i] + 256) % 256));
            while (s.length() < 8) {
                s.insert(0, "0");
            }
            resultBinArray[i] = s.toString();
        }
        return resultBinArray;
    }

    private static void writeBinArray(String fileName, String[] array) throws IOException {
        byte[] array2 = new byte[array.length];
        String[] binArr = new String[array.length];
        for (int i = 0; i < array.length; i++) {
            binArr[i] = array[i];
            while (Objects.equals(binArr[i].charAt(0), '0')) {
                binArr[i] = binArr[i].substring(1);
            }
            array2[i] = (byte) Integer.parseInt(binArr[i], 2);
        }
        File file = new File(fileName);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(array2);
        fileOutputStream.close();
    }

    private static void code(String fromFileName, String toFileName, String key1, String key2) throws IOException {
        String[] arr = readFileIntoBinaryArrays(fromFileName);
        String[] resultArr = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            String res = replace(arr[i], IP);
            res = round(res, key1);
            res = res.substring(res.length() / 2) + res.substring(0, res.length() / 2);
            res = round(res, key2);
            res = replace(res, IP_MINUS1);
            resultArr[i] = res;
        }
        writeBinArray(toFileName, resultArr);
    }

    private static String round(String text, String key) {
        String left = text.substring(0, text.length() / 2);
        String right = text.substring(text.length() / 2);
        String newRight = right;
        right = replace(right, E_P);
        right = xor(right, key);
        right = sBoxes(right.substring(0, right.length() / 2), S_BOX_1) + sBoxes(right.substring(right.length() / 2), S_BOX_2);
        right = replace(right, P_4);
        String newLeft = xor(right, left);
        return newLeft + newRight;
    }

    private static String makeFirstKey() {
        String res = replace(SDes.KEY, P_10);
        String left = shiftBitLeft(res.substring(0, SDes.KEY.length() / 2), 1);
        String right = shiftBitLeft(res.substring(SDes.KEY.length() / 2), 1);
        res = left + right;
        res = replace(res, P_8);
        return res;
    }

    private static String makeSecondKey() {
        String res = replace(SDes.KEY, P_10);
        String left = shiftBitLeft(res.substring(0, SDes.KEY.length() / 2), 3);
        String right = shiftBitLeft(res.substring(SDes.KEY.length() / 2), 3);
        res = left + right;
        res = replace(res, P_8);
        return res;
    }

    private static String shiftBitLeft(String key, int n) {
        StringBuilder res = new StringBuilder();
        for (int i = n; i < key.length() + n; i++) {
            res.append(key.charAt(i % key.length()));
        }
        return res.toString();
    }

    private static String replace(String text, int[] arr) {
        StringBuilder res = new StringBuilder();
        for (int j : arr) {
            res.append(text.charAt(j - 1));
        }
        return res.toString();
    }

    private static String xor(String t1, String t2) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < t1.length(); i++) {
            res.append(t1.charAt(i) ^ t2.charAt(i));
        }
        return res.toString();
    }

    private static String sBoxes(String text, int[][] sBox) {
        int row = Integer.parseInt(String.valueOf(text.charAt(0)) + text.charAt(3), 2);
        int col = Integer.parseInt(String.valueOf(text.charAt(1)) + text.charAt(2), 2);
        int num = sBox[row][col];
        return String.valueOf(num / 2) + num % 2;
    }

    public static void main(String[] args) throws IOException {
        String key1 = makeFirstKey();
        String key2 = makeSecondKey();
        code(SOURCE_MESSAGE, ENCRYPTED_MESSAGE, key1, key2);
        code(ENCRYPTED_MESSAGE, DECRYPTED_MESSAGE, key2, key1);
    }
}
