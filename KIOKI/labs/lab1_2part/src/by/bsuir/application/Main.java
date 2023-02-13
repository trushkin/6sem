package by.bsuir.application;

import by.bsuir.algorithms.MonoalphabeticComplex;
import by.bsuir.algorithms.MonoalphabeticSimple;

import java.util.Scanner;

public class Main {
    private static final String ENGLISH_ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) {
        System.out.print("Enter message: ");
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();
        MonoalphabeticSimple monoalphabeticSimple = new MonoalphabeticSimple();

        String encryptedMessage = monoalphabeticSimple.encrypt(message, 33, 'а', 'я');
        System.out.println("Encrypted message : " + encryptedMessage);
        String decryptedMessage = monoalphabeticSimple.decrypt(encryptedMessage, 33, 'а', 'я');
        System.out.println("Decrypted message: " + decryptedMessage);
        String response = message.equals(decryptedMessage) ? "Initial message equals decrypted" : "Error! Initial message NOT equals decrypted";
        System.out.println(response);

        System.out.println("================================\n Test message: " + ENGLISH_ALPHABET);
        encryptedMessage = monoalphabeticSimple.encrypt(ENGLISH_ALPHABET, 3, 'a', 'z');
        System.out.println("Encrypted message : " + encryptedMessage);
        decryptedMessage = monoalphabeticSimple.decrypt(encryptedMessage, 3, 'a', 'z');
        System.out.println("Decrypted message: " + decryptedMessage);
        response = ENGLISH_ALPHABET.equals(decryptedMessage) ? "Initial message equals decrypted" : "Error! Initial message NOT equals decrypted";
        System.out.println(response);

        System.out.println("================================\nEncryption method with multiplying\nTest message: " + ENGLISH_ALPHABET);
        encryptedMessage = new MonoalphabeticComplex().encrypt(ENGLISH_ALPHABET, 7, 'a', 'z');
        System.out.println("Encrypted message : " + encryptedMessage);
        decryptedMessage = new MonoalphabeticComplex().decrypt(encryptedMessage, 15, 'a', 'z');
        System.out.println("Decrypted message: " + decryptedMessage);
        response = ENGLISH_ALPHABET.equals(decryptedMessage) ? "Initial message equals decrypted" : "Error! Initial message NOT equals decrypted";
        System.out.println(response) ;
    }
}

