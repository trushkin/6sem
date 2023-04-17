package by.bsuir.listeners;

import by.bsuir.FileService;
import jakarta.ejb.ActivationConfigProperty;
import jakarta.ejb.MessageDriven;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@MessageDriven(activationConfig = {
        @ActivationConfigProperty(
                propertyName = "destination",
                propertyValue = "queueToDelete"),
        @ActivationConfigProperty(
                propertyName = "destinationType",
                propertyValue = "jakarta.jms.Queue")
})
public class RemoveMessageQueueListener implements MessageListener {
    private static Logger logger = LogManager.getLogger(RemoveMessageQueueListener.class);
    @Override
    public void onMessage(Message message) {
        try {
            logger.info("Received message to delete from file with " + message.getJMSCorrelationID());
            new FileService("queue-file.txt").deleteMessageFromFile(message.getBody(String.class));
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }
}
