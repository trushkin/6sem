package by.bsuir.algorithms;

public class MonoalphabeticComplex implements Cryptography {
    @Override
    public String encrypt(String message, int key, char firstCharAlphabet, char lastCharAlphabet) throws RuntimeException {
        if (firstCharAlphabet > lastCharAlphabet) {
            throw new RuntimeException("Invalid input parameters! Issue with alphabet");
        }
        StringBuilder encryptedMessage = new StringBuilder(message.length());
        char currentSymbol;
        char offset;
        int alphabetLength = (lastCharAlphabet - firstCharAlphabet) + 1;
        for (int i = 0; i < message.length(); i++) {
            if (Character.isLetter(message.charAt(i))) {
                currentSymbol = message.charAt(i);
                offset = (char) (((currentSymbol - firstCharAlphabet) * key) % alphabetLength);
                encryptedMessage.append((char) (firstCharAlphabet + offset));
            } else {
                throw new RuntimeException("Invalid message! Use symbols " + firstCharAlphabet + "-" + lastCharAlphabet + "");
            }
        }
        return encryptedMessage.toString();
    }

    @Override
    public String decrypt(String message, int key, char firstCharAlphabet, char lastCharAlphabet) throws RuntimeException {

        if (firstCharAlphabet > lastCharAlphabet) {
            throw new RuntimeException("Invalid input parameters! Issue with alphabet");
        }
        StringBuilder encryptedMessage = new StringBuilder(message.length());
        char currentSymbol;
        char offset;
        int alphabetLength = (lastCharAlphabet - firstCharAlphabet) + 1;
        for (int i = 0; i < message.length(); i++) {
            if (Character.isLetter(message.charAt(i))) {
                currentSymbol = message.charAt(i);
                offset = (char) (((currentSymbol - firstCharAlphabet) * key) % alphabetLength);
                encryptedMessage.append((char) (firstCharAlphabet + offset));
            } else {
                throw new RuntimeException("Invalid message! Use symbols " + firstCharAlphabet + "-" + lastCharAlphabet + "");
            }
        }
        return encryptedMessage.toString();
    }
}
