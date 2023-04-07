package by.bsuir;

import jakarta.ejb.Local;
import jakarta.jms.JMSException;

import java.util.List;

@Local
public interface MessageService {
    void addString(String message) throws JMSException;
    void removeString(String message) throws JMSException;

    List<String> getAllMessages();
}
