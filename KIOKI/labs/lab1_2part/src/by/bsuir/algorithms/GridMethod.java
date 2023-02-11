package by.bsuir.algorithms;

import java.security.MessageDigestSpi;
import java.util.*;

public class GridMethod {

    //    private static final int[][] KEY_MATRIX = {
//            {1, 2, 3, 1},
//            {3, 4, 4, 2},
//            {2, 4, 4, 3},
//            {1, 3, 2, 1}
//    };
    private static final int SIDE = 4;
    private static final int NUMBER_OF_TURNS = 4;
    private static final int MESSAGE_LENGTH = 16;
    private static final int[] FIRST_ELEMENT_POSITION = {0, 0};
    private static final int[] SECOND_ELEMENT_POSITION = {1, 3};
    private static final int[] THIRD_ELEMENT_POSITION = {3, 1};
    private static final int[] FORTH_ELEMENT_POSITION = {2, 2};
    private static final Map<Integer, int[]> KEY = new HashMap<>();

    static {
        KEY.put(0, FIRST_ELEMENT_POSITION);
        KEY.put(1, SECOND_ELEMENT_POSITION);
        KEY.put(2, THIRD_ELEMENT_POSITION);
        KEY.put(3, FORTH_ELEMENT_POSITION);
    }

    public static String encrypt(String message) throws RuntimeException {

        if (message.length() > MESSAGE_LENGTH) {
            throw new RuntimeException("Invalid input parameters! Message must be 16 characters long");
        }else if(message.length() < MESSAGE_LENGTH){
            StringBuilder temp = new StringBuilder(message);
            for (int i = message.length(); i <MESSAGE_LENGTH; i++) {
                temp.append('*');
                message =temp.toString();
            }
        }
        StringBuilder encryptedMessage = new StringBuilder(MESSAGE_LENGTH);
        char[][] matrix = new char[SIDE][SIDE];
        int tab = 0;
        for (int i = 0; i < NUMBER_OF_TURNS; i++) {
            for (int j = 0; j < SIDE; j++) {
                matrix[KEY.get(j)[0]][KEY.get(j)[1]] = message.charAt(j + tab);
            }
            matrix = rotateClockwise(matrix);
            tab += 4;
        }
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                encryptedMessage.append(matrix[i][j]);
            }
        }
       // System.out.println(Arrays.deepToString(matrix));
        return encryptedMessage.toString();
    }

    public static String decrypt(String encryptedMessage) {
        StringBuilder decryptedMessage = new StringBuilder(MESSAGE_LENGTH);
        StringBuilder finalMessage = new StringBuilder(MESSAGE_LENGTH);
        char[][] matrix = new char[SIDE][SIDE];
        int letterPositionInMessage = 0;
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                matrix[i][j] = encryptedMessage.charAt(letterPositionInMessage);
                letterPositionInMessage++;
            }
        }
        for (int i = 0; i < NUMBER_OF_TURNS; i++) {
            for (int j = 0; j < SIDE; j++) {
                decryptedMessage.append(matrix[KEY.get(j)[0]][KEY.get(j)[1]]);
            }
            matrix = rotateClockwise(matrix);
        }
        for (int i = 0; i < MESSAGE_LENGTH - 1; i++) {
            if(decryptedMessage.charAt(i) != '*'){
                finalMessage.append(decryptedMessage.charAt(i));
            }
        }
        return finalMessage.toString();
    }

    public static char[][] rotateClockwise(char[][] arr) {

        char[][] result = new char[SIDE][SIDE];
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                result[i][j] = arr[SIDE - j - 1][i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(encrypt("ЭТОЛЕКЦИЯПОК11"));
        System.out.println(decrypt("ЭКО**КИТП*ЛЦЕО*Я"));
    }
}
