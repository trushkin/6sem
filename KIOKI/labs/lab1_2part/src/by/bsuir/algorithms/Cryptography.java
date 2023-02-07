package by.bsuir.algorithms;

public interface Cryptography {
    String encryption(String message, int key, char firstCharAlphabet, char lastCharAlphabet) throws RuntimeException;
    String decryption(String encryptedMessage, int key, char firstCharAlphabet, char lastCharAlphabet) throws RuntimeException;
}
