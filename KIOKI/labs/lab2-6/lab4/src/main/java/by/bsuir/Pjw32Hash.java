package by.bsuir;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Pjw32Hash {

    public static void main(String[] args) throws IOException {
        System.out.println("BSUIY = " + pjw32Hash("BSUIY"));
        String hash = hashFile("C:\\Univer\\FKP\\6sem\\KIOKI\\labs\\lab2-6\\lab4\\src\\main\\resources\\sourceMessage.txt");
        writeHashToFile("C:\\Univer\\FKP\\6sem\\KIOKI\\labs\\lab2-6\\lab4\\src\\main\\resources\\hash.txt", hash);
        System.out.println("Hash text = " + hash);
    }


    private static String pjw32Hash(String message) {
        int hash = 0;
        for (int i = 0; i < message.length(); i++) {
            int byte_of_data = message.charAt(i);
            hash = (hash << 4) + byte_of_data;
            int h1 = hash & 0xf0000000;
            if (h1 != 0) {
                hash = ((hash ^ (h1 >> 24)) & (0xfffffff));
            }
        }
        return "0x" + String.format("%8s", Integer.toHexString(hash)).replace(' ', '0').toUpperCase();
    }

    private static String hashFile(String fileName) throws IOException {
        FileReader fr = new FileReader(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        int c;
        while ((c = fr.read()) != -1) {
            stringBuilder.append((char) c);
        }
        fr.close();
        return pjw32Hash(stringBuilder.toString());
    }

    private static void writeHashToFile(String fileName, String hash) throws IOException {
        File file = new File(fileName);
        FileWriter fw = new FileWriter(file);
        fw.write(hash);
        fw.close();
    }
}

