package by.bsuir;

import by.bsuir.ConvertToRoman;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {
    private Client() {
    }

    public static void main(String[] args) {
        String port = (args.length < 1) ? null : args[0];
        try {
// Получаем стаб регистратора с хоста, определенного в командной строке
// если в командной строке хост не указывается, то он считается как localhost
            Registry registry = LocateRegistry.getRegistry(Integer.parseInt(port));
// получаем стаб удаленного объекта от регистратора сервера
            ConvertToRoman stub = (ConvertToRoman) registry.lookup("by.bsuir.ConvertToRoman");
            int arabicNum = readInt();
            String response = stub.toRoman(arabicNum);
            System.out.println(arabicNum + "\t = \t" + response);
        } catch (Exception e) {
            System.err.println("by.bsuir.Client exception: " + e.toString());
            e.printStackTrace();
        }
    }

    public static int readInt() {
        while (true) {
            try {
                System.out.print("Enter number: ");
                Scanner scanner = new Scanner(System.in);
                String arabicNum = scanner.nextLine();
                return Integer.parseInt(arabicNum);
            } catch (Exception e) {
                System.err.println("Invalid input, try again!");
            }
        }

    }
}
