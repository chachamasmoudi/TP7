import javax.jms.*;
import org.apache.activemq.ActiveMQConnectionFactory;

public class JMSConsumer {
    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Connection connection = factory.createConnection();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Topic topic = session.createTopic("TP7.TOPIC");
        MessageConsumer consumer = session.createConsumer(topic);

        // Réception asynchrone via un listener
        consumer.setMessageListener(message -> {
            try {
                if (message instanceof TextMessage) {
                    System.out.println("Message reçu : " + ((TextMessage) message).getText());
                }
            } catch (JMSException e) {
                e.printStackTrace();
            }
        });

        connection.start();
        System.out.println("Consumer en attente de messages (Ctrl+C pour arrêter)...");
        Thread.currentThread().join();
    }
}