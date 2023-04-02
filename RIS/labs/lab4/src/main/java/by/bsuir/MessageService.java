package by.bsuir;

import jakarta.ejb.Local;
import jakarta.jms.JMSException;

import java.util.List;

@Local
public interface MessageService {
    public void addString(String message) throws JMSException;
    public void removeString(String message) throws JMSException;

    public List<String> getAllMessages();
}
