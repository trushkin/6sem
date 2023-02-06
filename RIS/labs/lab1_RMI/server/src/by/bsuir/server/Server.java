package by.bsuir.server;
import convertToRoman.ConvertToRoman;
import convertToRoman.ConvertToRomanImpl;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server{
    private static final int PORT = 1087;
    public static void main(String args[]) {
        try {
            ConvertToRomanImpl convertToRoman = new ConvertToRomanImpl();
            ConvertToRoman stub = (ConvertToRoman)  UnicastRemoteObject.exportObject(convertToRoman, 0);
            Registry registry = LocateRegistry.createRegistry(PORT);
            registry.bind("convertToRoman.ConvertToRoman", stub);
            System.err.println("by.bsuir.server.Server ready");
        } catch (Exception e) {
            System.err.println("by.bsuir.server.Server exception: " + e.toString());
            e.printStackTrace();
        }
    }


}
