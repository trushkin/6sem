package by.bsuir.listeners;

import by.bsuir.FileService;
import jakarta.ejb.ActivationConfigProperty;
import jakarta.ejb.MessageDriven;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

@MessageDriven(activationConfig = {
        @ActivationConfigProperty(
                propertyName = "destination",
                propertyValue = "queueToAdd"),
        @ActivationConfigProperty(
                propertyName = "destinationType",
                propertyValue = "jakarta.jms.Queue")
})
public class AddMessageQueueListener implements MessageListener {
    private static Logger logger = LogManager.getLogger(AddMessageQueueListener.class);
    @Override
    public void onMessage(Message message) {
        try {
            logger.info("Received message to write to file with " + message.getJMSCorrelationID());
            new FileService("queue-file.txt").writeToFile(message.getBody(String.class));
        } catch (JMSException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
