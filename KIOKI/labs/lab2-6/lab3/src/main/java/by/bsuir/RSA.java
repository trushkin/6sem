package by.bsuir;

import java.io.*;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Random;

public class RSA {
    private static BigInteger e;
    private static BigInteger d;
    private static BigInteger r;

    public static void main(String[] args) throws IOException {
        findEDR();
        encrypt("C:\\Univer\\FKP\\6sem\\KIOKI\\labs\\lab2-6\\lab3\\src\\main\\resources\\sourceMessage.txt", "C:\\Univer\\FKP\\6sem\\KIOKI\\labs\\lab2-6\\lab3\\src\\main\\resources\\encryptedMessage.txt", e, r);
        decrypt("C:\\Univer\\FKP\\6sem\\KIOKI\\labs\\lab2-6\\lab3\\src\\main\\resources\\encryptedMessage.txt", "C:\\Univer\\FKP\\6sem\\KIOKI\\labs\\lab2-6\\lab3\\src\\main\\resources\\decryptedMessage.txt", d, r);
    }

    private static void findEDR() {
        Random random = new Random();
        int size = 22;
        BigInteger p = BigInteger.probablePrime(size, random);
        BigInteger q = BigInteger.probablePrime(size, random);
        r = p.multiply(q);
        BigInteger f = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        do {
            e = new BigInteger(f.bitLength(), random);
        } while (e.compareTo(BigInteger.ONE) <= 0 || e.compareTo(f) >= 0 || !e.gcd(f).equals(BigInteger.ONE));
        d = e.modInverse(f);
        if (d.compareTo(BigInteger.ONE) <= 0) {
            d = d.add(f);
        }
        System.out.print("p = " + p + ", q = " + q + ", r = " + r + ", f = " + f + ", e = " + e + ", d = " + d + "\n");
    }

    private static int[] readBytes(String fileName) throws IOException {
        byte[] array = Files.readAllBytes(Paths.get(fileName));
        int[] resArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            resArray[i] = (array[i] + 256) % 256;
        }
        return resArray;
    }

    private static void writeDigitsToFile(String fileName, BigInteger[] array) throws IOException {
        File file = new File(fileName);
        FileWriter fw = new FileWriter(file);
        for (BigInteger el : array) {
            fw.write(el + " ");
        }
        fw.close();
    }

    private static void encrypt(String fromFile, String toFile, BigInteger e, BigInteger r) throws IOException {
        int[] bytes = readBytes(fromFile);
        BigInteger[] res = new BigInteger[bytes.length];
        System.out.println(Arrays.toString(bytes));
        for (int i = 0; i < bytes.length; i++) {
            res[i] = BigInteger.valueOf(bytes[i]).modPow(e, r);
        }
        writeDigitsToFile(toFile, res);
    }

    private static String[] readDigitsFromFile(String fileName) throws IOException {
        FileReader fr = new FileReader(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        int c;
        while ((c = fr.read()) != -1) {
            stringBuilder.append((char) c);
        }
        fr.close();
        return stringBuilder.toString().split(" ");
    }

    private static void writeDecryptedTextToFile(String fileName, byte[] res) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        fileOutputStream.write(res);
        fileOutputStream.close();
    }

    private static void decrypt(String fromFile, String toFile, BigInteger d, BigInteger r) throws IOException {
        String[] array = readDigitsFromFile(fromFile);
        byte[] res = new byte[array.length];
        for (int i = 0; i < array.length; i++) {
            res[i] = new BigInteger(array[i]).modPow(d, r).byteValue();
        }
        writeDecryptedTextToFile(toFile, res);
    }
}