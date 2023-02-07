package by.bsuir.algorithms;

public class MonoalphabeticSimple implements Cryptography {
    @Override
    public String encryption(String message, int key, char firstCharAlphabet, char lastCharAlphabet) throws RuntimeException {
        if (firstCharAlphabet > lastCharAlphabet) {
            throw new RuntimeException("Invalid input parameters! Issue with alphabet");
        }
        StringBuilder encryptedMessage = new StringBuilder(message.length());
        char currentSymbol;
        int offset;
        int alphabetLength = (lastCharAlphabet - firstCharAlphabet) + 1;
        for (int i = 0; i < message.length(); i++) {
            if (Character.isLetter(message.charAt(i))) {
                currentSymbol = message.charAt(i);
                //  symbolCodeAfterEncryption = (char) (currentSymbol + key % alphabetLength);
                offset =  ((currentSymbol - firstCharAlphabet + key)) % alphabetLength;
//                    if (symbolCodeAfterEncryption < firstCharAlphabet) {
//                        encryptedMessage.append((char) (symbolCodeAfterEncryption + alphabetLength));
//                    } else if (symbolCodeAfterEncryption > lastCharAlphabet) {
//                       // encryptedMessage.append((char) (symbolCodeAfterEncryption % lastCharAlphabet + firstCharAlphabet - 1));
//                        encryptedMessage.append((char) (symbolCodeAfterEncryption - alphabetLength));
//                    } else {
                encryptedMessage.append((char)(firstCharAlphabet + offset));
                //}
            } else {
                throw new RuntimeException("Invalid message! Use symbols " + firstCharAlphabet + "-" + lastCharAlphabet + "");
            }
        }
        return encryptedMessage.toString();
    }

    @Override
    public String decryption(String encryptedMessage, int key, char firstCharAlphabet, char lastCharAlphabet) throws RuntimeException {
        if (firstCharAlphabet > lastCharAlphabet) {
            return "Invalid input parameters! Issue with alphabet";
        }
        StringBuilder decryptedMessage = new StringBuilder(encryptedMessage.length());
        char currentSymbol;
        char symbolCodeAfterDecryption;
        int alphabetLength = (lastCharAlphabet - firstCharAlphabet) + 1;
        for (int i = 0; i < encryptedMessage.length(); i++) {
            if (Character.isLetter(encryptedMessage.charAt(i))) {
                currentSymbol = encryptedMessage.charAt(i);
                symbolCodeAfterDecryption = (char) (currentSymbol - key % alphabetLength);
                if (symbolCodeAfterDecryption < firstCharAlphabet) {
                    decryptedMessage.append((char) (symbolCodeAfterDecryption + alphabetLength));
                } else if (symbolCodeAfterDecryption > lastCharAlphabet) {
                    decryptedMessage.append((char) (symbolCodeAfterDecryption - alphabetLength));
                } else {
                    decryptedMessage.append(symbolCodeAfterDecryption);
                }
            } else {
                return "Invalid message! Use symbols " + firstCharAlphabet + "-" + lastCharAlphabet + "";
            }
        }
        return decryptedMessage.toString();
    }
}

