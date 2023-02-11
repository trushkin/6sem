package convertToRoman;

import java.rmi.RemoteException;
import java.util.TreeMap;

public class ConvertToRomanImpl implements ConvertToRoman{
    private static final TreeMap<Integer, String> ROMAN_NUMBERS = new TreeMap<>();

    static {
        ROMAN_NUMBERS.put(1000, "M");
        ROMAN_NUMBERS.put(900, "CM");
        ROMAN_NUMBERS.put(500, "D");
        ROMAN_NUMBERS.put(400, "CD");
        ROMAN_NUMBERS.put(100, "C");
        ROMAN_NUMBERS.put(90, "XC");
        ROMAN_NUMBERS.put(50, "L");
        ROMAN_NUMBERS.put(40, "XL");
        ROMAN_NUMBERS.put(10, "X");
        ROMAN_NUMBERS.put(9, "IX");
        ROMAN_NUMBERS.put(5, "V");
        ROMAN_NUMBERS.put(4, "IV");
        ROMAN_NUMBERS.put(1, "I");
    }
    @Override
    public String toRoman(int number) throws RemoteException {
        // try convert number
        // if Converconverted -> return
        // else conversion exception -> throws remoteException
        // класс для конвертации, который бросает исключительные ситуации, а потом уже этот класс, который бросает remoteException
            int l =  ROMAN_NUMBERS.floorKey(number);
            if ( number == l ) {
                return ROMAN_NUMBERS.get(number);
            }
            return ROMAN_NUMBERS.get(l) + toRoman(number-l);
        }
}
