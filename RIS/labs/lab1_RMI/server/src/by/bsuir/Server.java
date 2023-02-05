package by.bsuir;

import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server{
    private static final int PORT = 1087;
    public static void main(String args[]) {
        try {
// создаем и экспортируем удаленный объект
            ConvertToRomanImpl convertToRoman = new ConvertToRomanImpl();
            ConvertToRoman stub = (ConvertToRoman)  UnicastRemoteObject.exportObject(convertToRoman, 0);
// Регистрируем удаленный объект в RMI-регистраторе под именем
            Registry registry = LocateRegistry.createRegistry(PORT);
            registry.bind("by.bsuir.ConvertToRoman", stub);
            System.err.println("by.bsuir.Server ready");
        } catch (Exception e) {
            System.err.println("by.bsuir.Server exception: " + e.toString());
            e.printStackTrace();
        }
    }


}
