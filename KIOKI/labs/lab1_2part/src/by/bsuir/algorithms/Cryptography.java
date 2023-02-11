package by.bsuir.algorithms;

public interface Cryptography {
    String encrypt(String message, int key, char firstCharAlphabet, char lastCharAlphabet) throws RuntimeException;
    String decrypt(String encryptedMessage, int key, char firstCharAlphabet, char lastCharAlphabet) throws RuntimeException;
}
