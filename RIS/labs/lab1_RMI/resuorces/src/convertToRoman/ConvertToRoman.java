package convertToRoman;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ConvertToRoman extends Remote {
    String toRoman(int number) throws RemoteException;
}
