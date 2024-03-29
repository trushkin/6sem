package by.bsuir;

import jakarta.annotation.Resource;
import jakarta.ejb.Stateless;
import jakarta.jms.Connection;
import jakarta.jms.ConnectionFactory;
import jakarta.jms.Destination;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.MessageProducer;
import jakarta.jms.Queue;
import jakarta.jms.Session;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

@Stateless
public class MessageServiceBean implements MessageService{
    @Resource
    private ConnectionFactory connectionFactory;

    @Resource(name = "queueToAdd")
    Queue queueToAdd;

    @Resource(name = "queueToDelete")
    Queue queueToDelete;
    private static Logger logger = LogManager.getLogger(MessageServiceBean.class);
    private Integer messageId = 0;

    private void sendMessage(String text, Destination destination) throws JMSException {
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession();
        Message message = session.createTextMessage(text);
        MessageProducer messageProducer = session.createProducer(destination);
        message.setJMSCorrelationID("ID: " + (++messageId));
        logger.info("Send message with " + message.getJMSCorrelationID());
        messageProducer.send(message);
        session.close();
        connection.close();
    }

    @Override
    public void addString(String message) throws JMSException {
        sendMessage(message, queueToAdd);
    }

    @Override
    public void removeString(String message) throws JMSException {
        sendMessage(message, queueToDelete);
    }

    @Override
    public List<String> getAllMessages() {
        return new FileService("queue-file.txt").getAllMessages();
    }
}
