package by.bsuir;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.SecureRandom;

public class RDS {
    private static BigInteger e;
    private static BigInteger d;
    private static BigInteger r;

    public static void main(String[] args) throws IOException {
        byte[] sourceMessage = readMessageFromFile("C:\\Univer\\FKP\\6sem\\KIOKI\\labs\\lab2-6\\lab5\\src\\main\\resources\\1.txt");
        int hash = pjw32Hash(sourceMessage);
        findEDR();
        System.out.println("HASH = " + hash);
        BigInteger s = makeDigitalSignature(hash, d, r);
        System.out.println("DIGITAL SIGNATURE = " + s);

        BigInteger m1 = getHashFromDigitalSignature(s, e, r);
        byte[] resultMessage = readMessageFromFile("C:\\Univer\\FKP\\6sem\\KIOKI\\labs\\lab2-6\\lab5\\src\\main\\resources\\2.txt");
        int m2 = pjw32Hash(resultMessage);
        System.out.println("SOURCE HASH = " + m1);
        System.out.println("GENERATED HASH = " + m2);
        System.out.println(m1.compareTo(BigInteger.valueOf(m2)) == 0);
    }

    private static BigInteger makeDigitalSignature(int hash, BigInteger d, BigInteger r) {
        return BigInteger.valueOf(hash).modPow(d, r);
    }

    private static BigInteger getHashFromDigitalSignature(BigInteger s, BigInteger e, BigInteger r) {
        return s.modPow(e, r);
    }

    private static byte[] readMessageFromFile(String fileName) throws IOException {
        return Files.readAllBytes(Paths.get(fileName));
    }

    private static int pjw32Hash(byte[] message) {
        int hash = 0;
        for (int temp_byte : message) {
            hash = (hash << 4) + temp_byte;
            int h1 = hash & 0xf0000000;
            if (h1 != 0) {
                hash = ((hash ^ (h1 >> 24)) & (0xfffffff));
            }
        }
        return Math.abs(hash);
    }

    private static void findEDR() {
        int size = 22;
        SecureRandom random = new SecureRandom();
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
    }
}