package by.bsuir;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class LSB {
    private static final int HEADER_SIZE = 54; // размер заголовка BMP файла
    private static final int OFFSET_SIZE = 10; // смещение данных счетчика в заголовке BMP файла
    private static final int BYTE_SIZE = 8; // количество бит в байте
    private static int length;
    public static void writeLSB(String inputFileName, String message, String modifiedFileName) throws IOException {
        File file = new File(inputFileName);
        FileInputStream inputStream = new FileInputStream(file);
        byte[] header = new byte[HEADER_SIZE];
        byte[] data = new byte[(int) file.length() - HEADER_SIZE];
        int offset;
         length = message.length();

        try {
            inputStream.read(header); // чтение заголовка
            offset = byteArrayToInt(header, OFFSET_SIZE); // получение смещения
            inputStream.read(data); // чтение данных
        } finally {
            inputStream.close();
        }
        for (int i = 0; i < length; i++) {
            byte[] bytes = Integer.toBinaryString(message.charAt(i)).getBytes();
            System.out.println(bytes.length);
            String temp = new String(bytes);
            for (int j = 0; j < bytes.length; j++) { // бежим по всем битам каждой буквы и записываем их в 1 младший бит каждого байта исходных данных
                if (offset < data.length) {
                    data[offset] = (byte) ((data[offset] & 0xFE) | (bytes[j] - 48)); // запись LSB, 48 - код симовла 0 в ASCI
                    offset++; //                         0xFE = 1111 1110
                } else {
                    break;
                }
            }
        }
        File modifiedFile = new File(modifiedFileName);
        FileOutputStream outputStream = new FileOutputStream(modifiedFileName);
        try {
            outputStream.write(header);
            outputStream.write(data);
        } finally {
            outputStream.close();
        }
    }
    public static String readLSB(String fileName) throws IOException {
        File file = new File(fileName);
        FileInputStream inputStream = new FileInputStream(file);
        byte[] header = new byte[HEADER_SIZE];
        byte[] data = new byte[(int)file.length() - HEADER_SIZE];
        int offset;
        String message = "";

        try {
            inputStream.read(header); // чтение заголовка
            offset = byteArrayToInt(header, OFFSET_SIZE); // получение смещения
            inputStream.read(data); // чтение данных
        } finally {
            inputStream.close();
        }

        for (int i = 0; i < length; i++) {
            byte[] bytes = new byte[7];
            for (int j = 0; j < 7; j++) {
                bytes[j] = (byte)(data[offset++] & 0x01);
                bytes[j] += 48;
            }
            String temp = new String(bytes);
            message += (char)Integer.parseInt(temp, 2);
        }

        return message;
    }

    // Метод для конвертирования четырехбайтового массива в целое число
    private static int byteArrayToInt(byte[] bytes, int offset) {
        int value = 0;
        for (int i = 0; i < 4; i++) {
            value |= (bytes[offset + i] & 0xFF) << (i * BYTE_SIZE);
        }
        return value;
    }

    public static void main(String[] args) throws IOException {
        String input = "C:\\Univer\\FKP\\6sem\\KIOKI\\labs\\lab2-6\\lab6\\src\\main\\resources\\sample1.bmp";
        String output = "C:\\Univer\\FKP\\6sem\\KIOKI\\labs\\lab2-6\\lab6\\src\\main\\resources\\sample2.bmp";
        String message = "shdfkjjskdf";
        writeLSB(input, message, output);
        String res = readLSB(output);
        System.out.println(res);
    }
}
